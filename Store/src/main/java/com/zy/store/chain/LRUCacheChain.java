package com.zy.store.chain;

import com.zy.store.StorageChain;
import com.zy.store.callback.ResultCallback;
import com.zy.store.utils.LRUCacheUtils;

/**
 * @author:zhangyue
 * @date:2021/3/31
 */
public class LRUCacheChain<T> extends StorageChain<T> {
    @Override
    protected void clearData() {
        LRUCacheUtils.getInstance().clear();
    }

    @Override
    protected void removeAtKey(String key) {
        LRUCacheUtils.getInstance().removeValue(key);
    }

    @Override
    protected void saveData(String key, T data) {
        LRUCacheUtils.getInstance().putValue(key,data);
    }

    @Override
    protected void getData(String key, ResultCallback<T> callback) {
        if (callback==null){
            throw new IllegalArgumentException("callback paramter is null");
        }
        callback.Success((T) LRUCacheUtils.getInstance().getValue(key));
    }
}
