package org.example.offer.mooc.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Autowired {
    String value() default "";
}


//class MyController {
//    @Qualifier("Chinese") //指定注入多个实现类中的某一个
//    @Autowired
//    private Person person;
//}
//
//class Person{
//
//}
