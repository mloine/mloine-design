package com.mloine.spring.demo7.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 *  @Author: XueYongKang
 *  @Description:   实现对应接口 做bean的初始化 和 销毁
 *  @Data: 2019/12/2 15:11
 */
@Component
public class Train implements InitializingBean, DisposableBean {

    public Train() {
        System.out.println("Train ...........................constructor........................");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Train ...............destroy..............");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Train ...............afterPropertiesSet..............");
    }

}
