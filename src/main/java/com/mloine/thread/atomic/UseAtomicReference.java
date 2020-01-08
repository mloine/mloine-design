package com.mloine.thread.atomic;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author mloine
 * @Description
 * @Date 1:53 下午 2020/1/8
 */
public class UseAtomicReference {

    static AtomicReference<Psersion> psersionAtomicReference = new AtomicReference<>();

    public static void main(String[] args) {
        Psersion mloine = new Psersion("mloine", 24);

        psersionAtomicReference.set(mloine);
        Psersion afterMloine = new Psersion("mloine2020", 25);
        psersionAtomicReference.compareAndSet(mloine,afterMloine);

        System.out.println(psersionAtomicReference.get().getName());
        System.out.println(psersionAtomicReference.get().getAge());

        System.out.println(mloine.getName());
        System.out.println(mloine.getAge());

    }

    @Getter
    @Setter
    static class Psersion{
        private String name;

        private Integer age;

        public Psersion(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
}
