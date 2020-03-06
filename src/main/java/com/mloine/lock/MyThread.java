package com.mloine.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @Author mloine
 * @Description //TODO
 * @Date 3:04 下午 2019/12/31
 **/
public class MyThread implements Runnable{

    //保持使用同一把锁 才能控制共享资源的安全
    private static Lock lock = new ReentrantLock();
//    private static Lock lock = new SelfLock();

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "执行业务代码 步骤1");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "执行业务代码 步骤2");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
