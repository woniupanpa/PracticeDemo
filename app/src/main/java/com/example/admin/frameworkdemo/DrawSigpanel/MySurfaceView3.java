package com.example.admin.frameworkdemo.DrawSigpanel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Administrator on 2018/1/23.
 */

public class MySurfaceView3 extends SurfaceView implements Runnable,SurfaceHolder.Callback {
    public static final String TAG = MySurfaceView3.class.getSimpleName();

    private SurfaceHolder mHolder;
    private Paint mPaint;
    // 是否绘制
    private boolean isDrawing;
    private Canvas mCanvas;
    private Path mPath;

    public MySurfaceView3(Context context) {
        this(context, null);
    }

    public MySurfaceView3(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MySurfaceView3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mHolder = getHolder();
        mHolder.addCallback(this);

        mPaint = new Paint();
        //设置抗锯齿
        mPaint.setAntiAlias(true);
        //设置画笔的风格
        mPaint.setStyle(Paint.Style.STROKE);
        //设置边线的宽度
        mPaint.setStrokeWidth(10);
        //设置画笔的颜色
        mPaint.setColor(Color.BLACK);

        mPath = new Path();

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isDrawing = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d(TAG, "surfaceChanged: ");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isDrawing = false;
        Log.d(TAG, "surfaceDestroyed: ");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(x, y);
                return true;
            case MotionEvent.ACTION_MOVE:
                //记录所有划过的点
                mPath.lineTo(x, y);
                return true;
        }
        invalidate();
        return super.onTouchEvent(event);
    }

    @Override
    public void run() {
        while (isDrawing) {
            try {
                // 锁定画布
                mCanvas = mHolder.lockCanvas();
                myDraw();
            } catch (Exception e) {
                Log.d(TAG, "run: " + e.getMessage());
            } finally {
                if (mCanvas != null) {
                    // 释放画布
                    mHolder.unlockCanvasAndPost(mCanvas);
                }
            }
        }
    }

    public void myDraw() {
        mCanvas.drawColor(Color.WHITE);
        mCanvas.drawPath(mPath, mPaint);
    }
}
