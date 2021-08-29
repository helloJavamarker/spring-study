package org.example.offer.mooc.container;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.offer.mooc.annotation.Component;
import org.example.offer.mooc.annotation.Controller;
import org.example.offer.mooc.annotation.Repository;
import org.example.offer.mooc.annotation.Service;
import org.example.offer.mooc.util.ClassUtil;
import org.example.offer.mooc.util.ValidationUtil;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@NoArgsConstructor(access = AccessLevel.PRIVATE) //私有构造
@Slf4j
public class BeanContainer {

    //CAS 红黑树
    private final Map<Class<?>, Object> beanMap = new ConcurrentHashMap<>();

    /**
     * 配置的管理
     */
    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION = Arrays.asList(Component.class, Service.class, Controller.class, Repository.class);

    public static BeanContainer getInstance() {
        //线程安全,懒加载,可以抵御反射和序列化入侵的单例
        return ContainerHolder.HOLDER.instance;
    }
    private enum ContainerHolder {
        HOLDER;
        private BeanContainer instance;
        ContainerHolder() {
            instance = new BeanContainer();
        }
    }

    //是否已经被加载
    private boolean loaded = false;

    public boolean isLoaded() {
        return loaded;
    }

    /**
     * 扫描加载所有的bean
     * @param packageName
     */
    public synchronized void loadBeans(String packageName) {
        // 判断是否已经加载过
        if (isLoaded()) {
            log.warn("container has bean loaded");
            return;
        }

        Set<Class<?>> classSet = ClassUtil.extractPackageClass(packageName);
//        if (classSet == null || classSet.size() == 0) {
        if (ValidationUtil.isEmpty(classSet)) {
            log.warn("extract nothing from packageName:" + packageName);
        }
        for (Class<?> clazz : classSet) {
            for (Class<? extends Annotation> annotation : BEAN_ANNOTATION) {
                //如果类上标注了以上注解
                if (clazz.isAnnotationPresent(annotation)) {
                    beanMap.put(clazz, ClassUtil.newInstance(clazz, true));
                }
            }
        }
    }

    /**
     * beanMap 是私有的,所以要获得容器大小,就要提供一个public方法
     * @return
     */
    public int size() {
        return beanMap.size();
    }


    /////////////////////////////////////////     操作bean容器      /////////////////////////////////////////////////
    /**
     * 添加bean到容器
     */
    public Object addBean(Class<?> clazz, Object bean) {
        return beanMap.put(clazz, bean);
    }

    public Object remove(Class<?> clazz) {
        return beanMap.remove(clazz);
    }

    public Object getBean(Class<?> clazz) {
        return beanMap.get(clazz);
    }

    public Set<Class<?>> getClasses() {
        return beanMap.keySet();
    }

    public Set<Object> getBeans() {
        return new HashSet<>(beanMap.values());
    }

    public Set<Class<?>> getClassesByAnnotation(Class<? extends Annotation> annotation) {
        Set<Class<?>> keySet = getClasses();
        if (ValidationUtil.isEmpty(keySet)) {
            log.warn("nothing in beanMap");
            return null;
        }
        HashSet<Class<?>> classSet = new HashSet<>();
        for (Class<?> clazz : keySet) {
            if (clazz.isAnnotationPresent(annotation)) {
                classSet.add(clazz);
            }
        }
        return classSet.size() > 0 ? classSet : null;
    }

    /**
     * 通过接口或者父类获取实现类或者子类的class集合,不包括其本身
     */
    public Set<Class<?>> getClassesBySuper(Class<?> interfaceClass) {
        Set<Class<?>> keySet = getClasses();
        if (ValidationUtil.isEmpty(keySet)) {
            log.warn("nothing in beanMap");
            return null;
        }
        //判断keySet里的元素是否是传入的接口或者类的子类,如果是,将其添加到classSet中
        HashSet<Class<?>> classSet = new HashSet<>();
        for (Class<?> clazz : keySet) {
            // 类似instance??    还要排除自己
            if (interfaceClass.isAssignableFrom(clazz) && ! clazz.equals(interfaceClass)) {
                classSet.add(clazz);
            }
        }
        return classSet.size() > 0 ? classSet : null;
    }

}
