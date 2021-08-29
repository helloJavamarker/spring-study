package org.example.offer.mooc.factory;

public interface BeanFactory {
    // beanFactory是spring容器的顶级接口,定义了bean工厂的基础功能,比如getBean,spring中bean都是通过这个接口的实现类来管理的
    // factoryBean本质也是一个bean,它的作用是可以生成bean

    //beanFactory是简单容器,applicationContext是高级容器,是BeanFactory的子接口,用户可通过这个接口自定义一些高级功能
    //applicationContext接口是只读的----只有读取的功能,要具有设置上下文的能力必须通过子接口来实现,经典的是configurableApplicationContext接口
    //最重要的子实现类是abstractApplicationContext
    //通过模板方法模式,让子类实现对父类的支持,或者提供父类的替换方法,来实现对扩展开放,对修改关闭

    //模板方法模式:微淘抽象类,实现通用逻辑,定义模板结构,部分逻辑由子类实现---基于继承的
    //相同业务的代码放到父类,也能复用代码

    //populateBean方法注入第三方包中,本来不受spring容器管理的bean

    //spring  resource接口也是顶层接口,只提供读操作,子类可以提供写操作   策略模式实现要具体用哪种资源

    //beanDefinitionReader 读取BeanDefinition,注册BeanDefinition  先创建BeanDefinition实例,再根据BeanDefinition创建bean实例
    //debug中可以使用frames的栈信息,往前追溯调用
    //委派模式
}
