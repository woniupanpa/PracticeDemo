package com.example.admin.frameworkdemo.Annotation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

public class AnnotationMainActivity extends Activity {
    public static final String TAG = "Annotation";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //System.runFinalizersOnExit(true);
        Log.d(TAG, "AAAAAAAAAA");
        sayHello();
        testMyAnnotation();
    }

    @Deprecated
    public void sayHello(){
        Log.d(TAG, "HelloWorld");
    }

    @SuppressWarnings("unused")
    public void sayNo(){
        Log.d(TAG, "NoNoNo");
    }

    //https://blog.csdn.net/xsp_happyboy/article/details/80987484
    private void testMyAnnotation(){
        try {
            //获取Student的Class对象
            Class stuClass = Class.forName("com.example.admin.frameworkdemo.Annotation.Student");

            //说明一下，这里形参不能写成Integer.class，应写为int.class
            Method stuMethod = stuClass.getMethod("study",int.class);

            if(stuMethod.isAnnotationPresent(MyAnnotation.class)){
                Log.d(TAG, "Student类上配置了CherryAnnotation注解！");
                //获取该元素上指定类型的注解
                MyAnnotation cherryAnnotation = stuMethod.getAnnotation(MyAnnotation.class);
                Log.d(TAG, "name: " + cherryAnnotation.name() + ", age: " + cherryAnnotation.age()
                        + ", score: " + cherryAnnotation.score()[0]);
            }else{
                Log.d(TAG, "Student类上没有配置CherryAnnotation注解！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
