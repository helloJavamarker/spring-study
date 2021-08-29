package org.example.offer.mooc.other.pattern.factory_method;

public class FactoryMethodTest {
    // 定义一个用于创建对象的接口,让子类决定实例化哪一个类-----对类的实例化延迟到子类
    //满足开闭原则,满足单一职责

    //缺点: 类膨胀--成倍增长---鼠标和鼠标对应的工厂类
    public static void main(String[] args) {
        MouseFactory mf = new HpFacctory();
        System.out.println(mf.createMouse());
        mf.createMouse().sayHi();
    }
}
