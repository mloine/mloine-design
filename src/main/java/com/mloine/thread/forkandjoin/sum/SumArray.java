package com.mloine.thread.forkandjoin.sum;

import com.mloine.tools.SleepTools;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @Author mloine
 * @Description
 * @Date 3:26 下午 2020/1/6
 */
public class SumArray {

    private static class SumTask extends RecursiveTask<Integer> {

        private static final int YUVALUE = MakeArray.INT/10;

        private int[] ints;

        private int start;

        private int end;

        public SumTask(int[] ints, int start, int end) {
            this.ints = ints;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if(end - start < YUVALUE){
                int count = 0;
                for (int i = start; i <= end; i++) {
                    SleepTools.ms(1);
                    count = count + ints[i];
                }
                return count;
            }else{
                int mid = (end + start)/2 ;
                SumTask leftTask = new SumTask(ints,start,mid);
                SumTask rightTask = new SumTask(ints,mid+1,end);
                invokeAll(leftTask,rightTask);
                return leftTask.join() + rightTask.join();
            }

        }
    }


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int[] ints = MakeArray.makeArray();
        SumTask sumTask = new SumTask(ints, 0, ints.length - 1);

        long startTime = System.currentTimeMillis();
         forkJoinPool.invoke(sumTask);
        long endTime = System.currentTimeMillis();

        System.out.println("this count is " + sumTask.join() + " spend time " + (endTime - startTime));
    }
}
