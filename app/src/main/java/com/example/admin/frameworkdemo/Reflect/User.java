package com.example.admin.frameworkdemo.Reflect;

import android.util.Log;

public class User {
    private static final String TAG = "Reflect";
    int age;
    String name;

    public String getName() {
        return name;
    }

    public int getAge() {

        return age;
    }

    public User() {
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void playBasketball(){
        Log.d(TAG, "I play paly basketball well!");
    }

    public void sing(String someone){
        Log.d(TAG, someone+ "sing well!");
    }
}
