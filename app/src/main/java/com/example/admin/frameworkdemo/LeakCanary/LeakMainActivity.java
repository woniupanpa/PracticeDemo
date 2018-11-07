package com.example.admin.frameworkdemo.LeakCanary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.admin.frameworkdemo.R;

public class LeakMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leak_activity_main);
        TextView textView = (TextView) findViewById(R.id.myview);
        TestLeakSingleton.getInstance(this).setTvAppName(textView);
    }
}
