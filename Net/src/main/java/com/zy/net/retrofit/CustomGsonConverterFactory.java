package com.zy.net.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.zy.net.BaseRespEntity;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * @author:zhangyue
 * @date:2021/4/3
 */
public class CustomGsonConverterFactory extends Converter.Factory {
    public static CustomGsonConverterFactory create() {
        Gson gson=new Gson();//new GsonBuilder().registerTypeHierarchyAdapter(BaseRespEntity.class,new ResultJsonDeser()).create();
        return create(gson);
    }

    public static CustomGsonConverterFactory create(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        return new CustomGsonConverterFactory(gson);
    }

    private final Gson gson;

    private CustomGsonConverterFactory(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
        TypeToken<?> typeToken = TypeToken.get(type);
//        Type parameterUpperBound = getParameterUpperBound(0, (ParameterizedType) type);
//        Class<?> rawObservableType = getRawType(parameterUpperBound);
        TypeAdapter<?> adapter = gson.getAdapter(typeToken);

//        Type type2=type.getClass().getGenericSuperclass();
//        if (type2 instanceof ParameterizedType){
//            ParameterizedType subType= (ParameterizedType) type2;
//        }

        return new CustomGsonResponseBodyConverter<>(gson, adapter);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new CustomGsonRequestBodyConverter<>(gson, adapter);
    }

}
