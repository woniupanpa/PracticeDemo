package com.example.admin.frameworkdemo.ActivityTest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.admin.frameworkdemo.R;

public class ActivityTestMainActivity extends Activity {
    private Button button;
    private static final String TAG = "ActivityTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            int age = savedInstanceState.getInt("age");
            String name = savedInstanceState.getString("name");
            Log.d(TAG, "age--->" + age + "name--->" + name);
        }
        Log.d(TAG, "AonCreate");
        setContentView(R.layout.activity_test_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showDialog();
                Intent intent = new Intent(ActivityTestMainActivity.this, Activity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "AonReStart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        //可见
        Log.d(TAG, "AonStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //可聚焦触摸
        Log.d(TAG, "AonResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "AonPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "AonStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "AonDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("age", 29);
        outState.putString("name", "michael");
        Log.d(TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);

    }

    public void showDialog() {
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(ActivityTestMainActivity.this);
        normalDialog.setIcon(R.mipmap.ic_launcher);
        normalDialog.setTitle("我是一个普通Dialog");
        normalDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        normalDialog.show();
    }

    //屏幕方向发生改变的回调方法
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //text_screen.append("\n 当前屏幕为横屏");
        } else {
            //text_screen.append("\n 当前屏幕为竖屏");
        }
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged");
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //设置横屏
    }


}
