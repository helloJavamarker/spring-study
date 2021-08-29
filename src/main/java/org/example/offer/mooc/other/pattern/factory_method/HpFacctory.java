package org.example.offer.mooc.other.pattern.factory_method;

import org.example.offer.mooc.other.pattern.factory.entity.HpMouse;
import org.example.offer.mooc.other.pattern.factory.entity.Mouse;

public class HpFacctory implements MouseFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }
}
