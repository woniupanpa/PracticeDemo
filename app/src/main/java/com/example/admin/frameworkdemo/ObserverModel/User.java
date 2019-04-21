package com.example.admin.frameworkdemo.ObserverModel;

import android.util.Log;

public class User implements Observer {
    public User(String name) {
        this.name = name;
    }

    private String msg;
    private String name;
    @Override
    public void update(String msg) {
        Log.d("yjm", "name="+name + "msg="+msg+"\n");
    }
}
