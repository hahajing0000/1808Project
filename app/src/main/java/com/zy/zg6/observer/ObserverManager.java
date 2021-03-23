package com.zy.zg6.observer;

import androidx.databinding.adapters.ToolbarBindingAdapter;

/**
 * @author:zhangyue
 * @date:2021/3/23
 */
public class ObserverManager {
    private static volatile ObserverManager instance=null;
    private ObserverManager(){
        myObserverable=new MyObserverable();
    }
    public static ObserverManager getInstance(){
        if (null==instance){
            synchronized (ObserverManager.class){
                if (null==instance){
                    instance=new ObserverManager();

                }
            }
        }
        return instance;
    }

    public void sendMsg(Object... params){
        getMyObserverable().notifyAllObserver(params);
    }

    private  MyObserverable myObserverable;

    public MyObserverable getMyObserverable() {
        return myObserverable;
    }

    public void registerObserver(MyObserver observer){
        getMyObserverable().addObserver(observer);
    }
}
