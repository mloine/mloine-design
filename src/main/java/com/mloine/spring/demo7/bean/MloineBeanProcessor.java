package com.mloine.spring.demo7.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 *  @Author: XueYongKang
 *  @Description: 前 后 置处理器
 *  @Data: 2019/12/2 15:11
 */
@Component
public class MloineBeanProcessor implements  BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 在初始化方法调用之前进行后置处理操作
        System.out.println("postProcessBeforeInitialization..............beanName:"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization...............beanName:"+beanName);
        return bean;
    }
}
