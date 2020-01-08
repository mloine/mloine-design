package com.mloine.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * @Author mloine
 * @Description CAS 原子操作类 将原子问题 交给cpu提供的cas指令来确保安全
 *                  a.ABA问题
 *                  b.一直compare不成功 会一直自旋
 * @Date 1:45 下午 2020/1/8
 */
public class UsrAtomicInterge {

    static AtomicInteger num = new AtomicInteger(10);

    public static void main(String[] args) {
        System.out.println(num.getAndIncrement());
        System.out.println(num.incrementAndGet());
        System.out.println(num.get());
    }

}
