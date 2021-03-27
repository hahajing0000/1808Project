package com.zy.zg6.mvvmdemo.model;

import com.zy.core.IModel;
import com.zy.net.BaseRespEntity;
import com.zy.net.NetTools;
import com.zy.zg6.mvvmdemo.model.service.api.LoginApi;
import com.zy.zg6.mvvmdemo.model.service.entity.LoginEntity;

import androidx.lifecycle.LiveData;

/**
 * @author:zhangyue
 * @date:2021/3/26
 */
public class UserLoginModel implements IModel {

    public LiveData<BaseRespEntity<LoginEntity>> login(LoginEntity entity){
        LoginApi api = NetTools.getInstance().create(LoginApi.class);
        return api.login(entity);
    }
}
