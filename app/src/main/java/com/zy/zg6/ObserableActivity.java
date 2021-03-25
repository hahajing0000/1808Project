package com.zy.zg6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.ViewDataBinding;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.zy.zg6.databinding.ActivityObserableBinding;
import com.zy.zg6.entity.ObservablePersonEntity;
import com.zy.zg6.entity.PersonEntity;
import com.zy.zg6.entity.UserEntity;

public class ObserableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_obserable);
        ActivityObserableBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_obserable);
        PersonEntity entity=new PersonEntity();
        viewDataBinding.setPerson(entity);
        ObservablePersonEntity observablePersonEntity=new ObservablePersonEntity();
        viewDataBinding.setObservableperson(observablePersonEntity);
        viewDataBinding.setOwner(this);
        UserEntity entity1=new UserEntity();
        entity1.setAge(15);
        viewDataBinding.setUser(entity1);

        viewDataBinding.setInttest(10);


        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                entity.age.set(20);
                entity.name.set("xiaoming");
                entity.headerImg.set("http://www.xxx.com/1.jpg");

                observablePersonEntity.setAge(30);
                observablePersonEntity.setName("小红");
            }
        },3000);



        entity.age.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                Log.d("123","age changed value ="+entity.age.get());
            }
        });

        observablePersonEntity.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                Log.d("123","propertyid->"+propertyId);
            }
        });
    }

    private Handler mHandler=new Handler();



}