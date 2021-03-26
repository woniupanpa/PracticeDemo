package com.example.admin.frameworkdemo;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class MyApplication extends Application {
    private static final String TAG = MyApplication.class.getName();
    public static RefWatcher getRefWatcher(Context context) {
        MyApplication application = (MyApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    private RefWatcher refWatcher;

    @Override public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        refWatcher = LeakCanary.install(this);
        MyApplication application = (MyApplication) getApplicationContext();
        ApplicationInfo applicationInfo = application.getApplicationInfo();
        //获取应用存放数据目录  /data/app/com.example.admin.frameworkdemo-2/base.apk
        Log.d(TAG, "applicationInfo sourceDir---> " + applicationInfo.sourceDir);
        // 存放数据的路径  应用数据目录   /data/data/com.example.admin.frameworkdemo
        Log.d(TAG, "applicationInfo dataDir---> " + applicationInfo.dataDir);
    }
}
