package com.zy.zg6.viewmodel;

import com.zy.zg6.entity.PersonEntity;
import com.zy.zg6.entity.ReqLoginUser;
import com.zy.zg6.entity.UserEntity;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author:zhangyue
 * @date:2021/3/25
 */
public class MyViewModel extends ViewModel {
    private MutableLiveData<ReqLoginUser> dataSource;
    public MutableLiveData<ReqLoginUser> getDataSource(){
        if (dataSource==null){
            dataSource=new MutableLiveData<>();
        }
        return dataSource;
    }


    public void testOnClick(){
        ReqLoginUser entity=new ReqLoginUser();
        entity.setPhoneNumber("小工");
        dataSource.setValue(entity);
    }
}
