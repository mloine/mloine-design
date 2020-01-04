package com.mloine.thread;
/**
 * @Author mloine
 * @Description 守护线程Daemon  finally语句块在守护线程中不一定执行！！！！！！
 *
 * @Date 1:59 下午 2020/1/2
 */
public class DaemonThread {

    private static class UseThread extends Thread{

        public UseThread(String userName) {
            super(userName);
        }

        @Override
        public void run() {

            String name = Thread.currentThread().getName();

            while (!isInterrupted()){//内部处理中断
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(name + "interrupted flag is "+ isInterrupted());
//                    Thread.interrupted();
                    interrupt();//cathch 时候需要手动在中断一下
                    e.printStackTrace();
                }finally {
                    System.out.println("finally 语句快执行.......");
                }
                System.out.println(name+"is runing .......");
            }
            System.out.println(name + "interrupted flag is "+ isInterrupted());
        }

    }


    public static void main(String[] args) throws InterruptedException {
        UseThread endThread = new UseThread("endThread");
        endThread.setDaemon(Boolean.TRUE);
        endThread.start();
        Thread.sleep(15);
//        endThread.interrupt();
        
    }





}
