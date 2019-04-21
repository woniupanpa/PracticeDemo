package com.example.admin.frameworkdemo.Dispatch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.admin.frameworkdemo.R;

/**
 * ViewGroup布局（myLayout）中有2个子View = 2个按钮
 */
public class DispatchMainActivity extends AppCompatActivity {
    private static final String TAG = "MotionEventDispatch";
    private CustomButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dispatch_activity_main);
        button = (CustomButton)findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Log.i(TAG, "CustomButton--onClick");

            }
        });

        button.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i(TAG, "CustomButton-onTouch-ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i(TAG, "CustomButton-onTouch-ACTION_UP");
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "MainActivity-dispatchTouchEvent-ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "MainActivity-dispatchTouchEvent-ACTION_UP");
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "MainActivity-onTouchEvent-ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "MainActivity-onTouchEvent-ACTION_UP");
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/
}

