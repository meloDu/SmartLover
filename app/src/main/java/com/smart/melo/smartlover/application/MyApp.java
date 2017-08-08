package com.smart.melo.smartlover.application;

import android.app.Application;

import com.smart.melo.smartlover.http.ApiModule;
import com.smart.melo.smartlover.http.UrlConfig;

/**
 * Created by duyanfeng on 2017/8/4.
 */
public class MyApp extends Application {
    AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        //一次性初始化
        mAppComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule(UrlConfig.BASE_URL))
                .appModule(new AppModule(this))
                .build();
    }
    //提供拿到mAppComponent的方法
    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
