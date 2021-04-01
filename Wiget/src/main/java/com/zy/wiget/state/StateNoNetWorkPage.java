package com.zy.wiget.state;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.zy.wiget.R;

import androidx.annotation.Nullable;

/**
 * @author:zhangyue
 * @date:2021/4/1
 */
public class StateNoNetWorkPage extends LinearLayout {
    public StateNoNetWorkPage(Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.view_nonetwork, null);
        this.addView(view);
    }

    public StateNoNetWorkPage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.view_nonetwork, null);
        this.addView(view);
    }

    public StateNoNetWorkPage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
