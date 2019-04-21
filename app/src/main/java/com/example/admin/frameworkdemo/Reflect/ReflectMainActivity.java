package com.example.admin.frameworkdemo.Reflect;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMainActivity extends Activity{
    private final static String TAG = "Reflect";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* try {
            ConstructorTest();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/
        /*try {
            getField();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/
        /*try {
            getMethodAndUse();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/
        Log.d(TAG, "aaa"+"bbb%%\t".length());
        Log.d(TAG, "ccc"+"bbb\t".getBytes());
    }

    //通过有参构造函数构造实例
    public void ConstructorTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class clazz1 = Class.forName("com.example.admin.frameworkdemo.Reflect.User");
        Constructor constructor = clazz1.getConstructor(int.class, String.class);
        User user = (User)constructor.newInstance(12, "James");
        Log.d(TAG, "age--->" + user.getAge()  + "name--->"+user.getName());
    }

    //获取成员变量
    public void getField() throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class clazz1 = Class.forName("com.example.admin.frameworkdemo.Reflect.User");
        User user = (User)clazz1.newInstance();
        Field field = clazz1.getDeclaredField("age");
        field.setAccessible(true);
        field.setInt(user, 33);
        Log.d(TAG, "getField" + user.getAge());
    }

    //获取方法并使用
    public void getMethodAndUse() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class clazz1 = Class.forName("com.example.admin.frameworkdemo.Reflect.User");
        User user = (User)clazz1.newInstance();
        Method method = clazz1.getDeclaredMethod("sing", String.class);
        method.invoke(user, "Kobe");
    }
}
