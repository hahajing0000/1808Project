package com.zy.zg6.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.zy.zg6.R;
import com.zy.zg6.day5.MyDataBase;
import com.zy.zg6.day5.entity.UserEntity;

import java.util.List;
import java.util.concurrent.Executors;

public class RoomActivity extends AppCompatActivity {
    private EditText etRoomUsername;
    private EditText etRoomAge;
    private MyDataBase bawei_db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        initView();

        bawei_db = Room.databaseBuilder(this.getApplicationContext(), MyDataBase.class, "bawei_db").build();
    }

    private void initView() {
        etRoomUsername = (EditText) findViewById(R.id.et_room_username);
        etRoomAge = (EditText) findViewById(R.id.et_room_age);
    }

    public void addUserOnClick(View view) {

        Executors.newCachedThreadPool().submit(new Runnable() {
            @Override
            public void run() {
                String username=etRoomUsername.getText().toString().trim();
                String age=etRoomAge.getText().toString().trim();

                bawei_db.getUserDao().addUser(new UserEntity(username, TextUtils.isEmpty(age)?0:Integer.valueOf(age)));

                List<UserEntity> datas = bawei_db.getUserDao().findAll();
                Log.d("123","datas size is "+datas.size());
            }
        });


    }
}