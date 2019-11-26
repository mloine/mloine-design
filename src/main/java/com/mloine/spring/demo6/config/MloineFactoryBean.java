package com.mloine.spring.demo6.config;

import com.mloine.spring.demo6.bean.Monkey;
import org.springframework.beans.factory.FactoryBean;
/**
 *  @Author: XueYongKang
 *  @Description:    
 *  @Data: 2019/11/26 16:27
 */
public class MloineFactoryBean implements FactoryBean<Monkey> {

    @Override
    public Monkey getObject() throws Exception {
        return new Monkey();
    }

    @Override
    public Class<?> getObjectType() {
        return Monkey.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
