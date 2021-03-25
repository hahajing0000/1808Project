package com.zy.zg6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.zy.zg6.entity.UserEntity;

public class LiveDataActivity extends AppCompatActivity {

    private MutableLiveData<UserEntity> liveData=new MutableLiveData<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        liveData.observe(this, new Observer<UserEntity>() {
            @Override
            public void onChanged(UserEntity userEntity) {
                Log.d("123",userEntity.toString());
            }
        });

    }

    private Handler mHandler=new Handler();

    public void onLiveDataClick(View view) {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                UserEntity userEntity=new UserEntity();
                userEntity.setAge(23);
                userEntity.setAddress("天津");
                userEntity.setName("小红");
                liveData.postValue(userEntity);
            }
        },5000);
    }
}