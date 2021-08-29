package org.example.offer.mooc.other.generic;

public class GenericFactoryImpl2 implements GenericFactory<String, Integer>{
    @Override
    public String demo(Integer integer) {
        return null;
    }

    @Override
    public <E> String demo2(Integer integer) {
        return null;
    }
}
