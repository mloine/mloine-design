package com.mloine.spring.demo1.applicationContext;


import com.mloine.spring.demo1.applicationContext.config.MloineConfig;
import com.mloine.spring.demo1.entity.Persion;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  @Author: XueYongKang
 *  @Description: spring基于配置类加载容器
 *  @Data: 2019/11/13 13:58
 */
public class ApplicationContext2 {

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext/beans.xml");

//        MloineConfig mloineConfig = new MloineConfig();
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MloineConfig.class);
        Object person = app.getBean("persion01");

        Persion p = (Persion) person;

        System.out.println(p);

        String[] beanNamesForType = app.getBeanNamesForType(Persion.class);
        for(String x:beanNamesForType){
            System.out.println(x);
        }
    }
}
