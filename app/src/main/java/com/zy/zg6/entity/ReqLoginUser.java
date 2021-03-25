package com.zy.zg6.entity;

import com.zy.zg6.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * @author:zhangyue
 * @date:2021/3/25
 */
public class ReqLoginUser extends BaseObservable {
    private String phoneNumber;
    private String pwd;

    @Bindable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        notifyPropertyChanged(BR.phoneNumber);
    }

    @Bindable
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
        notifyPropertyChanged(BR.pwd);
    }

    @Override
    public String toString() {
        return "ReqLoginUser{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
