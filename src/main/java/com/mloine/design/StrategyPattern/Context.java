package com.mloine.design.StrategyPattern;

public class Context {

    private Strategy st;

    public Context(Strategy st) {
        this.st = st;
    }

    public int doOption(int a,int b){
        return st.doOption(a,b);
    }
}
