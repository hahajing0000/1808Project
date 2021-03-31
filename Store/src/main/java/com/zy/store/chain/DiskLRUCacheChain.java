package com.zy.store.chain;

import com.zy.store.StorageChain;
import com.zy.store.callback.ResultCallback;
import com.zy.store.utils.DiskLRUCacheUtils;

/**
 * @author:zhangyue
 * @date:2021/3/31
 */
public class DiskLRUCacheChain<T> extends StorageChain<T> {
    @Override
    protected void clearData() {
        DiskLRUCacheUtils.getInstance().clear();
    }

    @Override
    protected void removeAtKey(String key) {
        DiskLRUCacheUtils.getInstance().removeValue(key);
    }

    @Override
    protected void saveData(String key, T data) {
        DiskLRUCacheUtils.getInstance().putValue(key,data);
    }

    @Override
    protected void getData(String key, ResultCallback<T> callback) {
        if (callback==null){
            throw new IllegalArgumentException("callback is null");
        }

        callback.Success((T) DiskLRUCacheUtils.getInstance().getValue(key));
    }
}
