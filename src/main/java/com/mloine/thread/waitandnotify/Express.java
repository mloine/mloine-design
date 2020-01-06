package com.mloine.thread.waitandnotify;

import java.util.Objects;

/**
 * @Author mloine
 * @Description
 * @Date 1:30 下午 2020/1/5
 */
public class Express {

    public static final String SHANGHAI = "shanghai";
    public static final String BEIJING = "beijing";
    public static final int INT = 100;

    private String city = SHANGHAI;

    private Integer liChen = 0;

    public synchronized  void changeCity(){
        city = BEIJING;
//        notifyAll();
        notify();
    }

    public synchronized void waitCity(){
        while(!Objects.equals(city,BEIJING)){
            try {
                wait();
                String name = Thread.currentThread().getName();
                System.out.println(name + "线程等待城市变化.......................");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() +" 线程唤醒 处理城市业务逻辑");
    }

    public synchronized  void changeKm(){
        liChen = 101;
//        notifyAll();
        notify();
    }

    public synchronized void waitKm(){
        while(liChen <= INT){
            try {
                wait();
                String name = Thread.currentThread().getName();
                System.out.println(name + "线程等待公里变化.......................");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() +" 线程唤醒 处理里程业务逻辑");
    }
}
