package com.demo.clazz;

public class T02_Init_Class {
    static {
        System.out.println("Main静态方法");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        // 主动引用
        //Son son = new Son();

        //Class.forName("com.xxx.clazz.Son");

        //System.out.println(Son.M);


        // 用排除法来介绍会更直接些
        // 被动引用 - 是指不会初始化类对象的场景
        // 引用父类的静态变量
        //System.out.println(Son.F);
        // 引用自身的常量（链接阶段）
        //System.out.println(Son.S);

    }

}

class Father{
    static int F = 10;
    static {
        System.out.println("父类静态方法");
    }
}

class Son extends Father{
    static final int S = 20;
    static int M = 20;
    static {
        System.out.println("子类静态方法");
    }
}