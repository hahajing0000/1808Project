package com.zy.wiget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zy.EventManager;
import com.zy.msgbus.MsgObserver;
import com.zy.wiget.state.State404Page;
import com.zy.wiget.state.State500Page;
import com.zy.wiget.state.StateNoNetWorkPage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author:zhangyue
 * @date:2021/4/1
 */
public class StateLayout extends FrameLayout implements MsgObserver {
    private Context mContext;
    private FrameLayout flTip;
    private TextView tvStateMsg;
    private FrameLayout flStateContent;



    public StateLayout(@NonNull Context context) {
        super(context);
        this.mContext=context;
        EventManager.getInstance().registObserver(this);
        View view = LayoutInflater.from(context).inflate(R.layout.view_state, null);
        this.addView(view);
        initView(view);
    }



    public StateLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
        EventManager.getInstance().registObserver(this);
        View view = LayoutInflater.from(context).inflate(R.layout.view_state, null);
        this.addView(view);
        initView(view);
    }

    public StateLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 修改子视图
     */
    private void changeSubView(View subView){
        this.removeAllViews();
        this.addView(subView);
    }

    @Override
    public void notify(Object... params) {
        int httpCode=(int)params[0];
        switch (httpCode){
            case 404:
                changeSubView(new State404Page(this.mContext));
                break;
            case 500:
                changeSubView(new State500Page(this.mContext));
                break;
            case 9001:
                changeSubView(new StateNoNetWorkPage(this.mContext));
                break;
        }
    }

    /**
     * 显示消息
     * @param msg
     */
    public void showMsg(String msg,  int seconds,final int timeout){
        tvStateMsg.setText(msg);
        flTip.setVisibility(VISIBLE);
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(flTip,"translationY",-100,0);
        objectAnimator.setDuration(seconds*1000);
        objectAnimator.start();

        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                flTip.setVisibility(GONE);
                            }
                        });

                    }
                },timeout*1000);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private Handler mHandler=new Handler();
    private Handler mainHandler=new Handler(Looper.getMainLooper());


    private void initView(View view) {
        flTip = (FrameLayout) view.findViewById(R.id.fl_tip);
        tvStateMsg = (TextView) view.findViewById(R.id.tv_state_msg);
        flStateContent = (FrameLayout) view.findViewById(R.id.fl_state_content);
    }
}
