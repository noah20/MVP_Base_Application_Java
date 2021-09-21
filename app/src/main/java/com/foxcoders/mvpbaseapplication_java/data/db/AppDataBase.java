package com.foxcoders.mvpbaseapplication_java.data.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.foxcoders.mvpbaseapplication_java.data.db.dao.UserDao;
import com.foxcoders.mvpbaseapplication_java.data.db.models.User;

@Database(entities = User.class,version = 1,exportSchema = true)
public abstract class AppDataBase extends RoomDatabase {
    private static final String DB_NAME = "user.db";
    public static AppDataBase mInstance;

    public synchronized static  AppDataBase getDataBaseInstance(Context context){
        if(mInstance != null){
            return mInstance;
        }else {
            mInstance = Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
            return mInstance;
        }
    }
    static void destroyDataBase(){
        mInstance = null;
    }
    public abstract UserDao getDao();
}
