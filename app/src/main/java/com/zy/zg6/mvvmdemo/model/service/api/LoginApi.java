package com.zy.zg6.mvvmdemo.model.service.api;

import com.zy.net.BaseRespEntity;
import com.zy.zg6.mvvmdemo.model.service.entity.LoginEntity;

import androidx.lifecycle.LiveData;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author:zhangyue
 * @date:2021/3/27
 */
public interface LoginApi {

    @POST("api/User/login")
    LiveData<BaseRespEntity<LoginEntity>> login(@Body LoginEntity entity);
}
