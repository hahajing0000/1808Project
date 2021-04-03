package com.zy.net;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.zy.net.utils.GsonUtils;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhangyue
 * @date:2021/3/27
 */
public class BaseRespEntity<T> {
    private int code;
    private T data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData(){
        return data;
    }

    /**
     * 当服务器返回List集合时 解决LinkedTreeMap的问题
     * @param _type List中的泛型类型
     * @return
     */
    public T getData(Class<?> _type) {
        if (data instanceof java.util.List){
            List<Object> targetList=new ArrayList<>();
            List<Object> tempList= (List<Object>) data;
            for (Object t:tempList){
                if (t instanceof LinkedTreeMap){

                    String newJsonStr = GsonUtils.getInstance().getGson().toJson(t);
                    Object newInstance = GsonUtils.getInstance().getGson().fromJson(newJsonStr, _type);
                    targetList.add(newInstance);
                }
            }
            data= (T) targetList;
        }
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BaseRespEntity{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

//    public Class<T> getTClass()
//    {
//        Class<T> tClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//        return tClass;
//    }
}
