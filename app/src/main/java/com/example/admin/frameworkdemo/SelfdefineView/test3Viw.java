package com.example.admin.frameworkdemo.SelfdefineView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import timber.log.Timber;

/**
 * @author yanjim
 * @Date 2022/1/24 08:48
 */
public class test3Viw extends View {
    Path path = new Path();
    Paint paint = new Paint();

    public test3Viw(Context context) {
        super(context);
    }

    public test3Viw(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //图形相交的部分镂空做法：
        // Path.Direction.CW和Path.Direction.CCW，相反的方向
        //path.setFillType(Path.FillType.EVEN_ODD);这种方法比较常见
        super.onSizeChanged(w, h, oldw, oldh);
        Timber.d("width--->" + getWidth());
        Timber.d("height--->" + getHeight());
        path.reset();
        path.addRect(getWidth() / 2 - 150, getHeight() / 2 - 300, getWidth() / 2 + 150, getHeight() / 2, Path.Direction.CCW);
        path.addCircle(getWidth() / 2, getHeight() / 2, 150, Path.Direction.CW);
        path.addCircle(getWidth() / 2, getHeight() / 2, 300, Path.Direction.CW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.setFillType(Path.FillType.EVEN_ODD);
        canvas.drawPath(path, paint);
    }
}
