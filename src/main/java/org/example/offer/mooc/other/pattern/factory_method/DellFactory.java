package org.example.offer.mooc.other.pattern.factory_method;

import org.example.offer.mooc.other.pattern.factory.entity.DellMouse;
import org.example.offer.mooc.other.pattern.factory.entity.Mouse;

public class DellFactory implements MouseFactory{
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }
}
