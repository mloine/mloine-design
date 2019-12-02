package com.mloine.spring.demo7.config;

import com.mloine.spring.demo1.entity.Persion;
import com.mloine.spring.demo7.bean.Bike;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *  @Author: XueYongKang
 *  @Description:    
 *  @Data: 2019/12/2 14:08
 */
@ComponentScan("com.mloine.spring.demo7.bean")
@Configuration
public class MloineConfig7 {

    @Bean("persion")
    public Persion persion(){
        System.out.println("给容器中添加persion");
        return new Persion("xueyongkang",24);
    }

//    @Scope("prototype")
    @Bean(initMethod = "init",destroyMethod = "destory")
    public Bike bike(){
        return  new Bike();
    }



}
