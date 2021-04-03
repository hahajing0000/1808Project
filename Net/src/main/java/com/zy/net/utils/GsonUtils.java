package com.zy.net.utils;

import com.google.gson.Gson;

import java.util.concurrent.RecursiveTask;

/**
 * @author:zhangyue
 * @date:2021/4/3
 */
public class GsonUtils {
    private Gson gson;
    private GsonUtils(){}
    private static class GsonUtilsHandler{
        private static GsonUtils INSTANCE=new GsonUtils();
    }

    public static GsonUtils getInstance(){
        return GsonUtilsHandler.INSTANCE;
    }

    public synchronized Gson getGson(){
        if (gson==null){
            gson=new Gson();
        }

        return gson;
    }
}
