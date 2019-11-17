package com.mloine.spring.demo5.config;

import com.mloine.spring.demo1.entity.Persion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 *  @Author: XueYongKang
 *  @Description: 根据条件选择性注入bean
 *  @Data: 2019/11/13 15:52
 */
@Configuration
public class MloineConfig5 {

    @Bean("persion")
    public Persion persion(){
        System.out.println("给容器中添加persion");
        return new Persion("xueyongkang",24);
    }

    @Conditional(WinCondition.class)
    @Bean("mloine")
    public Persion mloine(){
        System.out.println("给容器中添加mloine");
        return new Persion("mloine",25);
    }

    @Conditional(LinuxCondition.class)
    @Bean("xyk")
    public Persion xyk(){
        System.out.println("给容器中添加xyk");
        return new Persion("xyk",13);
    }

}
