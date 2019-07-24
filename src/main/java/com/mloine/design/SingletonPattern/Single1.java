package com.mloine.design.SingletonPattern;

/**
 * 单例模式实现1
 */
public class Single1 {

   //0.对外提供统一访问入口
    private static Single1 d = new Single1();

    //1.私有化构造函数
    private Single1(){};

    //2.对外统一提供实例
    public static Single1 getInstance(){
        return d;
    }

    public static void main(String[] args) {

        Single1 d = Single1.d;

    }
}
