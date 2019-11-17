package com.mloine.spring.demo6.config;

import com.mloine.spring.demo1.entity.Persion;
import com.mloine.spring.demo6.bean.Cat;
import com.mloine.spring.demo6.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *  @Author: XueYongKang
 *  @Description:
 *          @Bean：【导入第三方】
 *          给容器中注入主键
 *          1.@Bean: 导入第三方组件或包
 *          2.包扫描+组件的标注注解(@ComponentScan:   @Controller @Service @Responsitory    @Componet),一般针对自己写的类
 *          3.@Import：【快速给容器导入一个组件】 注意@Bean 有点简单
 *                      a.@Import(要导入到容器中的组件)：容器会自动注册组件，bean的id为全类名
 *                      b.ImportSelector:是一个接口，返回需要
 *
 *  @Data: 2019/11/13 15:52
 */
@Configuration
@Import(value = {Dog.class, Cat.class})
public class MloineConfig6 {


    /**
     * 容器启动时候初始化persion的bean实例
     *
     *              @Bean:
     * @return
     */
    @Bean("persion")
    public Persion persion(){
        System.out.println("给容器中添加persion");
        return new Persion("xueyongkang",24);
    }




}
