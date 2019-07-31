package com.mloine.design.StrategyPattern;

public class OptionAdd implements Strategy{

    @Override
    public int doOption(int a, int b) {
        return a+b;
    }
}
