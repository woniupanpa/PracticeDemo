package com.example.admin.frameworkdemo.Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * https://blog.csdn.net/xsp_happyboy/article/details/80987484
 *
 * @author yanjim
 * @Date 2021/5/8 18:22
 */
public class AnnotationTest {
    public static void main(String[] args) {
        try {
            //获取Student的Class对象
            Class stuClass = Class.forName("com.example.admin.frameworkdemo.Annotation.Student");

            //说明一下，这里形参不能写成Integer.class，应写为int.class
            Method stuMethod = stuClass.getMethod("study", int.class);

            if (stuMethod.isAnnotationPresent(CherryAnnotation.class)) {
                System.out.println("Student类上配置了CherryAnnotation注解！");
                //获取该元素上指定类型的注解
                CherryAnnotation cherryAnnotation = stuMethod.getAnnotation(CherryAnnotation.class);
                System.out.println("name: " + cherryAnnotation.name() + ", age: " + cherryAnnotation.age()
                        + ", score: " + cherryAnnotation.score()[0]);
            } else {
                System.out.println("Student类上没有配置CherryAnnotation注解！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(value = {ElementType.METHOD})
    @Documented
    public @interface CherryAnnotation {
        String name();

        int age() default 18;

        int[] score();
    }
}
