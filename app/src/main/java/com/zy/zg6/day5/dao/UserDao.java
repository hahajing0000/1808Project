package com.zy.zg6.day5.dao;

import com.zy.zg6.day5.entity.UserEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * @author:zhangyue
 * @date:2021/3/26
 */
@Dao
public interface UserDao {
    @Query("SELECT * FROM tb_user")
    List<UserEntity> findAll();

    @Query("SELECT * FROM TB_USER WHERE UID=:uid")
    UserEntity findById(int uid);

    @Insert
    void addUser(UserEntity... entities);
}
