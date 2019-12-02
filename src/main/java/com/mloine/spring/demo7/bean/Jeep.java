package com.mloine.spring.demo7.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *  @Author: XueYongKang
 *  @Description:    JSR250 提供的规范
 *  @Data: 2019/12/2 15:21
 */
@Component
public class Jeep {
    public Jeep(){
        System.out.println("Jeep ..................Constructor...............................");
    }

    @PostConstruct
    public void init(){
        System.out.println("Jeep ..................@PostConstruct...............................");

    }

    @PreDestroy
    public void destory(){
        System.out.println("Jeep ..................@PreDestroy...............................");

    }
}
