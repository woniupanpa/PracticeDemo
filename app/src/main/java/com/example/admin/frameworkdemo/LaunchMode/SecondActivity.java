package com.example.admin.frameworkdemo.LaunchMode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.frameworkdemo.R;

public class SecondActivity extends Activity {
    private static final String TAG = "LaunchMode";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_second_activity_main);
        Log.d(TAG, "SecondActivity--->" + this.toString());
        Log.d(TAG, "secondTaskId--->" + this.getTaskId());
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(this.toString());
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, LaunchMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
