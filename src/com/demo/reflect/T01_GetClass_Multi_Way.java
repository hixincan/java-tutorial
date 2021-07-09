package com.demo.reflect;

/**
 * 获取 Class 对象方式
 */
public class T01_GetClass_Multi_Way {
    public static void main(String[] args) throws ClassNotFoundException {
        Person p = new Person("zhangsan", 20);
        // 通过对象获取
        Class c1 = p.getClass();

        // 通过包名获取
        Class c2 = Class.forName("com.demo.reflect.Person");

        // 通过类获取
        Class c3 = Person.class;

        Class c4 = new Student().getClass().getSuperclass();

        // 基本数据类型，从 TYPE 中获取类对象
        Class<Integer> c5 = Integer.TYPE;

        // 一个类的类对象在内存中是唯一的
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
        System.out.println(c5);
    }

}

/**
 * 声明一个实体类，只有属性
 */
class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person {

}