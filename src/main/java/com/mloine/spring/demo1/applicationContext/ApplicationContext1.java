package com.mloine.spring.demo1.applicationContext;

import com.mloine.spring.demo1.entity.Persion;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  @Author: XueYongKang
 *  @Description: spring基于xml加载容器
 *  @Data: 2019/11/13 13:58
 */
public class ApplicationContext1 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext/beans.xml");

        Object person = app.getBean("person");

        Persion p = (Persion) person;

        System.out.println(p);
    }
}
