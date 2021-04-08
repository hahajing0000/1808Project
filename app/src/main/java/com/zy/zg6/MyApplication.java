package com.zy.zg6;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.zy.log.LogLevel;
import com.zy.log.LogType;
import com.zy.log.ZLog;
import com.zy.log.ZLogManager;

import java.util.Stack;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.multidex.MultiDex;

/**
 * @author:zhangyue
 * @date:2021/3/25
 */
public class MyApplication extends Application {

//    Stack<Activity> activities=new Stack<>();


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);


        MultiDex.install(base);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public void onCreate() {
        super.onCreate();
//        String processName = getProcessName();
//
//        String processName1 = getApplicationInfo().processName;
        /**
         * Log框架的初始化
         */
        ZLog zlog = new ZLog.Builder()
                .setLogType(LogType.LOGCAT)
                .setLevel(LogLevel.DEBUG)
                .setTag("123")
                .build();

        ZLogManager.getInstance().init(zlog);

//        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
//
//            }
//        });


//        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
//            @Override
//            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
//                Log.d("123","onActivityCreated name="+activity.getClass().getSimpleName());
//
//            }
//
//            @Override
//            public void onActivityStarted(@NonNull Activity activity) {
//                Log.d("123","onActivityStarted name="+activity.getClass().getSimpleName());
//            }
//
//            @Override
//            public void onActivityResumed(@NonNull Activity activity) {
//                Log.d("123","onActivityResumed name="+activity.getClass().getSimpleName());
//            }
//
//            @Override
//            public void onActivityPaused(@NonNull Activity activity) {
//
//            }
//
//            @Override
//            public void onActivityStopped(@NonNull Activity activity) {
//
//            }
//
//            @Override
//            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
//
//            }
//
//            @Override
//            public void onActivityDestroyed(@NonNull Activity activity) {
//
//            }
//        });


    }


}
