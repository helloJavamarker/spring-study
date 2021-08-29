package org.example.offer.mooc.other.pattern.abs_factory;

import org.example.offer.mooc.other.pattern.factory.entity.DellMouse;
import org.example.offer.mooc.other.pattern.factory.entity.Mouse;

public class DellComputeFactory implements ComputeFactory{
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public KeyBoard createKeyboard() {
        return new DellKeyBoard() ;
    }
}
