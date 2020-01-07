package com.mloine.thread.threadutil.semaphorePool;


import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * @Author mloine
 * @Description 手写连接池 使用Semaphore 信号量 实现线程池子
 * @Date 3:46 下午 2020/1/5
 */
public class SemaphoreDbPool {

    static LinkedList<Connection> lk = new LinkedList<>();

    private final Semaphore useful,useless;

    public SemaphoreDbPool(int num) {
        // 当前可使用的连接数信号量
        this.useful = new Semaphore(num);
        // 当前已经使用的连接数信号量
        this.useless = new Semaphore(0);

        for (int i = 0;i< num;i++){
            lk.add(new SqlConnectionImpl());
        }
    }

    public  Connection getConnection(Long waitTime) throws InterruptedException {
        useful.acquire();
        Connection connection ;
        synchronized (lk){
             connection = lk.removeFirst();
        }
        useless.release();
        return connection;
    }

    public  void releasConnection(Connection con) throws InterruptedException {
        if(con != null){

            useless.acquire();;
            System.out.println("当前正在等待的拿连接的线程数"+ useful.getQueueLength() + "     当前已经可用的连接数" + useful.availablePermits());

            synchronized (lk){
                lk.addLast(con);
            }
            useful.release();
        }
    }

}
