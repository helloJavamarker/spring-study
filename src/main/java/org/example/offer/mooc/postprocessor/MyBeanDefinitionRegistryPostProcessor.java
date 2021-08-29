package org.example.offer.mooc.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.Configuration;

/**
 *  允许在正常的BeanFactoryPostProcessor检测开始之前注册的更多的自定义BeanDefinition
 */
@Configuration
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        Class<UserBean> clazz = UserBean.class;
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
        GenericBeanDefinition definition = (GenericBeanDefinition) builder.getRawBeanDefinition();
        registry.registerBeanDefinition("user2", definition);
        //下面就可以通过applicationContext.getBean("user2")获得这个对象-----第三方框架注入
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

}

class UserBean{

}
