package com.mloine.thread;
/**
 * @Author mloine
 * @Description
 * @Date 1:59 下午 2020/1/2
 */
public class EndThread {

    private static class UseThread extends Thread{

        public UseThread(String userName) {
            super(userName);
        }

        @Override
        public void run() {
            super.run();
            String name = Thread.currentThread().getName();
            while (!isInterrupted()){//内部处理中断
//            while (true){
                System.out.println(name+"is runing .......");
            }
            System.out.println(name + "interrupted flag is "+ isInterrupted());
        }

    }


    public static void main(String[] args) throws InterruptedException {
        UseThread endThread = new UseThread("endThread");
        endThread.start();
        Thread.sleep(20);
        endThread.interrupt();
    }





}
