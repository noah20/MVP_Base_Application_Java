package com.foxcoders.mvpbaseapplication_java.ui.login;

import com.foxcoders.mvpbaseapplication_java.data.network.models.PostModel;
import com.foxcoders.mvpbaseapplication_java.ui.base.MvpView;

import java.util.List;

public interface LoginMvpView extends MvpView {

    void updatePosts(List<PostModel> data);

}
