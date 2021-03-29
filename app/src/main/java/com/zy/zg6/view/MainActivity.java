package com.zy.zg6.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;

import com.zy.zg6.R;
import com.zy.zg6.databinding.ActivityMainBinding;
import com.zy.zg6.entity.UserEntity;
import com.zy.zg6.observer.MyObserver;
import com.zy.zg6.observer.MyService;
import com.zy.zg6.observer.ObserverManager;

public class MainActivity extends AppCompatActivity implements MyObserver {
    private EditText etUsername;
    private EditText etPwd;
    private Button btnLogin;

    private ViewStub vsTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ObserverManager.getInstance().registerObserver(this);

        ActivityMainBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        UserEntity userEntity=new UserEntity();
        userEntity.setAge(20);
        userEntity.setName("小米");
        userEntity.setAddress("北京海淀");

        UserEntity userEntity2=new UserEntity();
        userEntity2.setName("小明");
        userEntity2.setAddress("天津");

        viewDataBinding.setUser(userEntity);
        viewDataBinding.setUser2(userEntity2);
        initView();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //SystemClock.sleep(3000);
//                etUsername.setText("我是子线程");
//            }
//        }).start();


        initEvent();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        startService(new Intent(this, MyService.class));
    }

    private void initEvent() {
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String username=etUsername.getText().toString().trim();
//                String pwd=etPwd.getText().toString().trim();
//
//                Toast.makeText(MainActivity.this,"用户："+username+" 密码:"+pwd,Toast.LENGTH_SHORT).show();
//            }
//        });

//        TextView textView=new TextView(this);

    }

    private void initView() {
        etUsername = (EditText) findViewById(R.id.et_username);
        etPwd = (EditText) findViewById(R.id.et_pwd);
        btnLogin = (Button) findViewById(R.id.btn_login);

        //vsTest.inflate();

        //vsTest.setVisibility(View.VISIBLE);
    }

    @Override
    public void notifyMsg(Object... objects) {
        Log.d("123","收到消息:"+objects[0].toString());
    }
}