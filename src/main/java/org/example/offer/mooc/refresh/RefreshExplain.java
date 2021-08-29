package org.example.offer.mooc.refresh;

public class RefreshExplain {
    //prepareRefresh 准备工作
    //obtainFreshBeanFactory 获取子类刷新后的内部BeanFactory实例
    //prepareBeanFactory 为容器注册必要的系统级别的bean
    //postProcessBeanFactory允许同期的子类注册postProcessor  钩子方法
    //invokeBeanFactoryPostProcessors 调用容器级别的后置处理器
    //registerBeanPostProcessors向容器注册bean级别的后置处理器
    //initMessageSource初始化国际化划配置
    //initApplicationEventMulticaster 初始化时间发布者组件
    //onRefresh 单例bean初始化前预留给子类初始化其他特殊bean的口子
    //registerListeners向前面的事件发布者组件注册事件监听者
    //finishBeanFactoryInitialization设置系统级别的服务,实例化所有非懒加载的单例
    //finishRefresh触发初始化完成的回调方法,并发布容器刷新完成的事件给监听者
    //resetCommonCaches充值spring内核中的共用缓存


    //同步--异步
    //if(executor != null)说明需要线程池异步执行

    //依赖注入   getBean
//    doGetBean 执行步骤
    // 尝试从缓存中获取bean
    //循环依赖的判断
    //递归去父同期获取bean实例
    //从当前容器获取BeanDefinition实例
    //递归实例化显示依赖的bean   是否设置了depends-on,设置了这个属性,则表名该实例要在另一个实例实例化后创建---显示循环依赖会报错  A depends-on B  B depends-on A
    //根据不同的scope采用不同的策略创建bean实例
    //对bean进行类型检查

    //关于循环依赖
    //半成品bean放到earlyBeanMap里面  concurrentHashMap
    //成品放到singletonObject或者singletonFactories里面
    //对象只能存在于三级缓存里的某一个里面

    //各种postProcessor基本都是用的责任链模式


}
