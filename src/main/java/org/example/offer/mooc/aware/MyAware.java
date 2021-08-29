package org.example.offer.mooc.aware;

import org.example.offer.mooc.annotation.Component;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Component
public class MyAware implements ApplicationContextAware, BeanNameAware {

    //一般bean是不需要对容器有操作的(不需要直接使用容器或者了解容器的状态),但是某些情况需要bean直接对容器进行操作
    //Aware接口是一个顶层接口,只是一个标记作用,要靠子接口来扩展

    private String beanName;
    private ApplicationContext context;
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

}
