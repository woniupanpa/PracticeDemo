package com.example.admin.frameworkdemo.ViewGroupSelfDef;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class SelfeDefViewGroup extends ViewGroup {
    private static final String TAG = "SelfeDefViewGroup";
    public SelfeDefViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SelfeDefViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SelfeDefViewGroup(Context context) {
        super(context);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        //开始处理wrap_content,如果一个子元素都没有，就设置为0
        if (getChildCount() == 0) {
            setMeasuredDimension(0,0);
        } else if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            //ViewGroup，宽，高都是wrap_content，根据我们的需求，宽度是子控件的宽度，高度则是所有子控件的总和
            View childOne = getChildAt(0);
            int childWidth = childOne.getMeasuredWidth();
            int childHeight = childOne.getMeasuredHeight();
            setMeasuredDimension(childWidth, childHeight * getChildCount());
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //ViewGroup的宽度为wrap_content,则高度不需要管，宽度还是自控件的宽度
            View childOne = getChildAt(0);
            int childWidth = childOne.getMeasuredWidth();
            setMeasuredDimension(childWidth,heightSize);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //ViewGroup的高度为wrap_content,则宽度不需要管，高度为子View的高度和
            View childOne = getChildAt(0);
            int childHeight = childOne.getMeasuredHeight();
            setMeasuredDimension(widthSize, childHeight * getChildCount());
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int height = 0;
        int count = getChildCount();
        View child;
        Log.e(TAG, count + "");
        for(int i = 0 ;i < count;i++) {
            child = getChildAt(i);
            child.layout(0, height, child.getMeasuredWidth(),height +  child.getMeasuredHeight());
            height += child.getMeasuredHeight();

        }
    }


}
