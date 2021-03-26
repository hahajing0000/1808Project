package com.zy.zg6.other;

import android.util.Log;

import com.zy.zg6.entity.ReqLoginUser;

/**
 * @author:zhangyue
 * @date:2021/3/25
 */
public class LoginHandler {
    public void loginOnClick(ReqLoginUser loginUser){
        Log.d("123","Content:"+loginUser.toString());
    }
}
