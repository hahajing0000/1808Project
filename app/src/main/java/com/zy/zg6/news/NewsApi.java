package com.zy.zg6.news;

import com.zy.net.BaseRespEntity;

import java.util.List;

import androidx.lifecycle.LiveData;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author:zhangyue
 * @date:2021/4/3
 */
public interface NewsApi {
    @GET("api/News/getNews?")
    LiveData<BaseRespEntity<List<NewsEntity>>> getList(@Query("newstype") int newstype, @Query("pagenum") int pagenum, @Query("pagesize") int pagesize);

}
