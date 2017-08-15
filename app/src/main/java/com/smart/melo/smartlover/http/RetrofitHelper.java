package com.smart.melo.smartlover.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by melo on 2017/3/6.
 * 定义retrofit类
 */
public class RetrofitHelper {
    private static volatile RetrofitHelper instance = null;

    private RetrofitHelper() {

    }

    public static RetrofitHelper getInstance() {
        if (instance == null) {
            synchronized (RetrofitHelper.class) {
                if (instance == null) {
                    instance = new RetrofitHelper();
                }
            }
        }
        return instance;
    }


    public OkHttpClient createHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(10 * 1000, TimeUnit.MILLISECONDS)
                .build();
        return client;
    }

    public Retrofit createRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(createHttpClient())
                //gson解析要加
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                //rxjava 需要添加
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public Api getService(String baseUrl) {
        Retrofit retrofit = createRetrofit(baseUrl);
        Api apiService = retrofit.create(Api.class);
        return apiService;
    }



    /**
     * @return
     */
    public Gson createGson() {
        return new GsonBuilder()
                .serializeNulls()
                .enableComplexMapKeySerialization()
//                .setDateFormat("")
                .create();
    }
}
