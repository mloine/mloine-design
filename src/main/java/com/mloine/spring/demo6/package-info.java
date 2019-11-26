package com.mloine.spring.demo6;

/**
 *      spring注入方式
 *          1.@Bean: 导入第三方组件或包
 *          2.包扫描+组件的标注注解(@ComponentScan:   @Controller @Service @Responsitory    @Componet),一般针对自己写的类
 *          3.@Import：【快速给容器导入一个组件】 注意@Bean 有点简单
 *                      a.@Import(要导入到容器中的组件)：容器会自动注册组件，bean的id为全类名
 *                      b.ImportSelector:是一个接口，返回需要导入到容器的组件的全类型数组
 *                      c.ImportBeanDefinitionRegistrar: 可以手动添加组件到IOC容器,所有bean的注册可以使用ImportBeanDefinitionRegistrar接口
 *          4.使用Spring提供的 FactoryBean 注册
 *
 **/