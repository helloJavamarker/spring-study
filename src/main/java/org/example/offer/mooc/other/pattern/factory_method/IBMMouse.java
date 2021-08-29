package org.example.offer.mooc.other.pattern.factory_method;

import org.example.offer.mooc.other.pattern.factory.entity.Mouse;

public class IBMMouse implements Mouse {
    @Override
    public void sayHi() {
        System.out.println("我是被联想收购的IBM鼠标");
    }
}
