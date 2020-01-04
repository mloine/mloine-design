package com.mloine.thread;
/**
 * @Author mloine
 * @Description Synchronized 关键字 锁的是对象   可以保证数据的可见性 和 原子性
 * @Date 9:01 下午 2020/1/4
 */
public class SynchronizedAndInit {

    private static class SynThred implements Runnable {
        private SynchronizedAndInit it;

        public SynThred(SynchronizedAndInit it) {
            this.it = it;
        }

        @Override
        public void run() {
            try {
                it.doSome1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class SynThred1 implements Runnable{

        @Override
        public void run() {
            try {
                doSome2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    private synchronized void doSome1() throws InterruptedException {
            System.out.println("dothing 1 .................................."+Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("dothing 2 .................................."+Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("dothing 3 .................................."+Thread.currentThread().getName());
            Thread.sleep(3000);
    }
    private static synchronized void doSome2() throws InterruptedException {
            System.out.println("dothing 1 .................................."+Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("dothing 2 .................................."+Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("dothing 3 .................................."+Thread.currentThread().getName());
            Thread.sleep(3000);
    }

    public static void main(String[] args) {
        //1.锁对象不一样   没效果
//        new Thread(new SynThred(new SynchronizedAndInit())).start();
//        new Thread(new SynThred(new SynchronizedAndInit())).start();

        //2.锁对象一样
//        SynchronizedAndInit lockObj = new SynchronizedAndInit();
//        new Thread(new SynThred(lockObj)).start();
//        new Thread(new SynThred(lockObj)).start();

        //3. 类锁
        new Thread(new SynThred1()).start();
        new Thread(new SynThred1()).start();

    }
}
