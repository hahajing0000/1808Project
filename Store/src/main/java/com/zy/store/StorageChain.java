package com.zy.store;

import com.zy.store.callback.ResultCallback;

import javax.xml.transform.Result;

/**
 * @author:zhangyue
 * @date:2021/3/31
 */
public abstract class StorageChain<T> {

    /**
     * 链名称
     */
    protected String chainName;

    /**
     * 前一个节点
     */
    protected StorageChain previousChain;

    /**
     * 后一个节点
     */
    protected StorageChain nextChain;

    /**
     * 清空所有数据
     */
    protected abstract void clearData();

    /**
     * 按Key删除指定数据
     * @param key
     */
    protected abstract void removeAtKey(String key);

    /**
     * 存入数据
     * @param key
     * @param data
     */
    protected abstract  void saveData(String key,T data);

    /**
     * 获取数据
     * @param key
     * @param callback
     */
    protected abstract void getData(String key, ResultCallback<T> callback);


    /**
     * 设置下一个节点——同上指定nextChain的上一个节点就是this
     * @param nextChain
     */
    public void setNextChain(StorageChain nextChain){
        this.nextChain=nextChain;
        nextChain.previousChain=this;


    }

    /**
     * 存入值
     * @param key
     * @param data
     */
    public void putValue(String key,T data){
        saveData(key,data);
        if (this.nextChain!=null){
            this.nextChain.putValue(key,data);
        }
    }

    /**
     * 获取Value
     * @param key
     * @param callback 获取Value成功的回调
     */
    public void getValue(final String key, final ResultCallback<T> callback){
        getData(key, new ResultCallback<T>() {
            @Override
            public void Success(T data) {
                if (data==null){
                    nextChain.getValue(key,callback);
                }else{
                    if (previousChain!=null){
                        previousChain.putValue(key,data);
                    }

                    callback.Success(data);
                }
            }
        });
    }

    /**
     * 根据key删除值
     * @param key
     */
    public void removeValue(String key){
        removeAtKey(key);
        if (this.nextChain!=null){
            this.nextChain.removeValue(key);
        }
    }

    /**
     * 清空值
     */
    public void clear(){
        clearData();
        if (this.nextChain!=null){
            this.nextChain.clear();
        }
    }
}
