package com.zy.zg6.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.zy.zg6.R;
import com.zy.zg6.databinding.MineViewModel;
import com.zy.zg6.entity.PersonEntity;
import com.zy.zg6.entity.ReqLoginUser;
import com.zy.zg6.entity.UserEntity;
import com.zy.zg6.viewmodel.MyViewModel;

public class ViewModelActivity extends AppCompatActivity {
    public ObservableField<String> tempName=new ObservableField<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_view_model);
        MineViewModel mvm  =DataBindingUtil.setContentView(this,R.layout.activity_view_model);
        MyViewModel myViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(MyViewModel.class);
        mvm.setViewmodel(myViewModel);
        mvm.setSource(this);

        myViewModel.getDataSource().observe(this, new Observer<ReqLoginUser>() {
            @Override
            public void onChanged(ReqLoginUser userEntity) {
                Log.d("123",""+userEntity.toString());
                //更新逻辑
                tempName.set(userEntity.getPhoneNumber());
            }
        });
    }
}