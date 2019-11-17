package com.mloine.spring.demo3.config;

import com.mloine.spring.demo1.entity.Persion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *  @Author: XueYongKang
 *  @Description: @Scope
 *         prototype  多实例   IOC初始化的时候不会创建实例bean 而是每次使用的时候才会创建bean
 *         singleton  单实例(默认)   初始化IOC容器的时候bean就已经创建完毕，并放到IOC容器中，以后每次获取拿到的都是容器中的同一个bean
 *         request    主要针对web应用 递交一次请求创建一次实例
 *         session    同一个会话的时候 创建一个实例
 *  @Data: 2019/11/13 15:33
 */
@Configuration
public class MloineConfig3 {
    /**
     * 	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * 	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON
     * 	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * 	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     * @return
     */
    @Scope(value = "prototype")
    @Bean
    public Persion persion(){
        return new Persion("xueyongkang",24);
    }

}
