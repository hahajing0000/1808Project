package com.zy.msgbus;

import com.zy.log.ZLog;
import com.zy.log.ZLogManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:zhangyue
 * @date:2021/4/1
 */
public class MsgObservable {
    private volatile List<MsgObserver> observerList=new ArrayList<>();

    /**
     * 注册观察者
     * @param _observer
     */
    public synchronized void registObserver(MsgObserver _observer){
        if (observerList.contains(_observer)){
            ZLogManager.getInstance().w("this Observer is exists...");
            return;
        }

        observerList.add(_observer);

    }

    /**
     * 注销观察者
     * @param _observer
     */
    public synchronized void unRegistObserver(MsgObserver _observer){
        if (observerList.contains(_observer)){
            this.observerList.remove(_observer);
            return;
        }
        ZLogManager.getInstance().w("this Observer is not exists...");
    }

    /**
     * 通知所有的观察者
     * @param params
     */
    public synchronized void notifyAllObservers(Object... params){
        for (MsgObserver observer:
             observerList) {
            observer.notify(params);
        }
    }

}
