package com.example.admin.frameworkdemo.Annotation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

public class AnnotationMainActivity extends Activity {
    private static final String TAG = "Annotation";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //System.runFinalizersOnExit(true);
        Log.d(TAG, "AAAAAAAAAA");
        sayHello();
    }

    @Deprecated
    public void sayHello(){
        Log.d(TAG, "HelloWorld");
    }

    @SuppressWarnings("unused")
    public void sayNo(){
        Log.d(TAG, "NoNoNo");
    }
}
