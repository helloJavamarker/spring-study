package org.example.offer.mooc.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanDefinitionRegistryPostProcessor,BeanFactoryPostProcessor是容器级别的处理器,BeanPostProcessor是bean级别的处理器
 */
public class MyPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //bean初始化前调用
        System.out.println(".....................");
        //每个bean初始化都会调用这里的方法   aop
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //bean初始化好后调用
        //在refresh方法中,使用责任链模式调用----如果一个对象不能处理,则交给下一个对象
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

}
