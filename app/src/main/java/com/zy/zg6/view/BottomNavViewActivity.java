package com.zy.zg6.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.zy.EventManager;
import com.zy.common.async.AsyncUtils;
import com.zy.core.view.BaseActivity;
import com.zy.log.ZLogManager;
import com.zy.msgbus.MsgObserver;
import com.zy.net.BaseRespEntity;
import com.zy.net.NetTools;
import com.zy.wiget.StateLayout;
import com.zy.zg6.ObservableService;
import com.zy.zg6.R;
import com.zy.zg6.designmode.BuilderMode;
import com.zy.zg6.designmode.command.CmdManager;
import com.zy.zg6.designmode.command.IJSCmd;
import com.zy.zg6.designmode.command.impl.ChenCmd;
import com.zy.zg6.designmode.command.impl.ChuCmd;
import com.zy.zg6.designmode.command.impl.JiaCmd;
import com.zy.zg6.designmode.command.impl.JianCmd;
import com.zy.zg6.designmode.decorator.DecoratorTest;
import com.zy.zg6.designmode.decorator.ITest;
import com.zy.zg6.designmode.decorator.TestImpl;
import com.zy.zg6.designmode.proxy.IDO;
import com.zy.zg6.designmode.proxy.JingLian;
import com.zy.zg6.designmode.proxy.WangPo;
import com.zy.zg6.news.NewsApi;
import com.zy.zg6.news.NewsEntity;
import com.zy.zg6.observer.MyObserver;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author:zhangyue
 * @date:2021/3/30
 */
public class BottomNavViewActivity extends BaseActivity  {//implements MsgObserver
    private BottomNavigationView bnvNav;
    private TextView tvBnvTxt;
    private StateLayout stateLayout;



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomnavview);

//        IDO ido=new WangPo(new JingLian());
//        ido.Do();

//        ITest test=new DecoratorTest(new TestImpl());
//        test.test();

//        BuilderMode build = new BuilderMode.Builder()
//                .setIsRadius(true)
//                .setSavePath("")
//                .build();
//
//        build.loadImg(this,"",null);
//        startService(new Intent(this, ObservableService.class));

//        //注册观察者
//        EventManager.getInstance().registObserver(this);

//        LinkedHashMap<String,String> map=new LinkedHashMap<>(0,0.75F,true);
//
//        map.put("1","11");
//        map.put("2","22");
//        map.put("3","33");
//        map.put("4","44");
//
//
//        map.replace("2","22","222222");
//
//        map.put("5","55");
//        map.replace("1","11","1111");
//
//        for (Map.Entry<String,String> entry: map.entrySet()){
//            Log.d("123","key = "+entry.getKey()+" value="+entry.getValue());
//        }

//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                EventManager.getInstance().SendMsg(9001);
//            }
//        },3000);

//        IDO jingLian=new JingLian();
//        IDO wangpo= (IDO) Proxy.newProxyInstance(jingLian.getClass().getClassLoader(),jingLian.getClass().getInterfaces(),new DyamicProxy(jingLian));
//        wangpo.Do();

//        int a=10;
//        int b =5;
//        IJSCmd jiaCmd=new JiaCmd();
//        IJSCmd jianCmd=new JianCmd();
//        IJSCmd chengCmd=new ChenCmd();
//        IJSCmd chuCmd=new ChuCmd();
//        IJSCmd jiaCmd2=new JianCmd();
//
//        CmdManager cmdManager = new CmdManager();
//        cmdManager.addCmd(jiaCmd);
//        cmdManager.addCmd(jianCmd);
//        cmdManager.addCmd(chengCmd);
//        cmdManager.addCmd(chuCmd);
//        cmdManager.addCmd(jiaCmd2);
//
//        cmdManager.executeCmds(a,b);


        stateLayout = (StateLayout) findViewById(R.id.stateLayout);

        tvBnvTxt = (TextView) findViewById(R.id.tv_bnv_txt);
        bnvNav = (BottomNavigationView) findViewById(R.id.bnv_nav);

        bnvNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_home:
                        showMsg("主页");
                        break;
                    case R.id.nav_type:
                        showMsg("分类");
                        break;
                    case R.id.nav_mine:
                        showMsg("我的");
                        break;
                }

                return true;
            }
        });

        bnvNav.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);

        tvBnvTxt.setOnClickListener((view)->{

        });

    }



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        stateLayout.showMsg("Hello World",5,5);

        AsyncUtils.run(new Runnable() {
            @Override
            public void run() {
//                    SystemClock.sleep(4000);
                AsyncUtils.updateUI(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("123","---》"+Thread.currentThread().getName());
                        tvBnvTxt.setText("111");
                    }
                });
            }
        });

        NewsApi api = NetTools.getInstance().create(NewsApi.class);
        LiveData<BaseRespEntity<List<NewsEntity>>> list = api.getList(1, 0, 10);
        list.observe(this, new Observer<BaseRespEntity<List<NewsEntity>>>() {
            @Override
            public void onChanged(BaseRespEntity<List<NewsEntity>> listBaseRespEntity) {
                List<NewsEntity> data = listBaseRespEntity.getData(NewsEntity.class);
                for (NewsEntity entity:data){
                    Log.d("123",entity.getDescription());
                }
            }
        });

    }

    public void onTestClick(View view) {
            IDo anything=new Do2Anything();
            anything.Do();
    }


    //    private Handler mHandler=new Handler();

//    @Override
//    public void notify(Object... params) {
//        ZLogManager.getInstance().d("接收到被观察者发送的消息，内容->"+params[0].toString());
//    }

    public interface IDo{
        void Do();
    }

    public class DoAnything implements IDo{
        @Override
        public void Do(){

        }
    }

    public class Do2Anything implements IDo{

        @Override
        public void Do() {

        }
    }

    class DyamicProxy implements InvocationHandler{
        private Object obj;
        public DyamicProxy(Object _obj){
            obj=_obj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("方法执行前");

            Object result= method.invoke(obj,args);
            System.out.println("方法执行后");
            return result;
        }
    }
}
