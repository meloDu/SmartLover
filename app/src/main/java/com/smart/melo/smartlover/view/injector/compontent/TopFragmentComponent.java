package com.smart.melo.smartlover.view.injector.compontent;

import com.smart.melo.smartlover.view.fragment.TopFragment;
import com.smart.melo.smartlover.view.injector.module.TopFragmentModule;

import dagger.Component;

/**
 * Created by melo on 2017/8/10.
 */
@Component(modules = TopFragmentModule.class)
public interface TopFragmentComponent {
    void inject(TopFragment topFragment);
}
