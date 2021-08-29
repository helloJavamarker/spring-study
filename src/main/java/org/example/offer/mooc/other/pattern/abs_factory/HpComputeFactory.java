package org.example.offer.mooc.other.pattern.abs_factory;

import org.example.offer.mooc.other.pattern.factory.entity.HpMouse;
import org.example.offer.mooc.other.pattern.factory.entity.Mouse;

public class HpComputeFactory implements ComputeFactory{
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public KeyBoard createKeyboard() {
        return new HpKeyboard();
    }
}
