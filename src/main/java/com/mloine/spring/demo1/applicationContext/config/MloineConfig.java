package com.mloine.spring.demo1.applicationContext.config;

import com.mloine.spring.demo1.entity.Persion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 *  @Author: XueYongKang
 *  @Description:
 *  @Data: 2019/11/13 14:19
 */
@Configuration
public class MloineConfig {
    /**
     * 可以指定bean的id
     * @return
     */
    @Bean(name = "abc")
    public Persion persion01(){
        return new Persion("xueyongkang",24);
    }
}
