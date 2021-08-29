package org.example.offer.mooc.other.pattern.singleton;

public class EnumStarvingSingleton {
    //枚举不仅可以防止通过反射来破坏单例,也能防止通过序列化和反序列化破坏单例模式
    private EnumStarvingSingleton() {}
    public static EnumStarvingSingleton getInstance() {
        return ConainerHolder.HOLDER.instance;
    }
    private enum ConainerHolder {
        HOLDER;
        private EnumStarvingSingleton instance;

        //private 冗余,可以不加
        private ConainerHolder() {
            instance = new EnumStarvingSingleton();
        }
    }
}
