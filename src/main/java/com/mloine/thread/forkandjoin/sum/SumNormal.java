package com.mloine.thread.forkandjoin.sum;

public class SumNormal {

    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        int[] ints = MakeArray.makeArray();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < ints.length; i++) {
            Thread.sleep(1);
            count = count + ints[i];
        }
        long endTime = System.currentTimeMillis();

        System.out.println("this count is " + count + " spend time " + (endTime - startTime));


    }
}
