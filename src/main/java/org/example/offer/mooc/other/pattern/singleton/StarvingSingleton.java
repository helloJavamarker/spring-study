package org.example.offer.mooc.other.pattern.singleton;

public class StarvingSingleton {
    //静态,初始化加载  private    final不能改变
    private static final StarvingSingleton STARVING_SINGLETON = new StarvingSingleton();
    //私有构造
    private StarvingSingleton() {}
    public static StarvingSingleton getInstance() {
        return STARVING_SINGLETON;
    }

    //反射创建的对象可以破解单例模式
}
