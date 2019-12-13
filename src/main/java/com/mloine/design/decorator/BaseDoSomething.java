package com.mloine.design.decorator;
/**
 *  @Author: XueYongKang
 *  @Description:    行为约束
 *  @Data: 2019/12/13 10:14
 */
public abstract  class BaseDoSomething implements DoSomthing{

    public DoSomthing doSomthing;

    public BaseDoSomething(DoSomthing doSomthing) {
        this.doSomthing = doSomthing;
    }

    @Override
    public void doSomthing() {
        doSomthing.doSomthing();
    }

}
