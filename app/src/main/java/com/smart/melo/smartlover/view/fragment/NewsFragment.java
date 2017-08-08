package com.smart.melo.smartlover.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.smart.melo.smartlover.R;
import com.smart.melo.smartlover.base.BaseFragment;
import com.smart.melo.smartlover.bean.VideoBean;
import com.smart.melo.smartlover.presenter.NewsPresenter;
import com.smart.melo.smartlover.utils.LogUtils;
import com.smart.melo.smartlover.view.compontent.DaggerNewsFragmentComponent;
import com.smart.melo.smartlover.view.impl.INewsView;
import com.smart.melo.smartlover.view.module.NewsFragmentModule;

import javax.inject.Inject;

/**
 * Created by melo on 2017/8/7.
 * 新闻碎片
 */
public class NewsFragment extends BaseFragment {
    private static final String TAG = NewsFragment.class.getSimpleName();
    @Inject
    NewsPresenter mNewsPresenter;


    public static Fragment newInstance() {
        Bundle args = new Bundle();
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void lazyLoad() {

    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initData() {

        mNewsPresenter.pNewsMsg();
    }

    @Override
    protected void initView() {
        DaggerNewsFragmentComponent.builder()
                .newsFragmentModule(new NewsFragmentModule(mINewsView))
                .build()
                .inject(this);
    }


    private INewsView mINewsView = new INewsView() {
        @Override
        public void OnMsgSuccess(Object o) {
            VideoBean videoBean = (VideoBean) o;
            LogUtils.i(TAG, videoBean.getTitle());
        }

        @Override
        public void onFail(String msg) {

        }
    };

}
