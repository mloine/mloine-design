package com.mloine.thread.pool;

import java.sql.SQLException;

public class DbPollTest {

    private static class ConThread implements Runnable{

        DbPool con = null;

        public ConThread(DbPool con) {
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
        DbPool dbPool = new DbPool(10);

        for (int i = 0;i<1000;i++){
            new Thread(new ConThread(dbPool)).start();
        }
    }

}
