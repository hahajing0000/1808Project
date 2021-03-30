package com.zy.zg6.view;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.zy.core.view.BaseActivity;
import com.zy.store.utils.LRUCacheUtils;
import com.zy.zg6.R;

import java.util.LinkedHashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author:zhangyue
 * @date:2021/3/30
 */
public class BottomNavViewActivity extends BaseActivity {
    private BottomNavigationView bnvNav;



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomnavview);

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
    }


}
