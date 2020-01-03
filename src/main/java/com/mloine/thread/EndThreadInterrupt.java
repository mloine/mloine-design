package com.mloine.thread;
/**
 * @Author mloine
 * @Description interrupt catch住需要手动中断
 * @Date 1:59 下午 2020/1/2
 */
public class EndThreadInterrupt {

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
                }
                System.out.println(name+"is runing .......");
            }
            System.out.println(name + "interrupted flag is "+ isInterrupted());
        }

    }


    public static void main(String[] args) throws InterruptedException {
        UseThread endThread = new UseThread("endThread");
        endThread.start();
        Thread.sleep(500);
        endThread.interrupt();
    }





}
