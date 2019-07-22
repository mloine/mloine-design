package com.mloine.design.pipelineMode;

/**
 * 管道接口
 */
public interface Pipeline {
    /**
     * 获取第一个阀门
     * @return
     */
    public Valve getFirst();

    /**
     * 获取基础阀门
     * @return
     */
    public Valve getBasic();

    /**
     * 设置基础阀门
     * @param v
     */
    public void setBasic(Valve v);


    /**
     * 添加阀门
     * @param v
     */
    public void addValue(Valve v);
}
