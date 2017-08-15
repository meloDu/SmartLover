package com.smart.melo.smartlover.view.injector.compontent;

import com.smart.melo.smartlover.view.fragment.PhotoFragment;
import com.smart.melo.smartlover.view.injector.module.PhotoFragmentModule;

import dagger.Component;

/**
 * Created by melo on 2017/8/10.
 */
@Component(modules = PhotoFragmentModule.class)
public interface PhotoFragmentComponent {
    void inject(PhotoFragment photoFragment);
}
