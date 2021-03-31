package com.zy.store;

import com.zy.store.callback.ResultCallback;
import com.zy.store.chain.DiskLRUCacheChain;
import com.zy.store.chain.LRUCacheChain;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:zhangyue
 * @date:2021/3/31
 */
public class StorageChainManager<T> {
    private static volatile StorageChainManager instance=null;
    private StorageChainManager(){
        chainMap=new ConcurrentHashMap<>();
//        Hashtable  HashMap
    }
    public static StorageChainManager getInstance(){
        if (null==instance){
            synchronized (StorageChainManager.class){
                if (null==instance){
                    instance=new StorageChainManager();
                }
            }
        }
        return instance;
    }

    /**
     * 内存的节点（首节点）
     */
    private LRUCacheChain memoryCacheChain=null;
    /**
     * 磁盘节点
     */
    private DiskLRUCacheChain diskLRUCacheChain=null;

    private static ConcurrentHashMap<String,StorageChain> chainMap;

    /**
     * 存入值
     * @param key
     * @param value
     */
    public void putValue(String key,T value){
        if (!chainMap.containsKey(key)){
            initChain(key);
        }
        memoryCacheChain.putValue(key,value);
    }

    /**
     * 初始化链
     * @param key
     */
    private StorageChain initChain(String key) {
        memoryCacheChain=new LRUCacheChain();
        diskLRUCacheChain=new DiskLRUCacheChain();

        memoryCacheChain.setNextChain(diskLRUCacheChain);

        chainMap.put(key,memoryCacheChain);
        return diskLRUCacheChain;
    }

    /**
     * 取值
     * @param key
     * @param callback
     */
    public void getValue(String key, ResultCallback callback){
        if (chainMap.containsKey(key)){
            chainMap.get(key).getValue(key,callback);
        }
    }

    /**
     * 添加链节点
     * @param key
     * @param storageChain
     */
    public void addChain(String key,StorageChain storageChain){
        if (chainMap.containsKey(key)){
            StorageChain storageChain1 = chainMap.get(key);
            while (storageChain1!=null){
                storageChain1=storageChain.nextChain;
            }

            storageChain1.setNextChain(storageChain);
        }else{
            StorageChain storageChain1 = initChain(key);
            storageChain1.setNextChain(storageChain);
        }
    }

}
