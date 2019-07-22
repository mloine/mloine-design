package com.mloine.design.templatepattern;

public class DodishB extends DodishTemplate{


    public void preparation() {
        System.out.println(this.getClass()+"步骤a--------");

    }

    public void doing() {
        System.out.println(this.getClass()+"步骤b--------");
    }

    public void carriedDishes() {
        System.out.println(this.getClass()+"步骤c--------");
    }
}
