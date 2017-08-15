package com.smart.melo.smartlover.view.injector.compontent;

import com.smart.melo.smartlover.view.fragment.SocialFragment;
import com.smart.melo.smartlover.view.injector.module.SocialFragmentModule;

import dagger.Component;

/**
 * Created by melo on 2017/8/10.
 */
@Component(modules = SocialFragmentModule.class)
public interface SocialFragmentComponent {
    void inject(SocialFragment socialFragment);
}
