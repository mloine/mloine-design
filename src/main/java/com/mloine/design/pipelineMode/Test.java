package com.mloine.design.pipelineMode;

/**
 * 管道模式测试
 */
public class Test {

    public static void main(String[] args) {
        String s = "hello world!";

        MyPipeline myPipeline = new MyPipeline();
        BasicValve basic = new BasicValve();
        SecondValve secondValve = new SecondValve();
        ThirdValve thirdValve = new ThirdValve();
        //可插拔
        myPipeline.setBasic(basic);
        myPipeline.addValue(secondValve);
        myPipeline.addValue(thirdValve);

        myPipeline.getFirst().invoke(s);

    }
}
