package com.mloine.design.templatepattern;

public class DodishA extends DodishTemplate{


    public void preparation() {
        System.out.println(this.getClass()+"步骤1--------");

    }

    public void doing() {
        System.out.println(this.getClass()+"步骤2--------");
    }

    public void carriedDishes() {
        System.out.println(this.getClass()+"步骤3--------");
    }
}
