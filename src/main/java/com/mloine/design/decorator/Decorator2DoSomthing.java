package com.mloine.design.decorator;

public class Decorator2DoSomthing extends Decorator1DoSomething{




    public Decorator2DoSomthing(DoSomthing doSomthing) {
        super(doSomthing);
    }

    @Override
    public void doSomthing() {
        System.out.println("装饰者行为start ---------------------Decorator2DoSomthing------------------");
        super.doSomthing();
        System.out.println("装饰者行为end ---------------------Decorator2DoSomthing------------------");

    }
}
