package com.mloine.thread.threadutil;

import com.mloine.tools.SleepTools;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/**
 * @Author mloine
 * @Description CyclicBarrier   多个线程处理的结果 需要额外处理 在执行下一步 可以使用CyclicBarrier
 *
 *              多个业务线程需要协作执行处理完统一资源结果 才能执行下去
 * @Date 9:22 下午 2020/1/7
 */
public class UseCyclicBarrier {

    static CyclicBarrier cyclic = new CyclicBarrier(4,new AfterAction());

    //业务线程 处理的结果合并
    static int result;

    private static class BusThread implements Runnable{

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + "之前前置业务操作...........................");
            try {
                cyclic.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(name + "所有前置业务完成 result结果为"+result+" 执行自己后续业务...........................");

        }
    }


    private static class AfterAction implements Runnable{

        @Override
        public void run() {
            result = new Random().nextInt(100);
            SleepTools.second(2);
            System.out.println("执行AfterAction 统一处理合并数据 ...........................");
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i <= 3 ; i++) {
            new Thread(new BusThread()).start();
        }
    }
}
