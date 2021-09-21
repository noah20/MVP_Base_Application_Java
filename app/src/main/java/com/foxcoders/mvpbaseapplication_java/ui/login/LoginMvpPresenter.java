package com.foxcoders.mvpbaseapplication_java.ui.login;


import com.foxcoders.mvpbaseapplication_java.ui.base.MvpPresenter;

public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {
    void getPosts();
}
