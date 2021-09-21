package com.foxcoders.mvpbaseapplication_java.ui.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.foxcoders.mvpbaseapplication_java.di.component.ActivityComponent;
import com.foxcoders.mvpbaseapplication_java.di.component.DaggerActivityComponent;
import com.foxcoders.mvpbaseapplication_java.di.module.ActivityModule;
import com.foxcoders.mvpbaseapplication_java.root.MainApplication;
import com.foxcoders.mvpbaseapplication_java.utils.CommonUtils;
import com.foxcoders.mvpbaseapplication_java.utils.NetworkUtils;

public abstract class BaseActivity extends AppCompatActivity implements MvpView{

    protected static ProgressDialog mDialog;

    ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MainApplication) getApplication()).getApplicationComponent())
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    @Override
    public void showLoading() {
        hideLoading();
        mDialog = CommonUtils.showLoading(this);
    }

    @Override
    public void hideLoading() {
        if(mDialog != null && mDialog.isShowing()){
            mDialog.cancel();
        }
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(int stringResource) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onError(int message) {

    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(this);
    }

    @Override
    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if(view!=null){
            InputMethodManager inputMethod = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethod.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

    protected abstract void setUp();
}
