package com.zy.zg6.day4;

import android.util.Log;

import com.zy.zg6.entity.PersonEntity;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * @author:zhangyue
 * @date:2021/3/25
 */
public class MyObserver implements LifecycleObserver {

    //四大引用  强 软 弱 虚
//    PersonEntity personEntity=new PersonEntity();
//    SoftReference<PersonEntity> softReference=new SoftReference<PersonEntity>(personEntity);
//    WeakReference<PersonEntity> weakReference=new WeakReference<>(personEntity);
//    ReferenceQueue

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void observerCreated(){

        Log.d("123","onCreate lifecycle do start...");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void observerAny(){
        Log.d("123","..................");
    }


}
