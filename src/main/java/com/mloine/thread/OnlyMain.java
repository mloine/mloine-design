package com.mloine.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

/*
 * @Author mloine
 * @Description // JAVA 天生就是多线程的
 * @Date 12:57 下午 2020/1/2
 **/
public class OnlyMain {

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        Arrays.stream(threadInfos).forEach(System.out::println);
    }


}
