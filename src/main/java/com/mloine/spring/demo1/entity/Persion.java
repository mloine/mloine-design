package com.mloine.spring.demo1.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *  @Author: XueYongKang
 *  @Description:
 *  @Data: 2019/11/13 13:58
 */
@Getter
@Setter
@ToString
public class Persion {

    private String name;

    private Integer age;

    public Persion() {
    }

    public Persion(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
