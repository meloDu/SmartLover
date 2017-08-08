package com.smart.melo.smartlover.view.module;

import com.smart.melo.smartlover.presenter.NewsPresenter;
import com.smart.melo.smartlover.view.impl.INewsView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by duyanfeng on 2017/8/7.
 */
@Module
public class NewsFragmentModule {

    public INewsView mINewsView;

    public NewsFragmentModule(INewsView mINewsView) {
        this.mINewsView = mINewsView;
    }

    @Provides
    INewsView provideINewsView() {
        return mINewsView;
    }

    @Provides
    NewsPresenter provideNewsPresenter() {
        return new NewsPresenter(mINewsView);
    }
}
