package com.smart.melo.smartlover.view.injector.module;

import com.smart.melo.smartlover.presenter.SocialPresenter;
import com.smart.melo.smartlover.view.impl.IBaseView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by melo on 2017/8/10.
 */
@Module
public class SocialFragmentModule {

    public IBaseView mIBaseView;

    public SocialFragmentModule(IBaseView mIBaseView) {
        this.mIBaseView = mIBaseView;
    }

    @Provides
    SocialPresenter provideSocialPresenter() {
        return new SocialPresenter(mIBaseView);
    }
}
