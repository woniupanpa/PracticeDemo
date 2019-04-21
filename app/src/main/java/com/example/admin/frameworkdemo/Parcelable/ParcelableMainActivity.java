package com.example.admin.frameworkdemo.Parcelable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.admin.frameworkdemo.R;

public class ParcelableMainActivity extends Activity{
    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book("HelloWorld", "yjm", 2018);
                Intent intent = new Intent(ParcelableMainActivity.this, ParcelableActivity2.class);
                intent.putExtra("info", book);
                startActivity(intent);
            }
        });
    }
}
