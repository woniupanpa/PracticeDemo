package com.example.admin.frameworkdemo.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.admin.frameworkdemo.R;

/**
 * @author yanjim
 * @Date 2021/9/19 16:28
 */
public class TestActivityA extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifecycle);
    }
}
