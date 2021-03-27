package com.zy.net.api;

import com.zy.net.BaseRespEntity;

import androidx.lifecycle.LiveData;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author:zhangyue
 * @date:2021/3/27
 */
public interface UserCenterApi {

    @POST("/login")
    @FormUrlEncoded
    LiveData<BaseRespEntity<Object>> login(@Field("username") String username, @Field("pwd") String pwd);
}
