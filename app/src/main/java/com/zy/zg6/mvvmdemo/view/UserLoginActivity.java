package com.zy.zg6.mvvmdemo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zy.core.view.BaseMVVMActivity;
import com.zy.zg6.BR;
import com.zy.zg6.R;
import com.zy.zg6.databinding.UserLoginDataBinding;
import com.zy.zg6.mvvmdemo.viewmodel.UserLoginViewModel;

public class UserLoginActivity extends BaseMVVMActivity<UserLoginViewModel, UserLoginDataBinding> {


    @Override
    protected int getVariable() {
        return BR.reqData;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_login;
    }

    @Override
    protected UserLoginViewModel createViewModel() {
        return new UserLoginViewModel(this);
    }
}