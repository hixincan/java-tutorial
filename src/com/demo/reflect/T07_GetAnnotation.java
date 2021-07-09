package com.demo.reflect;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * 反射操作注解
 * 获取注解的值
 */
public class T07_GetAnnotation {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        // 获取类
        Class c1 = Class.forName("com.demo.reflect.Employee");
        // 获取注解，注意 Annotation 与 AnnotationType 的语义
        MyTable myTable = (MyTable)c1.getDeclaredAnnotation(MyTable.class);
        System.out.println(myTable.value());

        // 获取 name 字段
        Field name = c1.getDeclaredField("name");
        MyColumn myColumn = (MyColumn) name.getAnnotation(MyColumn.class);
        System.out.println((myColumn.name() + " " + myColumn.type() + " " + myColumn.len()));

    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyTable{
    // 表名
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyColumn{
    // 列名
    String name();
    // 列类型
    String type();
    // 列长度
    String len();
}

@MyTable("XDEmployee")
class Employee {
    @MyColumn(name = "id", type = "long", len = "20")
    private Long id;
    @MyColumn(name = "name", type = "varchar", len = "10")
    private String name;
    @MyColumn(name = "age", type = "int", len = "3")
    private int age;

    public Employee() {
    }

    public Employee(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
