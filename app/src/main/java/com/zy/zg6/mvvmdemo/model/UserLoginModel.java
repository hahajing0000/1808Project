package com.zy.zg6.mvvmdemo.model;

import com.zy.core.IModel;
import com.zy.net.NetTools;
import com.zy.zg6.mvvmdemo.model.service.api.LoginApi;
import com.zy.zg6.mvvmdemo.model.service.entity.BaseRespEntity;
import com.zy.zg6.mvvmdemo.model.service.entity.LoginEntity;
import com.zy.zg6.mvvmdemo.model.service.entity.UserLoginEntity;

import androidx.lifecycle.LiveData;
import retrofit2.Retrofit;

/**
 * @author:zhangyue
 * @date:2021/3/26
 */
public class UserLoginModel implements IModel {

    public LiveData<BaseRespEntity<LoginEntity>> login(LoginEntity entity){
        return NetTools.getInstance().create(LoginApi.class);

    }
}
