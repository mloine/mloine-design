package com.mloine.spring.demo6.config;

import com.mloine.spring.demo6.bean.Pig;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MloineImportBeanDefinintionRegistor implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean b = registry.containsBeanDefinition("com.mloine.spring.demo6.bean.Dog");
        boolean a = registry.containsBeanDefinition("com.mloine.spring.demo6.bean.Cat");
        if(a && b){
            //封装成RootBeanDefinition
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Pig.class);
            registry.registerBeanDefinition("pig",beanDefinition);
        }
    }
}
