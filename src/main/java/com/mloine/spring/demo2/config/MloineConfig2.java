package com.mloine.spring.demo2.config;

import com.mloine.spring.demo1.entity.Persion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 *  @Author: XueYongKang
 *  @Description:    @ComponentScan 扫描包路径
 *
 *  注意
 *  包含规则 includeFilters   配合useDefaultFilters = false
 *  排除规则 excludeFilters   配合useDefaultFilters = true
 *  @Data: 2019/11/13 14:40
 */
@Configuration
@ComponentScan(value = "com.mloine.spring.demo2",includeFilters = {
       // @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {OrderController.class})
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MloineTypeFilter.class})

},useDefaultFilters = false)
public class MloineConfig2 {

    @Bean
    public Persion persion01(){
        return new Persion("xueyongkang",24);
    }
}
