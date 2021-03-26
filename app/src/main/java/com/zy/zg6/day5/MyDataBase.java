package com.zy.zg6.day5;

import com.zy.zg6.day5.dao.UserDao;
import com.zy.zg6.day5.entity.UserEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * @author:zhangyue
 * @date:2021/3/26
 */
@Database(entities = {UserEntity.class},version = 1)
public abstract class MyDataBase extends RoomDatabase {
    public abstract UserDao getUserDao();
}
