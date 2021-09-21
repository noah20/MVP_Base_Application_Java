package com.foxcoders.mvpbaseapplication_java.data;


import com.foxcoders.mvpbaseapplication_java.data.db.dao.UserDao;
import com.foxcoders.mvpbaseapplication_java.data.network.RestApiHelper;
import com.foxcoders.mvpbaseapplication_java.data.prefs.PreferenceHelper;

public interface DataManager extends RestApiHelper, UserDao, PreferenceHelper {

}
