package com.example.admin.frameworkdemo.ProxyModel;

import android.util.Log;

public class MonitorUtil {
    private final static String TAG = "ProxyModel";
    private static ThreadLocal<Long> tl = new ThreadLocal<>();

    public static void start() {
        tl.set(System.currentTimeMillis());
    }

    //结束时打印耗时
    public static void finish(String methodName) {
        long finishTime = System.currentTimeMillis();
        Log.d(TAG, methodName + "方法耗时" + (finishTime - tl.get()) + "ms");
    }
}
