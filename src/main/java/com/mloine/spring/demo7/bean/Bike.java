package com.mloine.spring.demo7.bean;
/**
 *  @Author: XueYongKang
 *  @Description:
 *  @Data: 2019/12/2 14:14
 */
public class Bike {

    public Bike(){
        System.out.println("创建Bike Constructor ..................................");
    }

    public void init(){
        System.out.println("Bike ............................ init ..................................");
    }

    public void destory(){
        System.out.println("Bike ............................ destory ..................................");
    }
}
