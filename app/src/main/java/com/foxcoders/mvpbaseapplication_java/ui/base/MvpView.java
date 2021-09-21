package com.foxcoders.mvpbaseapplication_java.ui.base;

public interface MvpView {

    void showLoading();

    void hideLoading();

    void showMessage(String message);

    void showMessage(int stringResource);

    void onError(String message);

    void onError(int message);

    boolean isNetworkConnected();
    void hideKeyboard();
}
