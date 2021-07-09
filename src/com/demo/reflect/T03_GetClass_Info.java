package com.demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class T03_GetClass_Info {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.demo.reflect.User");

        // 获取类的所有 public 属性
        Field[] fields = c1.getFields();
        for (Field field: fields) {
            System.out.println(field.getName() + " " + field.getType());
        }
        System.out.println("--------------");
        // 获取类的所有属性
        fields = c1.getDeclaredFields();
        for (Field field: fields) {
            System.out.println(field.getName() + " " + field.getType());
        }
        System.out.println("--------------");
        // 获取类的指定属性
        Field f1 = c1.getDeclaredField("desc");
        Field f2 = c1.getDeclaredField("age");
        System.out.println(f1.getName() + " " + f1.getType());
        System.out.println(f2.getName() + " " + f2.getType());
        System.out.println("--------------");

        // 获取类的所有方法
        Method[] methods = c1.getDeclaredMethods();
        for (Method method: methods) {
            System.out.println(method.getName());
        }
        System.out.println("--------------");

        // 获取类的所有构造方法
        Constructor<?>[] constructors = c1.getDeclaredConstructors();
        for (Constructor constructor: constructors) {
            System.out.println(constructor.getName());
        }
        System.out.println("--------------");
        // 获取类的指定构造方法
        Constructor constructorWithParams = c1.getConstructor(Integer.TYPE, String.class, int.class);
        System.out.println(constructorWithParams.getName());
    }
}

class User {
    public String desc;
    private int id;
    private String name;
    private int age;

    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private void myPrivate() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}