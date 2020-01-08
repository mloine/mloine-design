package com.mloine.thread.threadutil.condition;

import java.util.Objects;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author mloine
 * @Description  Lock中的 Condition实现线程之前的等待唤醒
 * @Date 1:30 下午 2020/1/5
 */
public class ExpressCon {

    public static final String SHANGHAI = "shanghai";
    public static final String BEIJING = "beijing";
    public static final int INT = 100;


    private Lock ctLock = new ReentrantLock();
    private Lock kmLock = new ReentrantLock();
    private Condition ctCon = ctLock.newCondition();
    private Condition kmCon = kmLock.newCondition();

    private String city = SHANGHAI;

    private Integer liChen = 0;

    public  void changeCity(){
        ctLock.lock();
        try{
            city = BEIJING;
            ctCon.signal();
        }finally {
            ctLock.unlock();
        }

    }

    public   void changeKm(){
        kmLock.lock();
        try {
            liChen = 101;
            kmCon.signal();
//            kmCon.signalAll();
        }finally {
            kmLock.unlock();
        }
    }
    public  void waitCity(){
        ctLock.lock();
        try {
            while(!Objects.equals(city,BEIJING)){
                try {
                    ctCon.await();
                    String name = Thread.currentThread().getName();
                    System.out.println(name + "线程等待城市变化.......................");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() +" 线程唤醒 处理城市业务逻辑");
        }finally {
            ctLock.unlock();
        }

    }


    public  void waitKm(){
        kmLock.lock();
        try {
            while(liChen <= INT){
                try {
                    kmCon.await();
                    String name = Thread.currentThread().getName();
                    System.out.println(name + "线程等待公里变化.......................");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() +" 线程唤醒 处理里程业务逻辑");
        }finally {
            kmLock.unlock();
        }


    }
}
