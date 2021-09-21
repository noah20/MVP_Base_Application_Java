package com.foxcoders.mvpbaseapplication_java.data.network;

import com.foxcoders.mvpbaseapplication_java.data.network.models.PostModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class RestApiManager implements RestApiHelper{

    NetworkApiService mService;

    @Inject
    public RestApiManager(NetworkApiService service) {
        mService = service;
    }

    @Override
    public Single<List<PostModel>> getPosts() {
        return mService.getPosts();
    }

}
