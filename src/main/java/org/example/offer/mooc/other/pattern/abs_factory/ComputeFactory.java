package org.example.offer.mooc.other.pattern.abs_factory;

import org.example.offer.mooc.other.pattern.factory.entity.Mouse;

public interface ComputeFactory {
    Mouse createMouse();
    KeyBoard createKeyboard();
}
