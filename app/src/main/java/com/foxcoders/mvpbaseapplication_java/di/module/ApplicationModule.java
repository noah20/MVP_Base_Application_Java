package com.foxcoders.mvpbaseapplication_java.di.module;


import android.app.Application;
import android.content.Context;

import com.foxcoders.mvpbaseapplication_java.data.BaseDataManager;
import com.foxcoders.mvpbaseapplication_java.data.DataManager;
import com.foxcoders.mvpbaseapplication_java.data.db.AppDataBase;
import com.foxcoders.mvpbaseapplication_java.data.network.NetworkApiService;
import com.foxcoders.mvpbaseapplication_java.data.network.RestApiHelper;
import com.foxcoders.mvpbaseapplication_java.data.network.RestApiManager;
import com.foxcoders.mvpbaseapplication_java.data.prefs.PreferenceHelper;
import com.foxcoders.mvpbaseapplication_java.data.prefs.PreferenceManager;
import com.foxcoders.mvpbaseapplication_java.di.ApplicationContext;
import com.foxcoders.mvpbaseapplication_java.utils.Utils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {
    Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @ApplicationContext
    @Provides
    Context provideContext(){
        return mApplication;
    }
    @Singleton
    @Provides
    RestApiHelper provideRestApiHelper(RestApiManager restApiManager){
        return restApiManager;
    }
    @Singleton
    @Provides
    OkHttpClient provideClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        client.addInterceptor(interceptor);
        return client.build();
    }


    @Provides
    Retrofit provideRetrofit(String baseURL, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
    @Provides
    NetworkApiService provideNetworkApiService() {
        return provideRetrofit(Utils.BASE_URL,provideClient()).create(NetworkApiService.class);
    }
    @Singleton
    @Provides
    DataManager provideDataManager(BaseDataManager baseDataManager){
        return  baseDataManager;
    }
    @Provides
    AppDataBase provideAppDataBase(){
        return AppDataBase.getDataBaseInstance(mApplication);
    }
    @Provides
    PreferenceHelper providePreferenceHelper(PreferenceManager preferenceManager){
        return preferenceManager;
    }
}
