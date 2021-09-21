package com.foxcoders.mvpbaseapplication_java.data.prefs;

public interface PreferenceHelper {

    void putString(String key,String value);
    void putInt(String key,int value);
    void putDouble(String key,double value);
    void putLong(String key,long value);
    void putBoolean(String key,boolean value);
    String getString(String key);
    int getInt(String key);
    double getDouble(String key);
    long getLong(String key);
    boolean getBoolean(String key);


}
