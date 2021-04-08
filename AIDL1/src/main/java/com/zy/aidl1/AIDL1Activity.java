package com.zy.aidl1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import com.zy.aidl.IPersonInterface;
import com.zy.aidl.Person;

public class AIDL1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl1);
    }

    public void aidlOnClick(View view) {
//        startService(new Intent(this,ClientService.class));

        Intent intent1=new Intent();
//        intent1.setClassName(this,"com.zy.aidl.ServerService");
        intent1.setPackage("com.zy.aidl2");
        intent1.setAction("com.zy.aidl.action");
        Log.d("123","准备bind远程服务");
        bindService(intent1,serviceConnection,BIND_AUTO_CREATE);
    }


    private ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("123","服务已经链接");
            IPersonInterface iPersonInterface = IPersonInterface.Stub.asInterface(service);
            Person person1=new Person();
            person1.setAge(10);
            person1.setName("小明");

            Person person2=new Person();
            person2.setAge(20);
            person2.setName("小花");
            try {
                iPersonInterface.addPerson(person1,person2);
                Log.d("123",""+person2.toString());
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("123","服务已经断开");
        }
    };
}
