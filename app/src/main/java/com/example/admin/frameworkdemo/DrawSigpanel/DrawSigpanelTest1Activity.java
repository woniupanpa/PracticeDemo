package com.example.admin.frameworkdemo.DrawSigpanel;


import android.app.Activity;
import android.os.Bundle;

public class DrawSigpanelTest1Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MySurfaceView3(getApplicationContext()));
    }
}

