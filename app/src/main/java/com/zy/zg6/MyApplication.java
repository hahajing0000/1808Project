package com.zy.zg6;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import java.util.Stack;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author:zhangyue
 * @date:2021/3/25
 */
public class MyApplication extends Application {

//    Stack<Activity> activities=new Stack<>();

    @Override
    public void onCreate() {
        super.onCreate();

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
