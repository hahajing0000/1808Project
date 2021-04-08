package com.zy.aidl1;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.zy.aidl.IPersonInterface;
import com.zy.aidl.Person;

import androidx.annotation.Nullable;

/**
 * @author:zhangyue
 * @date:2021/4/8
 */
public class ClientService extends Service {




    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        return super.onStartCommand(intent, flags, startId);
    }


}
