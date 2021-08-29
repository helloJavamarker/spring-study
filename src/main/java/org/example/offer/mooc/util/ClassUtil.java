package org.example.offer.mooc.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@Slf4j(topic = "classUtil: ")
public class ClassUtil {

    private static String FILE_PROTOCOL = "file";
    /**
     * @param packageName 包名
     */
    public static Set<Class<?>> extractPackageClass(String packageName) {
        // 获取类的加载器
        ClassLoader classLoader = getClassLoader();
        //通过类的加载器获取到加载的资源信息

        URL url = classLoader.getResource(packageName.replace(".", "/"));
        if (url == null) {
            log.warn("unable to retrieve anything from package: " + packageName);
            return null;
        }
        //依据不同的资源类型,采用不同的方式获取资源的集合
        Set<Class<?>> classSet = null;
        if (FILE_PROTOCOL.equalsIgnoreCase(url.getProtocol())) {
            classSet = new HashSet<>();
            //url.getPath() 获取实际路径,可以在文件夹中显示
            File packageDirectory = new File(url.getPath());
            extractClassFile(classSet, packageDirectory, packageName);
        }
        // 其他类型资源,比如jar,war文件
        return classSet;
    }

    /**
     * 递归获取目标package里面的所有class文件(包括子package里面的class文件)
     * @param emptyClassSet 装载目标类的集合
     * @param fileSource 文件或者目录
     * @param packageName 包名
     * @return 类集合
     */
    private static void extractClassFile(Set<Class<?>> emptyClassSet, File fileSource, String packageName) {
        // 递归主要有两个注意的地方: 1是要能推进,2是能终止

        if (!fileSource.isDirectory()) {
            return;
        }
        // 如果是一个文件夹,则调用其listFiles方法获取文件夹下的文件或者文件夹
        File[] files = fileSource.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                } else {
                    //获取文件的绝对值路径
                    String absolutePath = file.getAbsolutePath();
                    //是.class,不是.java哦
                    if (absolutePath.endsWith(".class")) {
                        //如果是class文件,则直接加载---这里加载的不是这个文件本身,而是这个类实例,,所以提供一个方法
                        addToClassSet(absolutePath);
                    }
                }
                return false;
            }

            //根据class文件的绝对值路径,获取并生成class对象,并放入classSet中
            private void addToClassSet(String absolutePath) {
                //1 从class文件的绝对值路径力提取出包括了package的类名     内部类可以使用外部类的数据
                //注意反斜杠/或者\要替换成.   ---mac是/  win是\    File.separator java是跨平台的哦
                absolutePath = absolutePath.replace(File.separator, ".");
                String className = absolutePath.substring(absolutePath.indexOf(packageName));
                className = className.substring(0, className.lastIndexOf("."));
                //2 通过反射获取对应的class对象并加入到classSet中
                Class targetClass = loadClass(className);
                emptyClassSet.add(targetClass);

            }
        });
        //递归调用
        if (files != null) {  // 增强for要做好空值判断
            for (File file : files) {
                // 递归要向前
                extractClassFile(emptyClassSet, file, packageName);
//                extractClassFile(emptyClassSet, fileSource, packageName);
            }
        }
    }

    /**
     * 获取Class对象
     * @param className  class全名=package + 类名
     * @return
     */
    public static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.error("load class error:", e);
            throw new RuntimeException(e);
        }
    }

    //ClassLoader主要对类的请求提供服务，当JVM需要某类时，它根据名称向ClassLoader要求这个类，然后由ClassLoader返回 这个类的class对象。
    //ClassLoader负责载入系统的所有Resources（Class，文件，来自网络的字节流 等），通过ClassLoader从而将资源载入JVM。
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static void main(String[] args) {
        extractPackageClass("org.example.offer");
    }

    /**
     * 实例化class
     * @param clazz
     * @param accessible    是否支持创建私有的class对象实例
     * @param <T>
     * @return
     */
    public static <T> T newInstance(Class<?> clazz, boolean accessible) {
        //newInstance已经过时
//        clazz.newInstance()
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(accessible);
            return (T) constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param field
     * @param target
     * @param value 成员变量的值
     * @param accessible 是否设置私有成员变量
     */
    public static void setField(Field field, Object target, Object value, boolean accessible) {
        field.setAccessible(accessible);
        try {
            field.set(target, value);
        } catch (IllegalAccessException e) {
            log.error("setFiled error: " , e);
            throw new RuntimeException(e);
        }
    }
}
