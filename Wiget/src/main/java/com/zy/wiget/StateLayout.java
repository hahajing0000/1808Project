package com.zy.wiget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

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
    public StateLayout(@NonNull Context context) {
        super(context);
        this.mContext=context;
        EventManager.getInstance().registObserver(this);
    }

    public StateLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
        EventManager.getInstance().registObserver(this);
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
}
