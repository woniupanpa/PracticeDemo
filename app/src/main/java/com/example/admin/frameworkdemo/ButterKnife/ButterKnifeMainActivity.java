package com.example.admin.frameworkdemo.ButterKnife;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.frameworkdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButterKnifeMainActivity extends Activity {
    private final static String TAG = ButterKnifeMainActivity.class.getSimpleName();
    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.butterknife_activity_main);
        ButterKnife.bind(this);
       /* btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "btn1onclick");
            }
        });*/
    }

    @OnClick({R.id.btn1, R.id.btn2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                editText.setText("点击btn1");
                break;
            case R.id.btn2:
                editText.setText("点击btn2");
                break;
        }
    }
}
