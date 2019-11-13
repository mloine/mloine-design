package com.mloine.spring.demo2.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 *  @Author: XueYongKang
 *  @Description:    自定义扫描包 过滤器
 *  @Data: 2019/11/13 15:12
 */
public class MloineTypeFilter implements TypeFilter {
    /**
     *
     * @param metadataReader 读取当前正在扫描类的信息
     * @param metadataReaderFactory 可以获取到其他任何类的信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        //1.获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        //2.获取当前正在扫描的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        //3.获取当前类资源(类路径)
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        System.out.println("-------->"+className);

        //是否加入容器的判断逻辑
        if(className.contains("er")){
            return true;
        }
        return false;
    }
}
