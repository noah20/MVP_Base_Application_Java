package com.foxcoders.mvpbaseapplication_java.data.prefs;

import javax.inject.Inject;

public class PreferenceManager implements PreferenceHelper{

    @Inject
    public PreferenceManager() {
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
