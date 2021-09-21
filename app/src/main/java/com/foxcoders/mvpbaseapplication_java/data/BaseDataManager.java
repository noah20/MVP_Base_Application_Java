package com.foxcoders.mvpbaseapplication_java.data;

import android.content.Context;

import com.foxcoders.mvpbaseapplication_java.data.db.AppDataBase;
import com.foxcoders.mvpbaseapplication_java.data.db.models.User;
import com.foxcoders.mvpbaseapplication_java.data.network.RestApiHelper;
import com.foxcoders.mvpbaseapplication_java.data.network.models.PostModel;
import com.foxcoders.mvpbaseapplication_java.data.prefs.PreferenceHelper;
import com.foxcoders.mvpbaseapplication_java.di.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class BaseDataManager implements DataManager{

    Context mContext;
    RestApiHelper mRestApiHelper;
    AppDataBase mDataBase;
    PreferenceHelper mPreferenceHelper;

    @Inject
    public BaseDataManager(@ApplicationContext Context context, RestApiHelper restApiHelper,
                           AppDataBase dataBase, PreferenceHelper preferenceHelper) {
        mContext = context;
        mRestApiHelper = restApiHelper;
        mDataBase = dataBase;
        mPreferenceHelper = preferenceHelper;
    }

    @Override
    public Single<List<PostModel>> getPosts() {
        return mRestApiHelper.getPosts();
    }


    @Override
    public void insertUser(User user) {
        mDataBase.getDao().insertUser(user);
    }

    @Override
    public void deleteUser(User user) {
        mDataBase.getDao().deleteUser(user);
    }

    @Override
    public void updateUser(User user) {
        mDataBase.getDao().updateUser(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = mDataBase.getDao().getAllUser();
        if(users==null)
            users = new ArrayList<>();
        return users;
    }

    @Override
    public User getUser(int id) {
        return mDataBase.getDao().getUser(id);
    }

    @Override
    public void putString(String key, String value) {

    }

    @Override
    public void putInt(String key, int value) {

    }

    @Override
    public void putDouble(String key, double value) {

    }

    @Override
    public void putLong(String key, long value) {

    }

    @Override
    public void putBoolean(String key, boolean value) {

    }

    @Override
    public String getString(String key) {
        return null;
    }

    @Override
    public int getInt(String key) {
        return 0;
    }

    @Override
    public double getDouble(String key) {
        return 0;
    }

    @Override
    public long getLong(String key) {
        return 0;
    }

    @Override
    public boolean getBoolean(String key) {
        return false;
    }
}
