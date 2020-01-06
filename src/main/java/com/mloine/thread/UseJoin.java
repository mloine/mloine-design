package com.mloine.thread;

/**
 * @Author mloine
 * @Description jion 做线程的插入执行   形象插队 可以让线程串行执行
 * @Date 4:37 下午 2020/1/5
 */
public class UseJoin {

    private static class JoinThread implements Runnable{

        private Thread th;

        public JoinThread(Thread th) {
            this.th = th;
        }

        @Override
        public void run() {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行本线程："+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread = Thread.currentThread();
        Thread pri = thread;
        for(int i=0 ;i<100;i++){
            Thread thread1 = new Thread(new JoinThread(pri));
            System.out.println(pri.getName() + "jump " + thread1.getName());
            thread1.start();
            pri = thread1;
        }

        Thread.sleep(2000);
        System.out.println(thread.getName() + "执行完毕");

    }
}
