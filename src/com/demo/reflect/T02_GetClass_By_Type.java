package com.demo.reflect;

import java.lang.annotation.ElementType;

public class T02_GetClass_By_Type {
    public static void main(String[] args) {
        Class c1 = Class.class;
        Class c2 = Object.class;
        Class c3 = Runnable.class;
        Class c4 = new int[10].getClass();
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = Void.class;
        Class c9 = new int[2][2].getClass();
        Class c10 = Integer.class;
        Class c11 = Integer.TYPE;

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);
        System.out.println(c10);
        System.out.println(c11);

        // 类型和维度相同，那么类对象就是相同的
        Class c21 = new int[10].getClass();
        Class c22 = new int[100].getClass();
        System.out.println(c21.hashCode());
        System.out.println(c22.hashCode());
    }
}
