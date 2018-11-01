package com.example.admin.frameworkdemo.SelfdefineView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
//import android.widget.ImageView;
//import android.support.v7.widget.AppCompatImageView

import com.example.admin.frameworkdemo.R;

public class CircleImageView extends android.support.v7.widget.AppCompatImageView {
    //外圆的宽度
    private int outCircleWidth;

    //外圆的颜色
    private int outCircleColor = Color.BLUE;

    //画笔
    private Paint paint;

    //view的宽度和高度
    private int viewWidth;
    private int viewHeigth;

    private Bitmap image;

    public CircleImageView(Context context) {
        super(context);
        Log.d("yjm", "aaaaaaaaa");
        // TODO Auto-generated constructor stub
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d("yjm", "bbbbbbbbb");
        initAttrs(context, attrs, defStyleAttr);
    }

    /**
     * 初始化资源文件
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    private void initAttrs(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray array = null;
        if (attrs != null) {
            //第二个参数就是我们在styles.xml文件中的<declare-styleable>标签
            //即属性集合的标签，在R文件中名称为R.styleable+name
            array = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView);

            int len = array.length();

            //第一个参数为属性集合里面的属性，R文件名称：R.styleable+属性集合名称+下划线+属性名称
            //第二个参数为，如果没有设置这个属性，则设置的默认的值
            for (int i = 0; i < len; i++) {
                int attr = array.getIndex(i);
                switch (attr) {
                    //获取到外圆的颜色
                    case R.styleable.CircleImageView_outCircleColor:
                        this.outCircleColor = array.getColor(attr, Color.WHITE);
                        break;
                    //获取到外圆的半径
                    case R.styleable.CircleImageView_outCircleWidth:
                        //getDimensionPixelSize返回的值是XML里面设置的值乘以屏幕密度
                        this.outCircleWidth = (int) array.getDimensionPixelSize(attr, 50);
                        Log.d("yjm", "outCircleWidth--->"+outCircleWidth);
                        break;
                }
            }
        }
        paint = new Paint();
        paint.setColor(outCircleColor);//颜色
        paint.setAntiAlias(true);//设置抗锯齿
        array.recycle();  //回收
    }

    /**
     * view的测量
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int width = measureWith(widthMeasureSpec);
        int height = measureWith(heightMeasureSpec);

        //viewWith=616,  width=656   
        //viewHegth=1030   heigth=1070
        viewWidth = width - outCircleWidth * 2;
        viewHeigth = height - outCircleWidth * 2;

        //调用该方法将测量后的宽和高设置进去，完成测量工作，
        setMeasuredDimension(width, height);
    }

    /**
     * 测量宽和高，这一块可以是一个模板代码(Android群英传)
     * @param widthMeasureSpec
     * @return
     */
    private int measureWith(int widthMeasureSpec) {
        int result = 0;
        //从MeasureSpec对象中提取出来具体的测量模式和大小
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        if (mode == MeasureSpec.EXACTLY) {
            //测量的模式，精确
            result = size;
        } else {
            result = viewWidth;
        }
        return result;
    }

    /**
     * 绘制
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        //加载图片
        loadImage();

        if (image != null) {
            //拿到最小的值(这里我们要取到最小的)
            int min = Math.min(viewWidth, viewHeigth);

            int circleCenter = min / 2;

            image = Bitmap.createScaledBitmap(image, min, min, false);

            //画圆,参数：圆心X， 圆心y，半径，画笔
            canvas.drawCircle(circleCenter + outCircleWidth, circleCenter + outCircleWidth, circleCenter + outCircleWidth, paint);

            //画图像
            canvas.drawBitmap(createCircleBitmap(image, min), outCircleWidth, outCircleWidth, null);
        }


    }

    /**
     * 创建一个圆形的bitmap
     *
     * @param image  传入的image
     * @param min
     * @return
     */
    private Bitmap createCircleBitmap(Bitmap image, int min) {

        Bitmap bitmap = null;


        Paint paint = new Paint();
        paint.setAntiAlias(true);
        bitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);

        //画一个和图片大小相等的画布
        canvas.drawCircle(min / 2, min / 2, min / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        canvas.drawBitmap(image, 0, 0, paint);


        return bitmap;
    }

    /**
     * 加载Image
     */
    private void loadImage() {
        //通过XML里面的android:src获取
        BitmapDrawable bitmapDrawable = (BitmapDrawable) this.getDrawable();

        if (bitmapDrawable != null) {
            image = bitmapDrawable.getBitmap();
        }
        //image = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
    }

    /**
     * 对外提供的可以设置外圆的颜色的方法
     * @param outCircleColor
     */
    public void setOutCircleColor(int outCircleColor) {
        if (null != paint) {
            paint.setColor(outCircleColor);
        }
        this.invalidate();
    }

    /**
     * 对外提供给的设置外圆的宽度大小的方法
     * @param outCircleWidth
     */
    public void setOutCircleWidth(int outCircleWidth) {
        this.outCircleWidth = outCircleWidth;
        this.invalidate();
    }

}