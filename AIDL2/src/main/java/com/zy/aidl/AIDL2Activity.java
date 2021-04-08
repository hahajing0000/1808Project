package com.zy.aidl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class AIDL2Activity extends AppCompatActivity {

    private ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("123","111111111111");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("123","2222222222222222");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl2);

        Intent intent=new Intent();
        intent.setPackage("com.zy.aidl2");
        intent.setAction("com.zy.aidl.action");
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
    }
}
