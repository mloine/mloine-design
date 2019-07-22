package com.mloine.design.templatepattern;

/**
 * 1.模板模式
 *      1.抽象模板类定义通用行为模式,和统一的行为实现
 *      2.个别行为的细节交给子类维护,通过加载不同的子类实现不同行为的细节
 *
 *  优点：当需要改动具体行为细节时候 只要增加或者修改具体引用的子类就能改变行为细节、
 *           （1）具体细节步骤实现定义在子类中，子类定义详细处理算法是不会改变算法整体结构。
 * 　        （2）代码复用的基本技术。
 * 　        （3）存在一种反向的控制结构，通过一个父类调用其子类的操作，通过子类对父类进行扩展增加新的行为，符合“开闭原则”。
 **/