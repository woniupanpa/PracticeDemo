package com.example.admin.frameworkdemo.LaunchMode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.frameworkdemo.R;

public class LaunchMainActivity extends Activity {
    private static final String TAG = "LaunchMode";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_activity_main);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(this.toString());
        Button button = (Button) findViewById(R.id.button);
        Button button4 = (Button) findViewById(R.id.button4);
        Log.d(TAG, "firstActivity--->" + this.toString());
        Log.d(TAG, "firstTaskId--->" + this.getTaskId());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(LaunchMainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaunchMainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
