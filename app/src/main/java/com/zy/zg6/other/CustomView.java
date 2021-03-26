package com.zy.zg6.other;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.zy.zg6.R;

import androidx.annotation.Nullable;

/**
 * @author:zhangyue
 * @date:2021/3/24
 */
public class CustomView extends View {
    private Paint defPaint;
    private int customType;
    private int customColor;
    private float defCenterX,defCenterY;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomView);
        customType = typedArray.getInteger(R.styleable.CustomView_customtype, 0);
        customColor = typedArray.getColor(R.styleable.CustomView_customcolor, Color.RED);
        initPaint();
        typedArray.recycle();
    }

    private void initPaint() {
        defPaint=new Paint();
        defPaint.setStyle(Paint.Style.FILL);
        defPaint.setColor(customColor);
        defPaint.setAntiAlias(true);
        defPaint.setDither(true);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int width = getMeasuredWidth() / 2;
        int height = getMeasuredHeight() / 2;

        defCenterX=defCenterY = Math.min(width, height);
        Log.d("123","do onSizeChanged....");
    }

    int defWidthSize=200;
    int defHeigthSize=200;
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //wrapcontent
        //前两位 mode  后30位size
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int widhtSize=MeasureSpec.getSize(widthMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode==MeasureSpec.AT_MOST&&heightMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(defWidthSize,defHeigthSize);
        }else if (widthMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(defWidthSize,heightSize);
        }else if (heightMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(widhtSize,defHeigthSize);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (customType){
            case 0:
                canvas.drawCircle(defCenterX-getPaddingLeft(),defCenterY-getPaddingTop(),50,defPaint);
                Log.d("123","X->"+defCenterX+" Y->"+defCenterY);
                break;
            case 1:
                canvas.drawRect(0,0,0,0,defPaint);

                break;
            default:
                break;
        }

    }

    boolean currentTouch=false;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                currentTouch=true;
                break;
            case MotionEvent.ACTION_MOVE:
                if (currentTouch){
                    //跟随手指移动
                    defCenterX = event.getX();
                    defCenterY = event.getY();
                    if (Looper.getMainLooper().getThread()==Thread.currentThread()){
                        invalidate();
                    }
                    else{
                        postInvalidate();
                    }

                }

                break;
            case MotionEvent.ACTION_UP:
                currentTouch=false;
                break;
            case MotionEvent.ACTION_CANCEL:
                currentTouch=false;
                break;
        }
        return true;
    }
}
