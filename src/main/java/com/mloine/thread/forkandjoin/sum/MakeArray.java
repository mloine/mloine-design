package com.mloine.thread.forkandjoin.sum;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author mloine
 * @Description
 * @Date 3:07 下午 2020/1/6
 */
public class MakeArray {

    public static final int INT = 4000;

    public static int[] makeArray(){
        Random random = new Random();
        int[] ints = new int[INT];
        for (int i = 0; i < INT; i++) {
            ints[i] = random.nextInt(INT*3);
        }
        return ints;
    }

    public static void main(String[] args) {
        Arrays.stream(makeArray()).forEach(System.out::println);
    }
}
