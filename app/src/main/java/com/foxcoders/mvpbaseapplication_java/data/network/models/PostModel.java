package com.foxcoders.mvpbaseapplication_java.data.network.models;

import com.google.gson.annotations.SerializedName;

public class PostModel {
    @SerializedName(value = "userId")
    long mUserId;
    @SerializedName("id")
    long mPostId;
    @SerializedName("title")
    String mTitle;
    @SerializedName("body")
    String mPostBody;

    public long getUserId() {
        return mUserId;
    }

    public void setUserId(long userId) {
        mUserId = userId;
    }

    public long getPostId() {
        return mPostId;
    }

    public void setPostId(long postId) {
        mPostId = postId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getPostBody() {
        return mPostBody;
    }

    public void setPostBody(String postBody) {
        mPostBody = postBody;
    }
}
