package com.foxcoders.mvpbaseapplication_java.data.network;

import com.foxcoders.mvpbaseapplication_java.data.network.models.PostModel;

import java.util.List;

import io.reactivex.Single;


public interface RestApiHelper {

    Single<List<PostModel>> getPosts();

}
