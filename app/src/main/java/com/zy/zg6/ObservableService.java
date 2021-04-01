package com.zy.zg6;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.zy.EventManager;

import androidx.annotation.Nullable;

/**
 * @author:zhangyue
 * @date:2021/4/1
 */
public class ObservableService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        EventManager.getInstance().SendMsg("hello world");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
