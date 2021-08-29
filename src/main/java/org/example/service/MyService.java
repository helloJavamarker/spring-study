package org.example.service;

import org.example.entity.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyService {
    public static void main(String[] args) {
//        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Teacher teacher = ((Teacher) context.getBean("teacher"));
        System.out.println(teacher);
    }
}
