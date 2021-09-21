package com.foxcoders.mvpbaseapplication_java.root;

import android.app.Application;

import com.foxcoders.mvpbaseapplication_java.di.component.ApplicationComponent;
import com.foxcoders.mvpbaseapplication_java.di.component.DaggerApplicationComponent;
import com.foxcoders.mvpbaseapplication_java.di.module.ApplicationModule;

public class MainApplication extends Application {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule( new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);

    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
