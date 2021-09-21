package com.foxcoders.mvpbaseapplication_java.ui.login;

import com.foxcoders.mvpbaseapplication_java.data.DataManager;
import com.foxcoders.mvpbaseapplication_java.data.network.models.PostModel;
import com.foxcoders.mvpbaseapplication_java.ui.base.BasePresenter;
import com.foxcoders.mvpbaseapplication_java.utils.rx.ScheduleProvider;

import java.util.List;

import javax.inject.Inject;
import io.reactivex.disposables.CompositeDisposable;

public class LoginPresenter <V extends LoginMvpView> extends BasePresenter<V> implements LoginMvpPresenter<V> {

    @Inject
    public LoginPresenter(ScheduleProvider scheduleProvider, CompositeDisposable compositeDisposable, DataManager dataManager) {
        super(scheduleProvider, compositeDisposable, dataManager);
    }

    @Override
    public void getPosts() {
        getMvpView().showLoading();
        getCompositeDisposable()
                .add(getDataManager().getPosts()
                .subscribeOn(getScheduleProvider().io())
                .observeOn(getScheduleProvider().ui())
                .subscribe(response ->{
                    getMvpView().hideLoading();
                    getMvpView().updatePosts(response);
                }, error ->{
                    getMvpView().hideLoading();
                    getMvpView().onError(error.getMessage());
                }));
    }

}
