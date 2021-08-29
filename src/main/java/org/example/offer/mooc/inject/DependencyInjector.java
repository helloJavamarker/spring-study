package org.example.offer.mooc.inject;

import lombok.extern.slf4j.Slf4j;
import org.example.offer.mooc.annotation.Autowired;
import org.example.offer.mooc.container.BeanContainer;
import org.example.offer.mooc.util.ClassUtil;
import org.example.offer.mooc.util.ValidationUtil;

import java.lang.reflect.Field;
import java.util.Set;

@Slf4j
public class DependencyInjector {

    private BeanContainer beanContainer;
    public DependencyInjector() {
        //返回单例对象
        beanContainer = BeanContainer.getInstance();
    }


    public void doIoc() {
        //1 遍历bean容器中所有的class对象
        if (ValidationUtil.isEmpty(beanContainer.getClasses())) {
            log.warn("empty classSet in beanContainer");
            return;
        }
        for (Class<?> clazz : beanContainer.getClasses()) {
            //2 遍历class对象的所有成员变脸
            Field[] fields = clazz.getDeclaredFields();
            if (ValidationUtil.isEmpty(fields)) {
                continue;
            }
            for (Field field : fields) {
                //3 找出被autowired标记的对象
                if (field.isAnnotationPresent(Autowired.class)) {
                    Autowired autowired = field.getAnnotation(Autowired.class);
                    String autowiredValue = autowired.value();
                    //4 获取这些成员变量的类型
                    Class<?> fieldClass = field.getType();
                    //5 获取这些成员变量的类型在容器中对应的实例
                    Object filedValue = getFieldInstance(fieldClass, autowiredValue);
                    if (filedValue == null) {
                        throw new RuntimeException("unanble to inject relevant type, target filedClass is:" + fieldClass.getName());
                    } else {
                        //6 通过反射将对象的成员变量实例注入到成员变量所在类的实例中
                        Object targetBean = beanContainer.getBean(fieldClass);
                        ClassUtil.setField(field, targetBean, filedValue, true);
                    }
                }
            }
        }
    }

    /**
     * 根据class在beanContainer里获取其实例或者实现类    接口对应的实现类
     * @param fieldClass
     * @return
     */
    private Object getFieldInstance(Class<?> fieldClass, String autowiredValue) {
        Object filedVaule = beanContainer.getBean(fieldClass);
        if (filedVaule != null) {
            //说明成员变量不是接口,而是实现类
            return filedVaule;
        } else {
            Class<?> implementsClass = getImplementClass(fieldClass, autowiredValue);
            if (implementsClass != null) {
                return beanContainer.getBean(implementsClass);
            } else {
                return null;
            }
        }
    }

    /**
     * 获取接口的实现类
     * @param fieldClass
     * @return
     */
    private Class<?> getImplementClass(Class<?> fieldClass, String autowiredValue) {
        Set<Class<?>> classSet = beanContainer.getClassesBySuper(fieldClass);
        if (ValidationUtil.isEmpty(classSet)) {
            if (ValidationUtil.isEmpty(autowiredValue)) {
                //默认的空串
                if (classSet.size() == 1) {
                    return classSet.iterator().next();
                } else {
                    throw new RuntimeException("multiple implements classes for " + fieldClass.getName());
                }
            } else {
                for (Class<?> clazz : classSet) {
                    if (autowiredValue.equals(clazz.getSimpleName())) {
                        return clazz;
                    }
                }
            }
        }
        return null;
    }
}
