package com.foxcoders.mvpbaseapplication_java.di.component;

import com.foxcoders.mvpbaseapplication_java.di.PerActivity;
import com.foxcoders.mvpbaseapplication_java.di.module.ActivityModule;
import com.foxcoders.mvpbaseapplication_java.ui.base.BaseActivity;
import com.foxcoders.mvpbaseapplication_java.ui.login.LoginActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(LoginActivity loginActivity);
}
