package com.example.admin.frameworkdemo.SelfdefineView.tickview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.admin.frameworkdemo.R;

/**
 * Date: 2020/6/18
 * Time: 8:50
 * author:yanjim
 */
public class TickView extends View {

    private Context mContext;
    private int checkBaseColor;
    private int radius;
    private int centerX;
    private int centerY;
    private RectF mRectF;
    private float[] mPoints;
    private float tickRadius;
    private float tickRadiusOffset;
    private boolean isChecked;
    private Paint mPaintRing;
    private Paint mPaintTick;
    private Paint mPaintCircle;
    private int unCheckBaseColor;
    private int checkTickColor;
    private int ringCounter = 0;//计数器
    private int circleCounter = 0;
    private int alphaCount = 0;
    private int scaleCounter = 0;



    public TickView(Context context) {
        super(context);
    }

    public TickView(Context context, @Nullable AttributeSet attrs) {
        //super(context, attrs);
        this(context, attrs, 0);
    }

    public TickView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mRectF = new RectF();
        mContext = context;
        this.mPoints = new float[8];
        this.isChecked = false;
        initAttrs(attrs);
        this.initPaint();
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray array = mContext.obtainStyledAttributes(attrs, R.styleable.TickView);
        this.checkBaseColor = array.getColor(R.styleable.TickView_check_base_color, Color.RED);
        this.radius = array.getDimensionPixelOffset(R.styleable.TickView_radius, dp2px(this.mContext, 30.0F));
        this.unCheckBaseColor = array.getColor(R.styleable.TickView_uncheck_base_color, Color.GRAY);
        this.checkTickColor = array.getColor(R.styleable.TickView_check_tick_color, Color.WHITE);
        array.recycle();
        this.tickRadius = (float) dp2px(this.mContext, 12.0F);
        this.tickRadiusOffset = (float) dp2px(this.mContext, 4.0F);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("yjm", "view dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("yjm", "view onTouchEvent");
        return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = this.getMySize((this.radius + dp2px(this.mContext, 2.5F) * 6) * 2, widthMeasureSpec);
        int height = this.getMySize((this.radius + dp2px(this.mContext, 2.5F) * 6) * 2, heightMeasureSpec);
        height = width = Math.max(width, height);
        setMeasuredDimension(width, height);
        centerX = getMeasuredWidth() / 2;
        centerY = getMeasuredHeight() / 2;
        // 设置圆圈的外切矩形,radius是圆的半径，centerX，centerY是控件中心的坐标
        this.mRectF.set((float) (this.centerX - this.radius), (float) (this.centerY - this.radius), (float) (this.centerX + this.radius), (float) (this.centerY + this.radius));
        //设置打钩的几个点坐标（具体坐标点的位置不用怎么理会，自己定一个就好，没有统一的标准）
        //画一个√，需要确定3个坐标点的位置
        //所以这里我先用一个float数组来记录3个坐标点的位置，
        //最后在onDraw()的时候使用canvas.drawLines(mPoints, mPaintTick)来画出来
        //其中这里mPoint[0]~mPoint[3]是确定第一条线"\"的两个坐标点位置
        //mPoint[4]~mPoint[7]是确定第二条线"/"的两个坐标点位置
        this.mPoints[0] = (float) this.centerX - this.tickRadius + this.tickRadiusOffset;
        this.mPoints[1] = (float) this.centerY;
        this.mPoints[2] = (float) this.centerX - this.tickRadius / 2.0F + this.tickRadiusOffset;
        this.mPoints[3] = (float) this.centerY + this.tickRadius / 2.0F;
        this.mPoints[4] = (float) this.centerX - this.tickRadius / 2.0F + this.tickRadiusOffset;
        this.mPoints[5] = (float) this.centerY + this.tickRadius / 2.0F;
        this.mPoints[6] = (float) this.centerX + this.tickRadius * 2.0F / 4.0F + this.tickRadiusOffset;
        this.mPoints[7] = (float) this.centerY - this.tickRadius * 2.0F / 4.0F;
    }

