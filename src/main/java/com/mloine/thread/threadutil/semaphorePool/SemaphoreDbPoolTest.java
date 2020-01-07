package com.mloine.thread.threadutil.semaphorePool;


import java.sql.SQLException;
/**
 * @Author mloine
 * @Description
 * @Date 9:54 下午 2020/1/7
 */
public class SemaphoreDbPoolTest {

    private static class ConThread implements Runnable{

        SemaphoreDbPool con = null;

        public ConThread(SemaphoreDbPool con) {
            this.con = con;
        }

        @Override
        public void run() {
            try {
                SqlConnectionImpl sqlConnection = (SqlConnectionImpl) con.getConnection(160L);

                if(sqlConnection == null){
                    System.out.println("拿取连接失败.....................");

                }else{
                    System.out.println("拿取连接成功..................................................................");
                    sqlConnection.createStatement();
                    sqlConnection.commit();
                    con.releasConnection(sqlConnection);
                }

            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SemaphoreDbPool dbPool = new SemaphoreDbPool(10);

        for (int i = 0;i<1000;i++){
            new Thread(new ConThread(dbPool)).start();
        }
    }

}
