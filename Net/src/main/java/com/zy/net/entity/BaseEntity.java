package com.zy.net.entity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author:zhangyue
 * @date:2021/4/3
 */
public class BaseEntity<T> {
    protected final Type _type;

    protected BaseEntity() {
        Type superClass = this.getClass().getGenericSuperclass();
        if(superClass instanceof Class) {
            throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
        } else {
            this._type = ((ParameterizedType)superClass).getActualTypeArguments()[0];
        }
    }

    public Type getType() {
        return this._type;
    }
}
