package com.foxcoders.mvpbaseapplication_java.ui.base;

public interface MvpPresenter < V extends MvpView> {

    void onAttach(V mvpView);
    void onDetach();
    void handleApiError(Throwable err);
}
