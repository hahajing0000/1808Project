package com.zy.zg6.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;
import android.widget.Toast;

import com.zy.zg6.R;
import com.zy.zg6.databinding.ActivityDoubleBindBinding;
import com.zy.zg6.entity.PersonEntity;

public class DoubleBindActivity extends AppCompatActivity {

    private PersonEntity entity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_double_bind);
        ActivityDoubleBindBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_double_bind);
        entity = new PersonEntity();
        entity.name.set("小明");
        viewDataBinding.setSource(entity);
        viewDataBinding.setOwner(this);
    }

    public void onClick(){
        Toast.makeText(this,entity.name.get(),Toast.LENGTH_SHORT).show();
    }
}