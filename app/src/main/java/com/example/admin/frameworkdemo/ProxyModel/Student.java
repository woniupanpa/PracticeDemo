package com.example.admin.frameworkdemo.ProxyModel;

import android.util.Log;

public class Student implements Person {
    private final static String TAG = "ProxyModel";
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        try {
            //假设数钱花了一秒时间
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "name="+name+"上交班费50元");
    }

    @Override
    public void playBasketball() {
        Log.d(TAG, "name="+name+"Let's play basketball");
    }
}
