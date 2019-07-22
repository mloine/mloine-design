package com.mloine.design.templatepattern;

/**
 * 定义行为骨架
 */
public abstract class DodishTemplate {

    protected void doFather(){
        System.out.println("模板类 固有行为");
    }


    /**
     * 具体的整个过程
     */
    protected void dodish(){
        System.out.println("骨架行为开始start---");
        this.preparation();
        this.doing();
        this.carriedDishes();
        System.out.println("骨架行为结束end---");
    }
    /**
     * 备料
     */
    public abstract void preparation();
    /**
     * 做菜
     */
    public abstract void doing();
    /**
     * 上菜
     */
    public abstract void carriedDishes ();

}
