package org.example.offer.mooc.other.generic;

public class GenericFactoryImpl implements GenericFactory<String, String> {
    @Override
    public String demo(String s) {
        return null;
    }

    @Override
    public <E> String demo2(String s) {
        return null;
    }

    //在泛型类中声明了一个泛型方法，使用泛型E，这种泛型E可以为任意类型。可以类型与T相同，也可以不同。
    //由于泛型方法在声明的时候会声明泛型<E>，因此即使在泛型类中并未声明泛型，编译器也能够正确识别泛型方法中识别的泛型。
    public <E> void show(E t){
        System.out.println(t.toString());
    }
}
