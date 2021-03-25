package com.zy.zg6.entity;

import com.zy.zg6.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * @author:zhangyue
 * @date:2021/3/24
 */
public class ObservablePersonEntity extends BaseObservable {
    private int id;
    private String name;
    private int age;

    @Bindable
    public int getId() {
        return id;
    }
    @Bindable
    public String getName() {
        return name;
    }
    @Bindable
    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }
}
