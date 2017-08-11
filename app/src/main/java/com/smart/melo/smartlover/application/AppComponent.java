package com.smart.melo.smartlover.application;

import com.smart.melo.smartlover.http.ApiModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by melo on 2017/8/7.
 */
@Singleton
@Component(modules = {ApiModule.class,AppModule.class})
public interface AppComponent {
    //暴露出OkHttpClient Retrofit MyApp 对象，以便其他地方可以注入
    OkHttpClient getClient();

    Retrofit getRetrofit();

    MyApp getContext();
}
