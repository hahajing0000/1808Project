package com.zy.zg6.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhangyue
 * @date:2021/3/23
 */
public class MyObserverable {
    private List<MyObserver> observerList=new ArrayList<MyObserver>();
    public void addObserver(MyObserver observer){
        if (observerList.contains(observer)){
            return;
        }

        observerList.add(observer);
    }

    public void removeObserver(MyObserver observer){
        if (observerList.contains(observer)){
            observerList.remove(observer);
        }
    }

    public void notifyAllObserver(Object... params){
        for (MyObserver observer:
             observerList) {
            observer.notifyMsg(params);
        }
    }
}
