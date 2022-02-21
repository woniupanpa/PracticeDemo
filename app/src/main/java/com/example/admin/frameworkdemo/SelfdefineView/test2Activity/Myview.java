package com.example.admin.frameworkdemo.SelfdefineView.test2Activity;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TimingLogger;
import android.view.View;

import timber.log.Timber;

/**
 * @author yanjim
 * @Date 2022/1/22 10:05
 */
public class Myview extends View {

    private static final String TAG = Myview.class.getSimpleName();

    private static final int DEFUALT_HEIGHT = 200;
    private static final int DEFUALT_WIDTH = 200;
    public Myview(Context context) {
        super(context);
    }

    public Myview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int width = measureDemission(DEFUALT_WIDTH,widthMeasureSpec);
        int height = measureDemission(DEFUALT_HEIGHT,heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    private int measureDemission(int defualtSize,int measureSpec) {
        int result = defualtSize;
        int mode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        //EXACTLY：使用母控件给出的确切的尺寸（specSize）,
        //确定的大小一般是由控件写好的：layout_widht = "50dp",layout_height = "50dp"
        //或者使用的fill_parent，这两种情况都可以确定大小。
        Timber.d(TAG+"aaaaaaaaaaaaaa--->" + specSize);
        if(mode == MeasureSpec.EXACTLY)
        {
            Log.d(TAG, "EXACTLY--->"+result);
            result = specSize;
        }
        //AT_MOST:不能超过母控件所给出的尺寸（specSize）
        //一般用于不能确定的小的时候，如wrap_content。
        else if(mode == MeasureSpec.AT_MOST)
        {
            //result = Math.min(result,specSize);
            result = specSize;
            Log.d(TAG, "AT_MOST--->"+result);
        }
        //UNSPECIFIED:表示显示的控件大小没有指定。
        else if(mode == MeasureSpec.UNSPECIFIED)
        {
            Timber.d(TAG+"UNSPECIFIED");
            result = defualtSize;
        }
        return result;
    }
}
