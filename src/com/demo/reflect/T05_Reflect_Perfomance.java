package com.demo.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 性能比较
 */
public class T05_Reflect_Perfomance {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test01();
        test02();
        test03();
    }

    public static void test01() {
        long startTime = System.currentTimeMillis();
        User u1 = new User();
        for (int i = 0; i< 1000000000; i++) {
            u1.getName();
        }
        System.out.println("普通执行10亿次：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * 反射，带有安全检查
     */
    public static void test02() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long startTime = System.currentTimeMillis();
        Class c1 = Class.forName("com.demo.reflect.User");
        User u1 = new User();
        Method method = c1.getDeclaredMethod("getName", null);
        for (int i = 0; i< 1000000000; i++) {
            method.invoke(u1, null);
        }
        System.out.println("反射执行10亿次：" + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * 关闭安全检查
     */
    public static void test03() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long startTime = System.currentTimeMillis();
        Class c1 = Class.forName("com.demo.reflect.User");
        User u1 = new User();
        Method method = c1.getDeclaredMethod("getName", null);
        method.setAccessible(true);
        for (int i = 0; i< 1000000000; i++) {
            method.invoke(u1, null);
        }
        System.out.println("关闭检测执行10亿次：" + (System.currentTimeMillis() - startTime) + "ms");
    }
}
