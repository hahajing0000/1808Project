package com.zy.zg6.view;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.zy.core.view.BaseActivity;
import com.zy.zg6.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author:zhangyue
 * @date:2021/3/30
 */
public class BottomNavViewActivity extends BaseActivity {
    private BottomNavigationView bnvNav;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomnavview);

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
