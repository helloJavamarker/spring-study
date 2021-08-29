package org.example.offer.mooc.util;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.Set;

public class ClassUtilTest {

    @DisplayName("提取目标类方法:extractPackageClassTest")
    @Test
    public void extractPackageClassTest() {
        Set<Class<?>> classSet = ClassUtil.extractPackageClass("org.example.offer.mooc.entity");
        System.out.println(classSet);
//        Assertions.assertEquals();
    }
}
