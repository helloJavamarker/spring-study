package org.example.offer.mooc.other.pattern.factory.entity;

public class MouseFactory {
    public static Mouse createMouse(int type) {
        /**
         * 简单工厂适用场景:
         * 需要创建的对象比较少:if else比较少
         * 客户端不关心对象的创建过程---创建过程不符合开闭原则
         */
        switch (type) {
            case 0: return new DellMouse();
            case 1: return new HpMouse();
            default:  return new DellMouse();
        }
    }

    public static void main(String[] args) {
        System.out.println(MouseFactory.createMouse(1));
        System.out.println(MouseFactory.createMouse(0));
        System.out.println(MouseFactory.createMouse(2));
    }
}
