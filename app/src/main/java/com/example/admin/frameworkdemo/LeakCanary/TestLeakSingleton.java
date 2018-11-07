package com.example.admin.frameworkdemo.LeakCanary;

import android.content.Context;
import android.widget.TextView;

public class TestLeakSingleton {
    private TextView tv;
    private Context context;

    private static TestLeakSingleton singleton = null;

    public static TestLeakSingleton getInstance(Context context){
        if(singleton == null){
            singleton = new TestLeakSingleton(context);
        }
        return singleton;
    }

    private TestLeakSingleton(Context context){
        this.context = context;
    }

    public void setTvAppName(TextView tv){
        this.tv = tv;
        tv.setText("内存泄漏检测");
    }
}
