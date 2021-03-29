package com.zy.zg6.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zy.log.LogLevel;
import com.zy.log.LogType;
import com.zy.log.ZLog;
import com.zy.log.ZLogManager;
import com.zy.zg6.other.LoginHandler;
import com.zy.zg6.R;
import com.zy.zg6.databinding.BaWei;
import com.zy.zg6.entity.ReqLoginUser;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
        BaWei viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        viewDataBinding.setDataSource(new ReqLoginUser());
        viewDataBinding.setEventHandler(new LoginHandler());

        ZLogManager.getInstance().d("这是一条测试Log");
    }


    public void onSecondClick(View view) {
//       try {
//           int a=0;
//           int b=12/a;
//       }catch (Exception e){
//
//       }
        startActivity(new Intent(this,DoubleBindActivity.class));
    }
}