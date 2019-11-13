package com.mloine.spring.demo4.config;

import com.mloine.spring.demo1.entity.Persion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 *  @Author: XueYongKang
 *  @Description:     @Lazy
 *  @Data: 2019/11/13 15:52
 */
@Configuration
public class MloineConfig4 {
    /**
     * 懒加载：
     *      针对单实例bean：默认在容器启动的时候创建对象
     *      懒加载： 容器启动的时候不加载 仅当容器使用的时候初始化bean
     * @return
     */
    @Lazy
    @Bean
    public Persion persion(){

        System.out.println("给容器中添加persion");
        return new Persion("xueyongkang",24);
    }

}
