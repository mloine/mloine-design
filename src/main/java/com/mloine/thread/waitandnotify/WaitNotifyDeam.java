package com.mloine.thread.waitandnotify;

/**
 * @Author mloine
 * @Description  wait notify notifyAll 都是就对象而言的
 * @Date 1:38 下午 2020/1/5
 */
public class WaitNotifyDeam {

    private static Express ex = new Express();

    private static class WaitCityThread implements Runnable{
        @Override
        public void run() {
            ex.waitCity();
        }
    }

    private static class WaitLiChenThread implements Runnable{
        @Override
        public void run() {
            ex.waitKm();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new Thread(new WaitCityThread()).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(new WaitLiChenThread()).start();
        }
        Thread.sleep(1000);
//        ex.changeCity();
        ex.changeKm();
    }
}
