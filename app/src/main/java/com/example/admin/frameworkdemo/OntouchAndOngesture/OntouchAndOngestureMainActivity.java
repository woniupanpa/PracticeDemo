package com.example.admin.frameworkdemo.OntouchAndOngesture;

import android.os.Bundle;

import android.app.Activity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.OnGestureListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.admin.frameworkdemo.R;

//http://blog.csdn.net/mlj1668956679/article/details/37766005
public class OntouchAndOngestureMainActivity extends Activity implements OnTouchListener,
        OnGestureListener {
    GestureDetector mGestureDetector;
    private static final int FLING_MIN_DISTANCE = 50;
    private static final int FLING_MIN_VELOCITY = 0;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ontouch_and_gesture_main);
        mGestureDetector = new GestureDetector(this);
        LinearLayout ll=(LinearLayout)findViewById(R.id.ll);
        ll.setOnTouchListener(this);
        ll.setLongClickable(true);
    }
    //先通过setontouchlistener的ontouch来捕获点击事件，然后通过
    //mGestureDetector.onTouchEvent(event)将点击事件传递到gesturelistener来
    //进行各种回调函数操作。
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // TODO Auto-generated method stub
        Log.d("yjm", "onTouch------>");
        Log.i("touch","touch");
        //当已经完整地处理了该事件且不希望其他回调方法再次处理时返回true，否则返回false
        return mGestureDetector.onTouchEvent(event);
    }
    // 用户轻触触摸屏，由1个MotionEvent ACTION_DOWN触发
    @Override
    public boolean onDown(MotionEvent e) {
        Log.d("yjm", "onDown------>");
        // TODO Auto-generated method stub
        return true;
    }
    //最有用的当然是onFling()、onScroll()和onLongPress()
    // 用户按下触摸屏、快速移动后松开，由1个MotionEvent ACTION_DOWN, 多个ACTION_MOVE, 1个ACTION_UP触发
    //onFling（）为“滑动”的最后触发（即手指Up抬起时触发），需要较为快速的"滑动"操作（但在"滑动"过程中，也会不停的触发onScroll（）），如果慢速滑动，通过日志可以看出，最后没有调用onFling()。
    //onScroll（）为“拖动”或“滑动”的过程中不断触发,直到动作结束，无论快慢都会触发。
    //onFling需要ondown返回true的时候才会触发
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {
        // 参数解释：
        // e1：第1个ACTION_DOWN MotionEvent
        // e2：最后一个ACTION_MOVE MotionEvent
        // velocityX：X轴上的移动速度，像素/秒
        // velocityY：Y轴上的移动速度，像素/秒
        // 触发条件 ：
        // X轴的坐标位移大于FLING_MIN_DISTANCE，且移动速度大于FLING_MIN_VELOCITY个像素/秒
        Log.d("yjm", "onFling------>");
        // TODO Auto-generated method stub
        if (e1.getX()-e2.getX() > FLING_MIN_DISTANCE
                && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
            // Fling left
            Toast.makeText(this, "向左手势", Toast.LENGTH_SHORT).show();
        } else if (e2.getX()-e1.getX() > FLING_MIN_DISTANCE
                && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
            // Fling right
            Toast.makeText(this, "向右手势", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
    // 用户长按触摸屏，由多个MotionEvent ACTION_DOWN触发
    @Override
    public void onLongPress(MotionEvent e) {
        Log.d("yjm", "onLongPress------>");
        // TODO Auto-generated method stub
    }
    // 用户按下触摸屏，并拖动，由1个MotionEvent ACTION_DOWN, 多个ACTION_MOVE触发
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        Log.d("yjm", "onScroll------>");
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public void onShowPress(MotionEvent e) {
        Log.d("yjm", "onShowPress------>");
        // TODO Auto-generated method stub
    }
    // 用户（轻触触摸屏后）松开，由一个1个MotionEvent ACTION_UP触发
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.d("yjm", "onSingleTapUp------>");
        // TODO Auto-generated method stub
        return false;
    }
}

