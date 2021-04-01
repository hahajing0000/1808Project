package com.zy.common.async;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executors;

/**
 * @author:zhangyue
 * @date:2021/4/1
 *
 * AsyncTask
 * Runnable
 * Thread
 * Executers
 * IntentService
 * HandlerThread
 *
 *
 */
public class AsyncUtils {

    public static void run(Runnable runnable){
//        Thread thread=new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).start();
//        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(0,Integer.MAX_VALUE,5,TimeUnit.SECONDS, new LinkedBlockingQueue());
//        threadPoolExecutor.allowCoreThreadTimeOut(true);
//
//        Executors.newCachedThreadPool().submit(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//
//        Executors.newFixedThreadPool(4).execute(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//
//        Executors.newScheduledThreadPool(1).schedule(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        },5 ,TimeUnit.SECONDS);
//
//        Executors.newSingleThreadExecutor().execute(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//        Future<?> submit = Executors.newCachedThreadPool().submit(runnable);
//        try {
//            String o = (String) submit.get();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        checkThread();
        Executors.newCachedThreadPool().execute(runnable);
    }

    private static Handler mHandler=new Handler(Looper.getMainLooper());
    public static void updateUI(Runnable runnable){
        mHandler.post(runnable);

//        Looper.prepare();
//        //创建Handler
//        Looper.loop();
    }
}
