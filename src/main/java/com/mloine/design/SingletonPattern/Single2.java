package com.mloine.design.SingletonPattern;

import sun.misc.Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 懒汉模式
 */
public class Single2 {

    //声明变量
    private static Single2 d;

    private static ReentrantLock lock = new ReentrantLock();

    //私有话构造方法
    private Single2(){};

    //对外统一提供方法
    public static Single2 getInstance(){
        //先判断dh是否已经被实例化，若未被实例化，先加锁保证线程安全
        if (d == null)
        {
           // lock (lockObject)
            lock.lock();
            {
                //先判断是否已经被实例化，若未被实例化，先实例化得到类的实例
                //保证类只被实例化一次
                if (d == null)
                {
                    d = new Single2();
                }
           }
            lock.unlock();
        }
        return d;
    }

    public static void main(String[] args) {
        Single2 instance = Single2.getInstance();
       Single2 instance2 =  Single2.getInstance();
        System.out.println("引用地址相同: 用一个实例"+(instance == instance2));
    }
}
