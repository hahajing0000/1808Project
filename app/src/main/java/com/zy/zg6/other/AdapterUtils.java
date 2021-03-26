package com.zy.zg6.other;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingConversion;

/**
 * @author:zhangyue
 * @date:2021/3/24
 */
public class AdapterUtils {
    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String url) {
        Log.d("123","11111111111111");
    }

    @BindingAdapter("android:paddingLeft")
    public static void setPaddingLeft(View view, int padding) {
        view.setPadding(padding,
                view.getPaddingTop(),
                view.getPaddingRight(),
                view.getPaddingBottom());
    }

    @BindingAdapter(value = {"imageNetUrl", "error"},requireAll = false)
    public static void loadImage2(ImageView view, String url, Drawable error) {
        //Glide加载网络图片

    }

    @BindingConversion
    public static ColorDrawable convert(int color) {
        return new ColorDrawable(color);
    }



    @BindingConversion
    public static int convertString(double age) {
        return (int)age;
    }

//    @BindingConversion
//    public static String convertToString(int age) {
//        return String.valueOf(age);
//    }
}
