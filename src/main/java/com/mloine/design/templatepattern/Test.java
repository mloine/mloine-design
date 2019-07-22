package com.mloine.design.templatepattern;

/**
 *
 */
public class Test {
    public static void main(String[] args) {
        DodishTemplate dodishA = new DodishA();
        dodishA.dodish();
        System.out.println("---------------------------------------------------");
        DodishTemplate dodishB = new DodishB();
        dodishB.dodish();

        System.out.println("---------------------------------------------------");
        dodishA.doFather();
        dodishB.doFather();

    }
}
