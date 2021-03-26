package com.example.admin.frameworkdemo.Annotation;

import android.util.Log;

/**
 * @author yanjim
 * @Date 2020/11/13 16:14
 */
public class Student {

    @MyAnnotation(name = "Jake", age = 10, score = {89, 90, 92})
    public void study(){
        Log.d(AnnotationMainActivity.TAG, "aaaaaaaaaaa");
    }
}
