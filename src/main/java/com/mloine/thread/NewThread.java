package com.mloine.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author mloine
 * @Description //启动线程的几种方式 线程之前协作式运行
 * @Date 1:14 下午 2020/1/2
 */
public class NewThread {


    //runable
    private static class UseRunable implements Runnable{

        @Override
        public void run() {
            System.out.println("I am implements Runable");
        }
    }

    //callable
     private static class UseCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("I am implements Callable");
            return "result";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        UseRunable useRunable = new UseRunable();
        new Thread(useRunable).start();

        UseCallable useCallable = new UseCallable();
        FutureTask<String> stringFutureTask = new FutureTask<>(useCallable);
        new Thread(stringFutureTask).start();
        String result = stringFutureTask.get();
        System.out.println(result);


        Thread thread = new Thread(useRunable);
        thread.stop();//线程停止不会释放资源 ！！！！！！！！！！
        thread.suspend();//线程挂起 不会释放资源！！！！！！！！
        thread.resume();// 不建议使用

        thread.interrupt();//中断一个线程 并不是强行关闭线程 flag改为true
        thread.isInterrupted();//当前线程是否处于中断状态、
        Thread.interrupted();//当前线程是否处于中断状态 flag 改为false


    }

}
