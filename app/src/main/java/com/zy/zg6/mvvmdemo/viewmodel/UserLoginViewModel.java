package com.zy.zg6.mvvmdemo.viewmodel;

import android.util.Log;

import com.zy.core.BaseViewModel;
import com.zy.log.ZLogManager;
import com.zy.net.BaseRespEntity;
import com.zy.zg6.mvvmdemo.model.service.entity.LoginEntity;
import com.zy.zg6.mvvmdemo.repository.UserLoginRepository;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

/**
 * @author:zhangyue
 * @date:2021/3/26
 */
public class UserLoginViewModel extends BaseViewModel<UserLoginRepository> {
    public LoginEntity reqUserEntity=new LoginEntity();
    public UserLoginViewModel(LifecycleOwner _owner) {
        super(_owner);
    }

    @Override
    protected UserLoginRepository createRepository() {
        return new UserLoginRepository();
    }

    @Override
    protected void disConnectionView() {

    }

    @Override
    protected void connectionView() {

    }

    public void loginCmd(LoginEntity entity){
        ZLogManager.getInstance().w("我是一条测试的Log");
        mRepository.login(entity).observe(mOwner, new Observer<BaseRespEntity<LoginEntity>>() {
            @Override
            public void onChanged(BaseRespEntity<LoginEntity> result) {

                ZLogManager.getInstance().d("result->"+result.toString());
            }
        });

    }
}
