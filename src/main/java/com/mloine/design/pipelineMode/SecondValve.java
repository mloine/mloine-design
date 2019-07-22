package com.mloine.design.pipelineMode;

import java.util.Date;

/**
 * 阀门实现
 */
public class SecondValve implements Valve{

    protected Valve next;

    public Valve getNext() {
        return next;
    }

    public void setNext(Valve v) {
        next = v;
    }

    public void invoke(String s) {
        s = s + " 时间："+new Date().toString();
        System.out.println("after SecondValve valve handled" +  s);
        //必须写
        getNext().invoke(s);
    }
}
