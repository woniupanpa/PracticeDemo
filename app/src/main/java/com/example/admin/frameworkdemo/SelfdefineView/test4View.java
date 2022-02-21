package com.example.admin.frameworkdemo.SelfdefineView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author yanjim
 * @Date 2022/1/24 18:21
 */
public class test4View extends View {
    private static final int ANGLE = 120;
    private static final float RADIUS = 150;
    private static final float LENGTH = 50;
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    PathDashPathEffect pathDashPathEffect;
    Path dash = new Path();

    public test4View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        dash.addRect(0, 0, 4, 20, Path.Direction.CW);

        //计算弧形的长度
        Path arc = new Path();
        arc.addArc(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS, getWidth() / 2 + RADIUS,
                getHeight() / 2 + RADIUS, 90 + ANGLE / 2, 360 - ANGLE);
        PathMeasure pathMeasure = new PathMeasure(arc, false);

        pathDashPathEffect = new PathDashPathEffect(dash, pathMeasure.getLength() / 20, 0, PathDashPathEffect.Style.ROTATE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画线
        canvas.drawArc(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS, getWidth() / 2 + RADIUS,
                getHeight() / 2 + RADIUS, 90 + ANGLE / 2, 360 - ANGLE, false, paint);
        //画刻度
        paint.setPathEffect(pathDashPathEffect);
        canvas.drawArc(getWidth() / 2 - RADIUS, getHeight() / 2 - RADIUS, getWidth() / 2 + RADIUS,
                getHeight() / 2 + RADIUS, 90 + ANGLE / 2, 360 - ANGLE, false, paint);
        paint.setPathEffect(null);

        canvas.drawLine(getWidth() / 2, getHeight() / 2,
                (float) Math.cos(Math.toRadians(getAngleFromMark(5))) * LENGTH + getWidth() / 2 - RADIUS,
                (float) Math.sin(Math.toRadians(getAngleFromMark(5))) * LENGTH + getHeight() / 2 - RADIUS,
                paint);
    }

    int getAngleFromMark(int mark) {
        return (int) (90 + (float) ANGLE / 2 + (360 - (float) ANGLE) / 20 * mark);
    }
}
