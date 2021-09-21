package com.foxcoders.mvpbaseapplication_java.data.db.dao;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.foxcoders.mvpbaseapplication_java.data.db.models.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertUser(User user);
    @Delete
    void deleteUser(User user);
    @Update
    void updateUser(User user);
    @Query("SELECT * FROM users")
    List<User> getAllUser();
    @Query("SELECT * FROM users WHERE id = :id ")
    User getUser(int id);
}


