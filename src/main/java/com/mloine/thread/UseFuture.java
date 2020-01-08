package com.mloine.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/**
 * @Author mloine
 * @Description FutureTask Callable 执行阻塞拿到线程返回值
 * @Date 12:34 下午 2020/1/8
 */
public class UseFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {

            int num;

            @Override
            public Integer call() throws Exception {
                String name = Thread.currentThread().getName();
                System.out.println(name + "计算总数开始......................");
                Thread.sleep(2000);
                for (int i = 0; i < 100; i++) {
                    num += i;
                }
                System.out.println(name + "计算总数结果" + num + "......................");

                return num;
            }
        });

        new Thread(futureTask).start();

        Thread.sleep(1000);

        if(new Random().nextBoolean()){
            System.out.println(Thread.currentThread().getName() + "拿到执行结果"+ futureTask.get());
        }else{
            //中断
            System.out.println(Thread.currentThread().getName() + "中断计算线程"+ futureTask.cancel(true));

        }

    }

}
