package com.smart.melo.smartlover.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.smart.melo.smartlover.base.BaseFragment;

/**
 * Created by melo on 2017/8/11.
 * 图片浏览
 */
public class PhotoFragment  extends BaseFragment {


    public static Fragment newInstance() {
        Bundle args = new Bundle();
        PhotoFragment fragment = new PhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected void lazyLoad() {

    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    protected void inject() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }
}
