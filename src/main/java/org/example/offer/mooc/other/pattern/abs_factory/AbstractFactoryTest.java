package org.example.offer.mooc.other.pattern.abs_factory;

public class AbstractFactoryTest {
    /// 提供一个创建一系列相关或相互依赖对象的接口---抽象工厂模式侧重的是同一产品族
    //假设鼠标和键盘必须成套使用解决了工厂模式值生产一种产品的弊端
    //新增一个产品族,只需要增加一个新的具体工厂,不需要修改代码

    //这是工厂方法的升级,
    //但是这里新增新产品依然不满足开闭原则,没有完全解决问题
    //spring是通过工厂模式+反射来解决的
    public static void main(String[] args) {
        ComputeFactory cf = new HpComputeFactory();
        cf.createKeyboard().sayHello();
        cf.createMouse().sayHi();

    }
}
