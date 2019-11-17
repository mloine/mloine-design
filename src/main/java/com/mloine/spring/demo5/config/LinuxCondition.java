package com.mloine.spring.demo5.config;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 *  条件判断器
 */
public class LinuxCondition implements Condition {

    /**
     *
     * @param context 判断条件可以使用的上下文
     * @param metadata 注解信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //是否windows
        //能够获取ioc容器正在个的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        //获取当前放入环境变量
        Environment environment = context.getEnvironment();
        String os_name = environment.getProperty("os.name");
        System.out.println("当前操作系统"+os_name);
        if(os_name.contains("linux")){
            return true;
        }

        return false;
    }

}
