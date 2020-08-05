package com.example.admin.frameworkdemo.SelfdefineView.tickview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;

import com.example.admin.frameworkdemo.R;

/**
 * Date: 2020/6/18
 * Time: 9:19
 * author:yanjim
 */
public class TickviewMainActivity extends Activity {
    TickView tickViewAccent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tick_view);
        tickViewAccent = (TickView) findViewById(R.id.tick_view_accent);
        tickViewAccent.setChecked(true);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("yjm", "activity dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("yjm", "activity onTouchEvent");
        return super.onTouchEvent(event);
    }
}
