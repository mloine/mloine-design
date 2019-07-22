package com.mloine.design.pipelineMode;

/**
 * 阀门接口
 */
public interface Valve {
    /**
     * 获取下一个阀门
     * @return
     */
    public Valve getNext();

    /**
     * 设置下一个阀门
     * @param v
     */
    public void setNext(Valve v);

    /**
     * 具体行为
     * @param s
     */
    public void invoke(String s);

}
