package com.zy.zg6.mvvmdemo.repository;

import com.zy.core.BaseRepository;
import com.zy.zg6.mvvmdemo.model.UserLoginModel;
import com.zy.zg6.mvvmdemo.model.entity.BaseRespEntity;
import com.zy.zg6.mvvmdemo.model.entity.UserLoginEntity;

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

    public LiveData<BaseRespEntity<UserLoginEntity>> login(UserLoginEntity entity){
        //判断网络状态  如果可用
        return mModel.login(entity);
    }
}
