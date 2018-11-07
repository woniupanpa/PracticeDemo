package com.example.admin.frameworkdemo.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
public class MyService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("call", "onBind");
        MyBinder myBinder = new MyBinder();

        return myBinder;
    }

    @Override
    public void onCreate() {
        Log.d("call", "onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("call", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("call", "onDestroy");
        super.onDestroy();
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("call", "TestService -> onUnbind, from:" + intent.getStringExtra("from"));
        return false;
    }



    public class MyBinder extends Binder {
        public String getData() {
            return "获取数据成功";
        }
    }

}
