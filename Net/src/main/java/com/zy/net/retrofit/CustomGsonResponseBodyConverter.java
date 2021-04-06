package com.zy.net.retrofit;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.zy.net.BaseRespEntity;
import com.zy.net.entity.BaseEntity;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @author:zhangyue
 * @date:2021/4/3
 */
final class CustomGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    CustomGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override public T convert(ResponseBody value) throws IOException {
        String string = value.string();


        BaseRespEntity t = this.gson.fromJson(string,BaseRespEntity.class);
//        if (t.getData() instanceof java.util.ArrayList){
//            List<BaseEntity> data = (List<BaseEntity>) t.getData();
//            if (data!=null){
//                for (int i=0;i<data.size();i++){
//                    Type type = data.get(i).getType();
//                    Log.d("123","type"+type);
//                }
//            }
//            int size = data.size();
//            Log.d("123",""+size);
//        }

        return (T) t;
    }
}