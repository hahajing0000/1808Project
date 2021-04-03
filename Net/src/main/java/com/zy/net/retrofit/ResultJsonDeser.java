package com.zy.net.retrofit;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.zy.net.BaseRespEntity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author:zhangyue
 * @date:2021/4/3
 */
public class ResultJsonDeser implements JsonDeserializer<BaseRespEntity<?>> {

    @Override
    public BaseRespEntity<?> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        BaseRespEntity response = new BaseRespEntity();
        if (json.isJsonObject()){
            JsonObject jsonObject = json.getAsJsonObject();
            int code = jsonObject.get("code").getAsInt();
            response.setCode(code);
            response.setMsg(jsonObject.get("msg").getAsString());
            if (code != 200){
                return response;
            }
            Type itemType = ((ParameterizedType) typeOfT).getActualTypeArguments()[0];
            response.setData(context.deserialize(jsonObject.get("data"), itemType));
            return response;
        }
        return response;
    }
}