    private static int dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5F);
    }

    private int getMySize(int defaultSize, int measureSpec) {
        int mySize = defaultSize;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        if (mode == MeasureSpec.EXACTLY) {
            mySize = size;
        } else {
            mySize = defaultSize;
        }
        return mySize;
    }

    //暴露外部接口，改变绘制状态
    public void setChecked(boolean checked) {
        if (this.isChecked != checked) {
            this.isChecked = checked;
            this.reset();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isChecked) {
            //绘制圆环，mRectF就是之前确定的外切矩形
            //因为是静态的，所以设置扫过的角度为360度
            canvas.drawArc(mRectF, 90, 360, false, mPaintRing);

            //根据之前定好的钩的坐标位置，进行绘制
            canvas.drawLines(mPoints, mPaintTick);
            return;
        } else {
            ringCounter += 12;
            if (ringCounter >= 360) {
                ringCounter = 360;
            }
            canvas.drawArc(mRectF, 90, ringCounter, false, mPaintRing);

            //在圆环进度达到100%的时候才开始绘制
            if(ringCounter == 360){
                //先绘制背景的圆
                mPaintCircle.setColor(checkBaseColor);
                canvas.drawCircle(centerX, centerY, radius, mPaintCircle);
                //然后在背景圆的图层上，再绘制白色的圆(半径不断缩小)
                //半径不断缩小，背景就不断露出来，达到向中心收缩的效果
                mPaintCircle.setColor(checkTickColor);
                //收缩的单位先试着设置为6，后面可以进行自己自定义
                circleCounter += 6;
                canvas.drawCircle(centerX, centerY, radius - circleCounter, mPaintCircle);
            }
            //当白色的圆半径收缩到0后，
            //也就是计数器circleCounter大于背景圆的半径的时候，就该将钩√显示出来了
            //这里加40是为了加一个延迟时间，不那么仓促的将钩显示出来
            if (circleCounter >= radius + 40) {
                //显示打钩（外加一个透明的渐变）
                alphaCount += 20;
                if (alphaCount >= 255) alphaCount = 255;
                mPaintTick.setAlpha(alphaCount);
                //最后就将之前在onMeasure中计算好的坐标传进去，绘制钩出来
                canvas.drawLines(mPoints, mPaintTick);
                //显示放大并回弹的效果
                scaleCounter -= 4;
                if (scaleCounter <= -45) {
                    scaleCounter = -45;
                }
                //放大回弹，主要看画笔的宽度
                float strokeWith = mPaintRing.getStrokeWidth() +
                        (scaleCounter > 0 ? dp2px(mContext, 1) : -dp2px(mContext, 1));
                mPaintRing.setStrokeWidth(strokeWith);
                canvas.drawArc(mRectF, 90, 360, false, mPaintRing);
            }
            //必须重绘
            postInvalidate();
        }


    }

    public boolean isChecked() {
        return this.isChecked;
    }


    private void reset() {
        this.initPaint();
        /*this.mFinalAnimatorSet.cancel();
        this.ringProgress = 0;
        this.circleRadius = -1;
        this.isAnimationRunning = false;*/
        this.mRectF.set((float) (this.centerX - this.radius), (float) (this.centerY - this.radius), (float) (this.centerX + this.radius), (float) (this.centerY + this.radius));
        this.invalidate();
    }

    private void initPaint() {
        if (this.mPaintRing == null) {
            this.mPaintRing = new Paint(1);
        }

        this.mPaintRing.setStyle(Paint.Style.STROKE);
        this.mPaintRing.setColor(this.isChecked ? this.checkBaseColor : this.unCheckBaseColor);
        this.mPaintRing.setStrokeCap(Paint.Cap.ROUND);
        this.mPaintRing.setStrokeWidth((float) dp2px(this.mContext, 2.5F));
        if (this.mPaintCircle == null) {
            this.mPaintCircle = new Paint(1);
        }

        this.mPaintCircle.setColor(this.checkBaseColor);
        if (this.mPaintTick == null) {
            this.mPaintTick = new Paint(1);
        }

        this.mPaintTick.setColor(this.isChecked ? this.checkTickColor : this.unCheckBaseColor);
        this.mPaintTick.setAlpha(this.isChecked ? 0 : 255);
        this.mPaintTick.setStyle(Paint.Style.STROKE);
        this.mPaintTick.setStrokeCap(Paint.Cap.ROUND);
        this.mPaintTick.setStrokeWidth((float) dp2px(this.mContext, 2.5F));
    }


}
