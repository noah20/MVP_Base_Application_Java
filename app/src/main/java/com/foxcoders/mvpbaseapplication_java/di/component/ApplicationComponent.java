package com.foxcoders.mvpbaseapplication_java.di.component;


import android.content.Context;

import com.foxcoders.mvpbaseapplication_java.data.DataManager;
import com.foxcoders.mvpbaseapplication_java.di.ApplicationContext;
import com.foxcoders.mvpbaseapplication_java.di.module.ApplicationModule;
import com.foxcoders.mvpbaseapplication_java.root.MainApplication;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainApplication mainApplication);

    @ApplicationContext
    Context context();

    DataManager getDataManager();

}
