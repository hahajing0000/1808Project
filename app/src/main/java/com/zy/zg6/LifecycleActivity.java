package com.zy.zg6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zy.zg6.day4.MyObserver;

public class LifecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        getLifecycle().addObserver(new MyObserver());
    }
}