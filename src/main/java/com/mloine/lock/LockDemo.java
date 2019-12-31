package com.mloine.lock;

/*
 * @Author mloine
 * @Description //TODO
 *                 lock 使用
 * @Date 2:52 下午 2019/12/31
 **/
public class LockDemo {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(new MyThread()).start();
        }

    }



}
