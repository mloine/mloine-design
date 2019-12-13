package com.mloine.design.decorator;
/**
 *  @Author: XueYongKang
 *  @Description:    装饰着模式
 *  @Data: 2019/12/13 10:41
 */
public class Test {

    public static void main(String[] args) {

        DoSomthing doSomthing = new DoSomthing() {
            @Override
            public void doSomthing() {
                System.out.println("这是基本行为---------------");
            }
        };

        doSomthing.doSomthing();

        System.out.println("-----------------------------------------------分割线------------------------------------------");

        Decorator1DoSomething decorator1DoSomething = new Decorator1DoSomething(doSomthing);
        decorator1DoSomething.doSomthing();


        System.out.println("-----------------------------------------------分割线------------------------------------------");
        Decorator2DoSomthing decorator2DoSomthing = new Decorator2DoSomthing(doSomthing);
        decorator2DoSomthing.doSomthing();

    }
}
