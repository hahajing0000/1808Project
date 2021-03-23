package com.zy.zg6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zy.zg6.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPwd;
    private Button btnLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        ActivityMainBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        UserEntity userEntity=new UserEntity();
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

    private void initEvent() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=etUsername.getText().toString().trim();
                String pwd=etPwd.getText().toString().trim();

                Toast.makeText(MainActivity.this,"用户："+username+" 密码:"+pwd,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        etUsername = (EditText) findViewById(R.id.et_username);
        etPwd = (EditText) findViewById(R.id.et_pwd);
        btnLogin = (Button) findViewById(R.id.btn_login);
    }
}