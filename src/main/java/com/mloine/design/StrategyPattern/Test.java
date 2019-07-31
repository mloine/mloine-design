package com.mloine.design.StrategyPattern;

public class Test {

    public static void main(String[] args) {

        int a = 2;
        int b = 1;

        //+
        Strategy st = new OptionAdd();
        Context context = new Context(st);
        System.out.println(context.doOption(a,b));

        //*
        st = new OptionMultiply();
        context = new Context(st);
        System.out.println(context.doOption(a,b));

    }
}
