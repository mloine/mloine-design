package com.mloine.design.decorator;

public class Decorator1DoSomething extends BaseDoSomething{

    public Decorator1DoSomething(DoSomthing doSomthing) {
        super(doSomthing);
    }

    @Override
    public void doSomthing() {
        System.out.println("装饰者行为:Decorator1DoSomething-----------------------start-----------");
        super.doSomthing();
        System.out.println("装饰者行为:Decorator1DoSomething------------------------end----------");
    }
}
