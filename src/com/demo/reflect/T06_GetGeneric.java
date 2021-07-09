package com.demo.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 反射操作泛型
 * TODO 应用场景
 */
public class T06_GetGeneric {
    public static void test01(List<String> list, Map<String, Integer> map) {

    }

    public static Map<String, Object> test02() {
        return null;
    }

    /*
    获取入参的泛型类型
     */
    public static void main(String[] args) throws NoSuchMethodException {
        Class c1 = T06_GetGeneric.class;
        Method test01 = c1.getDeclaredMethod("test01", List.class, Map.class);
        Type[] types = test01.getGenericParameterTypes();
        for (Type type: types) {
            if (type instanceof ParameterizedType) {
                // 转为参数类型
                Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                for (Type actualTypeArgument: actualTypeArguments) {
                    System.out.println(actualTypeArgument.getTypeName());
                    //System.out.println(actualTypeArgument.getClass());
                }
            }
        }
        System.out.println("-----------");

        /*
        获取返回参数的泛型类型
         */
        Method test02 = c1.getDeclaredMethod("test02", null);
        Type test02Type = test02.getGenericReturnType();
        if (test02Type instanceof ParameterizedType) {
            // 转为参数类型
            Type[] actualTypeArguments = ((ParameterizedType) test02Type).getActualTypeArguments();
            for (Type actualTypeArgument: actualTypeArguments) {
                System.out.println(actualTypeArgument.getTypeName());
                //System.out.println(actualTypeArgument.getClass());
            }
        }
    }
}
