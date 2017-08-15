package com.smart.melo.smartlover.view.injector.module;

import com.smart.melo.smartlover.presenter.PhotoPresenter;
import com.smart.melo.smartlover.view.impl.IBaseView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by melo on 2017/8/7.
 */
@Module
public class PhotoFragmentModule {

    public IBaseView mIBaseView;

    public PhotoFragmentModule(IBaseView mIBaseView) {
        this.mIBaseView = mIBaseView;
    }


    @Provides
    PhotoPresenter providePhotoPresenter() {
        return new PhotoPresenter(mIBaseView);
    }
}
