package com.zy.wiget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author:zhangyue
 * @date:2021/3/29
 */
public class LabelView extends View {
    private Context mContext;
    /**
     * 控件的默认宽高
     */
    private int defaultWidth=100;
    private int defaultHeight=40;

    private Paint mPaint;
    /**
     * 文本画笔
     */
    private Paint mTxtPaint;

    /**
     * 关闭按钮的画笔
     */
    private Paint mBitmapPaint;

    /**
     * 圆角弧度
     */
    private int raduis=50;

    /**
     * 是否被选中 true-选中 false-你猜
     */
    private boolean isSelected=false;

    /**
     * 显示文本
     */
    private String mText;

    private OnLabelViewClickListener listener;
    private OnCloseLabelViewClickListener closeListener;
    /**
     * 关闭按钮的位置 最小外接矩形
     */
    private RectF dstRect;

    public void setListener(OnLabelViewClickListener listener) {
        this.listener = listener;
    }

    public void setCloseListener(OnCloseLabelViewClickListener closeListener) {
        this.closeListener = closeListener;
    }

    public LabelView(Context context) {
        super(context);
    }

    public LabelView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LabelView);
        mText=typedArray.getString(R.styleable.LabelView_text);
        typedArray.recycle();
        initPaint();

        this.mContext=context;
    }


    public LabelView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int heightMode=MeasureSpec.getMode(heightMeasureSpec);
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode==MeasureSpec.AT_MOST&&heightMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(defaultWidth,defaultHeight);
        }else if (widthMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(defaultWidth,heightSize);
        }else if (heightMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(widthSize,defaultHeight);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        RectF rectF=new RectF(0,0,getMeasuredWidth(),getMeasuredHeight());
        if (isSelected){
            mPaint.setColor(Color.rgb(255,153,51));
        }
        else{
            mPaint.setColor(Color.BLUE);
        }
        canvas.drawRoundRect(rectF,raduis,raduis,mPaint);

        if (!TextUtils.isEmpty(mText)){
//            Rect bounds=new Rect();
//            mTxtPaint.getTextBounds(mText,0,mText.length(),bounds);
//            int offset=(bounds.top+bounds.bottom)/2;

            Paint.FontMetrics fontMetrics=new Paint.FontMetrics();
            mTxtPaint.getFontMetrics(fontMetrics);
            int offset= (int) ((fontMetrics.descent+fontMetrics.ascent)/2);
            canvas.drawText(mText,getMeasuredWidth()/2,getMeasuredHeight()/2-offset,mTxtPaint);


        }

        Bitmap bitmap = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.close);
        Rect srcRect=new Rect(0,0,bitmap.getWidth(),bitmap.getHeight());
        dstRect = new RectF(getWidth()-bitmap.getWidth(),0,getWidth(),bitmap.getHeight());
        canvas.drawBitmap(bitmap,srcRect, dstRect,mBitmapPaint);

    }


    /**
     * 初始化画笔
     */
    private void initPaint() {
        mPaint=new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);
        mPaint.setAntiAlias(true);

        mTxtPaint=new Paint();
        mTxtPaint.setColor(Color.WHITE);
        mTxtPaint.setTextAlign(Paint.Align.CENTER);

        mBitmapPaint=new Paint();
        mBitmapPaint.setAntiAlias(true);
        mBitmapPaint.setDither(true);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                isSelected=isSelected?false:true;

                if (dstRect!=null&&dstRect.contains(event.getX(),event.getY())){
                    Log.d("123","........");
                }

                if (isSelected&&null!=listener){
                    listener.onClick(this,"");
                }
                if (Looper.getMainLooper().getThread()==Thread.currentThread()){
                    invalidate();
                }
                else{
                    postInvalidate();
                }
                break;
        }
        return true;
    }

    public interface OnLabelViewClickListener{
        void onClick(LabelView labelView,String content);
    }

    public interface OnCloseLabelViewClickListener{
        void onClick(LabelView labelView,String content);
    }
}
