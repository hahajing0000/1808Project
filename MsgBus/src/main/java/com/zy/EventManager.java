package com.zy;

import com.zy.msgbus.MsgObservable;
import com.zy.msgbus.MsgObserver;

/**
 * @author:zhangyue
 * @date:2021/4/1
 */
public class EventManager {
    private MsgObservable observable=new MsgObservable();
    private EventManager(){}
    private static class A{
        private static EventManager INSTANCE=new EventManager();
    }
    public static EventManager getInstance(){
        return A.INSTANCE;
    }

    /**
     * 注册观察者
     * @param _observer
     */
    public void registObserver(MsgObserver _observer){
        observable.registObserver(_observer);
    }

    /**
     * 注销观察者
     * @param _observer
     */
    public void unRegistObserver(MsgObserver _observer){
        observable.unRegistObserver(_observer);
    }

    /**
     * 发送通知
     * @param params
     */
    public void SendMsg(Object... params){
        observable.notifyAllObservers(params);
    }
}
