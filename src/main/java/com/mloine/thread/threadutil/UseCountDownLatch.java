package com.mloine.thread.threadutil;

import com.mloine.tools.SleepTools;

import java.util.concurrent.CountDownLatch;
/**
 * @Author mloine
 * @Description CountDownLatch 高级版本join 可以有多个前置线程
 *      主业务需要前置任务才能往下执行
 * @Date 9:02 下午 2020/1/7
 */
public class UseCountDownLatch {

    static CountDownLatch latch = new CountDownLatch(6);

    //初始化线程
    private static class InitThread implements Runnable{

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+"初始化线程执行框架初始化.......................");
            SleepTools.second(1);

            latch.countDown();

            for (int i=0;i<2;i++){
                System.out.println(threadName + "执行自己的业务操作..........................");
            }
        }
    }

    //主要框架线程
    private static class BusThread implements Runnable{

        @Override
        public void run() {
            String mainBusThread = "MainBussinessThread";
            Thread.currentThread().setName(mainBusThread);

            System.out.println(mainBusThread+"主业务线程程等待初始化.......................");

            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i=0;i<2;i++){
                System.out.println(mainBusThread + "执行主要业务操作..........................");
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new BusThread()).start();

        int i1 = 6;
        for (int i = 1; i <= i1; i++) {
            new Thread(new InitThread()).start();
        }
    }

}
