package com.smart.melo.smartlover.view.compontent;

import com.smart.melo.smartlover.view.fragment.NewsFragment;
import com.smart.melo.smartlover.view.module.NewsFragmentModule;

import dagger.Component;

/**
 * Created by duyanfeng on 2017/8/7.
 */

@Component(modules = NewsFragmentModule.class)
public interface NewsFragmentComponent {
    NewsFragment inject(NewsFragment newsFragment);
}
