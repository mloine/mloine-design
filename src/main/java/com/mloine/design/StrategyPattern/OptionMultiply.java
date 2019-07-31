package com.mloine.design.StrategyPattern;

public class OptionMultiply implements Strategy{
    @Override
    public int doOption(int a, int b) {
        return a*b;
    }
}
