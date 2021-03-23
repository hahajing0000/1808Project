package com.zy.zg6.observer;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

/**
 * @author:zhangyue
 * @date:2021/3/23
 */
public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ObserverManager.getInstance().sendMsg("我是服务发送的消息");
        return super.onStartCommand(intent, flags, startId);
    }
}
