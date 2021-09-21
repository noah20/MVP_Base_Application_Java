package com.foxcoders.mvpbaseapplication_java.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.foxcoders.mvpbaseapplication_java.ui.login.LoginMvpPresenter;
import com.foxcoders.mvpbaseapplication_java.ui.login.LoginMvpView;
import com.foxcoders.mvpbaseapplication_java.ui.login.LoginPresenter;
import com.foxcoders.mvpbaseapplication_java.ui.login.PostAdapter;
import com.foxcoders.mvpbaseapplication_java.utils.rx.AppScheduleProvider;
import com.foxcoders.mvpbaseapplication_java.utils.rx.ScheduleProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
@Module
public class ActivityModule {
    AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        mActivity = activity;
    }
    @Provides
    AppCompatActivity provideActivity(){
        return mActivity;
    }
    @Provides
    Context provideContext(){
        return mActivity;
    }
    @Provides
    CompositeDisposable provideCompositeDisposable(){
        return new CompositeDisposable();
    }

    @Provides
    ScheduleProvider provideSchedule(){
        return new AppScheduleProvider();
    }

    @Provides
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(LoginPresenter<LoginMvpView> presenter){

        return presenter;
    }

    @Provides
    PostAdapter providePostAdapter(){
        return new PostAdapter();
    }
}
