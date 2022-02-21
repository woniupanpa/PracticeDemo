package com.example.admin.frameworkdemo.leaktest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.admin.frameworkdemo.R;

/**
 * @author yanjim
 * @Date 2021/6/1 08:47
 */
public class LeakTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(8000000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(runnable).start();
    }
}
