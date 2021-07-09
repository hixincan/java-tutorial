package com.demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class T04_Practice {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("com.demo.reflect.User");

        // 构造实例，Class.newInstance 仅调用无参构造
        User u1 = (User) c1.newInstance();
        // 构造实例，Constructor.newInstance 调用任意构造
        // 无参构造
        User u2 = (User) c1.getDeclaredConstructor().newInstance();
        /*
        Exception in thread "main" java.lang.NoSuchMethodException: com.xxx.reflect.User.<init>(java.lang.Integer, java.lang.String, java.lang.Integer)
        注意 Integer.TYPE 与 Integer.class 的区别
         */
        // 有参构造
        Constructor constructor = c1.getDeclaredConstructor(Integer.TYPE, String.class, Integer.TYPE);
        User u3 = (User) constructor.newInstance(2, "lisi", 22);

        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
        System.out.println("-----------");

        // 调用方法
        Method method = c1.getDeclaredMethod("setName", String.class);
        method.invoke(u1, "张三");
        System.out.println(u1);
        System.out.println("-----------");

        // 修改属性
        Field field = c1.getDeclaredField("name");
        field.setAccessible(true);
        field.set(u2, "王五");
        System.out.println(u2);
        System.out.println("-----------");

    }

}
