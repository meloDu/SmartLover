package com.smart.melo.smartlover.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.smart.melo.smartlover.R;
import com.smart.melo.smartlover.view.injector.AppComponent;
import com.smart.melo.smartlover.application.Config;
import com.smart.melo.smartlover.application.MyApp;
import com.smart.melo.smartlover.base.BaseActivity;
import com.smart.melo.smartlover.utils.SPUtils;
import com.smart.melo.smartlover.view.injector.compontent.DaggerSplashActivityComponent;

import javax.inject.Inject;

/**
 * Created by melo on 2017/8/4.
 * 闪屏
 * 1.设置延时
 * 2.判断程序是否是第一次运行
 * 3.定义activity显示主题 在xml中设置
 */
public class SplashActivity extends BaseActivity {
    @Inject
    MyApp mMyApp;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Config.HANDLER_SPLASH:
                    //判断程序是否是第一次运行
                    if (isFirst()) {
                        //跳转到广告页
                        startActivity(new Intent(SplashActivity.this, GuideActivity.class));
                    } else {
                        //跳转到主页
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    }
                    finish();
                    break;
            }
        }
    };


    @Override
    protected void initData() {
        //1.设置延时2秒
        mHandler.sendEmptyMessageDelayed(Config.HANDLER_SPLASH, 2000);
    }

    @Override
    protected void initView() {
        AppComponent appComponent = ((MyApp) getApplication()).getAppComponent();
        DaggerSplashActivityComponent.builder()
                .appComponent(appComponent)
                .build().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }


    @Override
    protected void onDestroyed() {
        mHandler.removeCallbacksAndMessages(null);
    }


    //2.判断程序是否第一次运行
    private boolean isFirst() {
        boolean isFirst = (boolean) SPUtils.get(mMyApp, Config.SHARE_IS_FIRST, true);
        if (isFirst) {
            SPUtils.put(mMyApp, Config.SHARE_IS_FIRST, false);
            return true;
        } else {
            return false;
        }
    }

}
