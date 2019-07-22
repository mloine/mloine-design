package com.mloine.design.pipelineMode;

/**
 * 阀门实现
 */
public class BasicValve implements Valve{

    protected Valve next;

    public Valve getNext() {
        return next;
    }

    public void setNext(Valve v) {
        next = v;
    }

    public void invoke(String s) {
        s = s + " 签名：mloine";
        System.out.println("after basic valve handled" +  s);
    }
}
