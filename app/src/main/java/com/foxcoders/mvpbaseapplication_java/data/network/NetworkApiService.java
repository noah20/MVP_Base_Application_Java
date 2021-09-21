package com.foxcoders.mvpbaseapplication_java.data.network;

import com.foxcoders.mvpbaseapplication_java.data.network.models.PostModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface NetworkApiService {


    @GET("posts")
    Single<List<PostModel>> getPosts();

}
