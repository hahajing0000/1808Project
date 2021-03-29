package com.zy.wiget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author:zhangyue
 * @date:2021/3/29
 */
public class StreamLayout extends ViewGroup {
    /**
     * xy的起始坐标位置
     */
    private int x,y=0;

    /**
     * 当前ViewGroup的宽高
     */
    private int layoutWidth,layoutHeight=0;

    /**
     * XY的间距
     */
    private int xSpace,ySpace=0;

    public StreamLayout(Context context) {
        super(context);
    }

    public StreamLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.StreamLayout);
        xSpace= typedArray.getInteger(R.styleable.StreamLayout_xSpace,0);
        ySpace=typedArray.getInteger(R.styleable.StreamLayout_ySpace,0);
        typedArray.recycle();

//        setBackgroundColor(Color.BLUE);
//        setWillNotDraw(false);
    }

    public StreamLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        layoutWidth=w;
        layoutHeight=h;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //获取当前viewgourp中的子控件个数
        int childCount = getChildCount();
        //循环遍历
        for (int i=0;i<childCount;i++){
            //根据索引获取具体的View
            View view = getChildAt(i);
            //layout 方法 传递4个参数 左 上 右 下
            int viewWidth=view.getMeasuredWidth();
            int viewHeight=view.getMeasuredHeight();
            //如果当前的x不大于viewgroup的宽 那就x累计 否则 x=0 y累计
            if ((x+viewWidth+xSpace)>layoutWidth){
                x=0;
                y=y+viewHeight+ySpace;
            }
            view.layout(x+xSpace,y+ySpace,x+viewWidth+xSpace,y+viewHeight+ySpace);
            x=x+viewWidth+xSpace;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(0,0,10,null);
    }
}
