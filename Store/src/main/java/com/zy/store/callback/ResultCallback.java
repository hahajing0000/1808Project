package com.zy.store.callback;

/**
 * @author:zhangyue
 * @date:2021/3/31
 */
public interface ResultCallback<T> {
    void Success(T t);
}
