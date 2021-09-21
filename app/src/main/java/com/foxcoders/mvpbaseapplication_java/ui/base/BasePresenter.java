package com.foxcoders.mvpbaseapplication_java.ui.base;

import com.foxcoders.mvpbaseapplication_java.data.DataManager;
import com.foxcoders.mvpbaseapplication_java.utils.NetworkUtils;
import com.foxcoders.mvpbaseapplication_java.utils.rx.ScheduleProvider;
import com.google.gson.JsonSyntaxException;

import javax.inject.Inject;
import javax.net.ssl.HttpsURLConnection;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.HttpException;

public class BasePresenter <V extends MvpView> implements MvpPresenter <V>{

    private static final int API_STATUS_CODE_LOCAL_ERROR = 0;
    private final ScheduleProvider mScheduleProvider;
    private final CompositeDisposable mCompositeDisposable;
    private final DataManager mDataManager;
    private V mMvpView;

    @Inject
    public BasePresenter(ScheduleProvider scheduleProvider, CompositeDisposable compositeDisposable, DataManager dataManager) {
        mScheduleProvider = scheduleProvider;
        mCompositeDisposable = compositeDisposable;
        mDataManager = dataManager;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {

    }

    @Override
    public void handleApiError(Throwable error) {
        if (error instanceof HttpException) {
            switch (((HttpException) error).code()) {
                case HttpsURLConnection.HTTP_UNAUTHORIZED:
                    mMvpView.onError("Unauthorised UserProfile ");
                    break;
                case HttpsURLConnection.HTTP_FORBIDDEN:
                    mMvpView.onError("Forbidden");
                    break;
                case HttpsURLConnection.HTTP_INTERNAL_ERROR:
                    mMvpView.onError("Internal Server Error");
                    break;
                case HttpsURLConnection.HTTP_BAD_REQUEST:
                    mMvpView.onError("Bad Request");
                    break;
                case API_STATUS_CODE_LOCAL_ERROR:
                    mMvpView.onError("No Internet Connection");
                    break;
                default:
                    mMvpView.onError(error.getLocalizedMessage());
            }
        } else if (error instanceof JsonSyntaxException) {
            mMvpView.onError("Something Went Wrong API is not responding properly!");
        } else {
            mMvpView.onError(error.getMessage());
        }
    }



    public V getMvpView() {
        return mMvpView;
    }

    public ScheduleProvider getScheduleProvider() {
        return mScheduleProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }
}
