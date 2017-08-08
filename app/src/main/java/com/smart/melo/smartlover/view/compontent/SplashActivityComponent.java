package com.smart.melo.smartlover.view.compontent;

import com.smart.melo.smartlover.application.AppComponent;
import com.smart.melo.smartlover.view.activity.SplashActivity;

import dagger.Component;

/**
 * Created by duyanfeng on 2017/8/8.
 */
//此处的ActivityScope  如果不加，编译会出异常
@ActivityScope
@Component(dependencies = AppComponent.class)
public interface SplashActivityComponent {
    void inject(SplashActivity activity);
}
