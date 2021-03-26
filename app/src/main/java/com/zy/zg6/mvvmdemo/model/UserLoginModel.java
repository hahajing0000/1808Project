package com.zy.zg6.mvvmdemo.model;

import android.os.SystemClock;

import com.zy.core.BaseRepository;
import com.zy.core.IModel;
import com.zy.zg6.mvvmdemo.model.entity.BaseRespEntity;
import com.zy.zg6.mvvmdemo.model.entity.UserLoginEntity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * @author:zhangyue
 * @date:2021/3/26
 */
public class UserLoginModel implements IModel {

    public LiveData<BaseRespEntity<UserLoginEntity>> login(UserLoginEntity entity){
        SystemClock.sleep(500);
        MutableLiveData<BaseRespEntity<UserLoginEntity>> result=new MutableLiveData<>();
        BaseRespEntity<UserLoginEntity> data=new BaseRespEntity<>();
        data.setCode(200);
        data.setData(new UserLoginEntity(1,"小明","123456"));
        result.setValue(data);
        return result;
    }
}
