package com.zy.core.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author:zhangyue
 * @date:2021/3/26
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHalfTransparent();
    }

    public void startActivity(Class<?> clazz){
        startActivity(new Intent(this,clazz));
    }

    public void startActivity(Class<?> clazz, Bundle bundle){
        Intent intent=new Intent(this,clazz);
        intent.putExtra("data",bundle);
        startActivity(intent);
    }

    public void showMsg(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    public void showLongMsg(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    /**
     * 显示Loading 待实现
     */
    public void showLoading(){

    }

    /**
     * 隐藏Loading 隐藏实现
     */
    public void hideLoading(){

    }

    /**
     * 半透明状态栏
     */
    protected void setHalfTransparent() {
        if (Build.VERSION.SDK_INT >= 21) {//21表示5.0
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else if (Build.VERSION.SDK_INT >= 19) {//19表示4.4
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //虚拟键盘也透明
            // getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}
