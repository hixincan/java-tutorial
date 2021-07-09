package com.demo.clazz;

public class T01_Load_Class {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
        System.out.println(A.n);
        /*
        1. 加载到内存，产生一个类对应的class对象
        2. 链接：
        3. 初始化
            执行类构造器<clinit>() {
                确保父类已初始化
                合并静态代码块、类变量赋值
            }
         */
    }
}



class A {
    static int n = 0;

    static {
        System.out.println("静态代码块1 执行");
        int m = 30;
        int n = 10;
    }

    static int m = 100;

    static {
        System.out.println("静态代码块2 执行");
        int m = 150;
        int n = 50;
    }

    public A() {
        System.out.println("构造方法 执行");
    }
}
