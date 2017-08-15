package com.smart.melo.smartlover.application;

import android.app.Application;
import android.content.Context;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.smart.melo.smartlover.R;
import com.smart.melo.smartlover.http.ApiModule;
import com.smart.melo.smartlover.http.UrlConfig;
import com.smart.melo.smartlover.view.injector.AppComponent;
import com.smart.melo.smartlover.view.injector.AppModule;
import com.smart.melo.smartlover.view.injector.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by melo on 2017/8/4.
 */
public class MyApp extends Application {
    AppComponent mAppComponent;

    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.red, android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate);//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                layout.setPrimaryColorsId(R.color.red, android.R.color.white);//全局设置主题颜色
                return new ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Translate);
            }
        });
    }


    @Override
    public void onCreate() {
        super.onCreate();
        //一次性初始化
        mAppComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule(UrlConfig.BASEURL_NEWS))
                .appModule(new AppModule(this))
                .build();
        //内存泄漏检测
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);


    }

    //提供拿到mAppComponent的方法
    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
