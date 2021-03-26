package com.zy.zg6.mvvmdemo.viewmodel;

import android.util.Log;

import com.zy.core.BaseViewModel;
import com.zy.zg6.mvvmdemo.model.entity.BaseRespEntity;
import com.zy.zg6.mvvmdemo.model.entity.UserLoginEntity;
import com.zy.zg6.mvvmdemo.repository.UserLoginRepository;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

/**
 * @author:zhangyue
 * @date:2021/3/26
 */
public class UserLoginViewModel extends BaseViewModel<UserLoginRepository> {
    public UserLoginEntity reqUserEntity=new UserLoginEntity();
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

    public void loginCmd(UserLoginEntity entity){
        mRepository.login(entity).observe(mOwner, new Observer<BaseRespEntity<UserLoginEntity>>() {
            @Override
            public void onChanged(BaseRespEntity<UserLoginEntity> result) {
                Log.d("123","result->"+result.toString());
            }
        });

    }
}
