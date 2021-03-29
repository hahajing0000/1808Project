package com.zy.zg6.view;

import android.os.Bundle;
import android.widget.Toast;

import com.zy.wiget.LabelView;
import com.zy.zg6.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author:zhangyue
 * @date:2021/3/29
 */
public class StreamViewActivity  extends AppCompatActivity {
    private LabelView lvOne;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream_view);
        initView();
        initEvent();
    }

    private void initEvent() {
        lvOne.setListener(new LabelView.OnLabelViewClickListener() {
            @Override
            public void onClick(LabelView labelView, String content) {
                Toast.makeText(StreamViewActivity.this,"被触发",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        lvOne = (LabelView) findViewById(R.id.lv_one);
    }
}
