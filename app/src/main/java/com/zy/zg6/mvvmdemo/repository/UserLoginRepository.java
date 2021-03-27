package com.zy.zg6.mvvmdemo.repository;

import com.zy.core.BaseRepository;
import com.zy.net.BaseRespEntity;
import com.zy.zg6.mvvmdemo.model.UserLoginModel;
import com.zy.zg6.mvvmdemo.model.service.entity.LoginEntity;

import androidx.lifecycle.LiveData;

/**
 * @author:zhangyue
 * @date:2021/3/26
 */
public class UserLoginRepository extends BaseRepository<UserLoginModel> {
    @Override
    protected UserLoginModel createModel() {
        return new UserLoginModel();
    }

    public LiveData<BaseRespEntity<LoginEntity>> login(LoginEntity entity){
        //判断网络状态  如果可用
        return mModel.login(entity);
    }
}
