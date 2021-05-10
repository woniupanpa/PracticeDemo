package com.example.admin.frameworkdemo.Annotation;

import android.util.Log;

/**
 * @author yanjim
 * @Date 2020/11/13 16:14
 */
public class Student{
    @AnnotationTest.CherryAnnotation(name = "cherry-peng",age = 23,score = {99,66,77})
    public void study(int times){
        for(int i = 0; i < times; i++){
            System.out.println("Good Good Study, Day Day Up!");
        }
    }
}
