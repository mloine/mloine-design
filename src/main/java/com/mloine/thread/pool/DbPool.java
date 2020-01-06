package com.mloine.thread.pool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @Author mloine
 * @Description 手写连接池 使用synchronized  和wait notifyAll
 * @Date 3:46 下午 2020/1/5
 */
public class DbPool {

    static LinkedList<Connection> lk = new LinkedList<>();

    public DbPool(int num) {

        for (int i = 0;i< num;i++){
            lk.add(new SqlConnectionImpl());
        }
    }

    public  Connection getConnection(Long waitTime) throws InterruptedException {
        synchronized (lk){
            if(waitTime < 0){
                while(lk.isEmpty()){
                    lk.wait();
                }
                return lk.removeFirst();
            }else{
                //等待到期时刻
                long overTime = System.currentTimeMillis() + waitTime;
                //需要等到的时间
                long needTime = waitTime;
                while(lk.isEmpty() && needTime > 0){
                    lk.wait(needTime);
                    needTime = overTime - System.currentTimeMillis();
                }

                Connection con = null;
                if(!lk.isEmpty()){
                    con = lk.removeFirst();
                }
                return con;
            }
        }
    }

    public  void releasConnection(Connection con){
        synchronized (lk){
            lk.addLast(con);
            lk.notifyAll();
        }
    }

}
