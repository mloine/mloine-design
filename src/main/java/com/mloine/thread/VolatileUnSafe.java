package com.mloine.thread;

/**
 * @Author mloine
 * @Description volatile 只能保证数据的可见性 不能保证原子性
 *              常用场景：一个线程写  多个线程读的情况
 * @Date 9:27 下午 2020/1/4
 */
public class VolatileUnSafe {

    private static class VolatileVar implements Runnable{

        private volatile int num = 0;

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + ":..............."+ num);

            num = num + 1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num = num + 1;
            System.out.println(name + ":..............."+ num);
        }
    }

    public static void main(String[] args) {

        VolatileVar volatileVar = new VolatileVar();
        Thread thread1 = new Thread(volatileVar);
        Thread thread2 = new Thread(volatileVar);
        Thread thread3 = new Thread(volatileVar);
        Thread thread4 = new Thread(volatileVar);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
