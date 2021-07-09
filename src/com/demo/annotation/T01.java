package com.demo.annotation;

import java.lang.annotation.*;

/**
 * 注解是静态配置，需要结合注解解析类一起使用
 * 注解解析类一般通过反射机制来注解信息
 */

@myAnnotation2(name = "张三")
public class T01 {
    @myAnnotation1("加油")
    public void test() {

    }
}

// 作用目标 TYPE表示类，多个值用数组语法 {}
@Target({ElementType.METHOD, ElementType.TYPE})
// RUNTIME 包含 CLASS 包含 SOURCE
@Retention(RetentionPolicy.RUNTIME)
// 生成 java doc
@Documented
// 子类允许继承注解
@Inherited
@interface myAnnotation1 {
    // 当只有一个值，建议用 value 命名，因为在使用时可省略
    // 这里是定义属性，而非方法
    String value();
}

@Target({ElementType.TYPE})
// 一般固定写 RUNTIME
@Retention(RetentionPolicy.RUNTIME)
@interface myAnnotation2 {
    String name() ;
    // 声明默认值
    int age() default 0;
    int id() default -1;
}
