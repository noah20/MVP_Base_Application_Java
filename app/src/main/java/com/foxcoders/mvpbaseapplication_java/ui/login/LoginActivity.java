package com.foxcoders.mvpbaseapplication_java.ui.login;

import android.os.Bundle;

import com.foxcoders.mvpbaseapplication_java.data.network.models.PostModel;
import com.foxcoders.mvpbaseapplication_java.databinding.ActivityLoginBinding;
import com.foxcoders.mvpbaseapplication_java.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginMvpView {

    @Inject
    LoginMvpPresenter<LoginMvpView> mPresenter;
    @Inject
    PostAdapter mPostAdapter;
    ActivityLoginBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        getActivityComponent()
                .inject(this);
        mPresenter.onAttach(this);
        setUp();
    }

    @Override
    protected void setUp() {
        mBinding.rvPosts.setAdapter(mPostAdapter);
        mPresenter.getPosts();
    }

    @Override
    public void updatePosts(List<PostModel> data) {
        mPostAdapter.setPostModels(data);
    }
}