package com.zy.zg6.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.zy.EventManager;
import com.zy.core.view.BaseActivity;
import com.zy.log.ZLogManager;
import com.zy.msgbus.MsgObserver;
import com.zy.zg6.ObservableService;
import com.zy.zg6.R;
import com.zy.zg6.observer.MyObserver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/**
 * @author:zhangyue
 * @date:2021/3/30
 */
public class BottomNavViewActivity extends BaseActivity  {//implements MsgObserver
    private BottomNavigationView bnvNav;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomnavview);

//        startService(new Intent(this, ObservableService.class));

//        //注册观察者
//        EventManager.getInstance().registObserver(this);

//        LinkedHashMap<String,String> map=new LinkedHashMap<>(0,0.75F,true);
//
//        map.put("1","11");
//        map.put("2","22");
//        map.put("3","33");
//        map.put("4","44");
//
//
//        map.replace("2","22","222222");
//
//        map.put("5","55");
//        map.replace("1","11","1111");
//
//        for (Map.Entry<String,String> entry: map.entrySet()){
//            Log.d("123","key = "+entry.getKey()+" value="+entry.getValue());
//        }

//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                EventManager.getInstance().SendMsg(9001);
//            }
//        },3000);

        bnvNav = (BottomNavigationView) findViewById(R.id.bnv_nav);

        bnvNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_home:
                        showMsg("主页");
                        break;
                    case R.id.nav_type:
                        showMsg("分类");
                        break;
                    case R.id.nav_mine:
                        showMsg("我的");
                        break;
                }

                return true;
            }
        });

        bnvNav.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
    }

//    private Handler mHandler=new Handler();

//    @Override
//    public void notify(Object... params) {
//        ZLogManager.getInstance().d("接收到被观察者发送的消息，内容->"+params[0].toString());
//    }
}
