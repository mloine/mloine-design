package com.mloine.thread;
/**
 * @Author mloine
 * @Description ThreadLocal 每个线程单独维护一个副本
 * @Date 12:47 下午 2020/1/5
 */
public class UseThreadLocal {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    private static class UseThreadLocalThread implements Runnable{

        private Integer num;

        public UseThreadLocalThread(Integer num) {
            this.num = num;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + ":start ....");
            Integer integer = threadLocal.get();
            integer = integer + num;
            threadLocal.set(integer);
            System.out.println(name + "value: "+ threadLocal.get());
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            new Thread(new UseThreadLocalThread(i)).start();
        }
    }

}
