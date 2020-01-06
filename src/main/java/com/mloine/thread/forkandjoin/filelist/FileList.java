package com.mloine.thread.forkandjoin.filelist;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class FileList {

    private static class FileTask extends RecursiveAction {

        private File file;

        public FileTask(File file) {
            this.file = file;
        }

        @Override
        protected void compute() {
            if(file.isDirectory()){
                File[] files = file.listFiles();
                ArrayList<FileTask> fileTasks = new ArrayList<>();
                for (File f : files){
                    fileTasks.add(new FileTask(f));
                }
                Collection<FileTask> fileTasks1 = invokeAll(fileTasks);
                for (FileTask x : fileTasks){
                    x.join();
                }
            }else{
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("/Users/xueyongkang/enjoylearn");
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //同步调用
//        forkJoinPool.invoke(new FileTask(file));
        //异步调用ß
        FileTask task = new FileTask(file);
        forkJoinPool.execute(task);

        System.out.println("㊗线程 执行........................................");
//        SleepTools.second(2);
        task.join();
        System.out.println("㊗线程 执行........................................");

    }
}
