package com.zy.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

/**
 * @author:zhangyue
 * @date:2021/4/8
 */
public class ServerService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }

    private List<Person> tempList=new ArrayList<>();
    IPersonInterface.Stub stub=new IPersonInterface.Stub() {
        @Override
        public void addPerson(Person inPerson, Person outPerson) throws RemoteException {
            Log.d("123","服务端：开接收客户端的参数。。。");
            if (inPerson!=null){
                tempList.add(inPerson);
            }

            if (outPerson==null){
                Log.d("123","没有接收到客户端传递的小花同学");


            }else{
                Log.d("123","小花："+outPerson.toString());
//                outPerson=new Person();
                outPerson.setAge(20);
                outPerson.setName("小红");
            }
        }
    };
}
