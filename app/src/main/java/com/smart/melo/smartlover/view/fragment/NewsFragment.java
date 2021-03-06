package com.smart.melo.smartlover.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;

import com.smart.melo.smartlover.R;
import com.smart.melo.smartlover.base.BaseFragment;
import com.smart.melo.smartlover.bean.VideoBean;
import com.smart.melo.smartlover.utils.LogUtils;
import com.smart.melo.smartlover.view.adapter.NewsFragmentAdapter;
import com.smart.melo.smartlover.view.impl.INewsView;
import com.smart.melo.smartlover.view.injector.compontent.DaggerNewsFragmentComponent;
import com.smart.melo.smartlover.view.injector.module.NewsFragmentModule;
import com.smart.melo.smartlover.weight.DepthPageTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by melo on 2017/8/7.
 * mainactivity新闻碎片
 */
public class NewsFragment extends BaseFragment {
    private static final String TAG = NewsFragment.class.getSimpleName();
    @Bind(R.id.tablayout_fragment_news)
    TabLayout mTablayout;
    @Bind(R.id.news_multiply)
    ImageView mNewsMultiply;
    @Bind(R.id.viewpager_fragment_news)
    ViewPager mViewpager;


    public static NewsFragment newInstance() {
        Bundle args = new Bundle();
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void lazyLoad() {
        Log.i(TAG, "appear  isVisible:"+isVisible);
    }

    @Override
    protected void disappear() {
        Log.i(TAG, "disappear  isVisible:"+isVisible);
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void inject() {
        DaggerNewsFragmentComponent.builder()
                .newsFragmentModule(new NewsFragmentModule(mINewsView))
                .build()
                .inject(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {


        initViewPager();
        String[] titles = getResources().getStringArray(R.array.hot_titles);
        NewsFragmentAdapter adapter = new NewsFragmentAdapter(titles, fragments, getFragmentManager());
        mViewpager.setAdapter(adapter);
        //关闭预加载，默认一次只加载一个Fragment
        mViewpager.setOffscreenPageLimit(1);
        //设置viewpager内两两间距
        mViewpager.setPageMargin(5);
        //设置viewpager滑动动画效果
        mViewpager.setPageTransformer(true, new DepthPageTransformer());
        //反射修改viewpager切换时间.
//        try {
//            Field field = ViewPager.class.getDeclaredField("mScroller");
//            field.setAccessible(true);
//            FixedSpeedScroller scroller = new FixedSpeedScroller(mViewpager.getContext(),
//                    new AccelerateInterpolator());
//            field.set(mViewpager, scroller);
//            scroller.setmDuration(500);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        // 设置viewpager和tablayout联动
        mViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTablayout));
        mTablayout.setupWithViewPager(mViewpager);
    }


    private List<Fragment> fragments;

    /**
     * 初始化  获取fragments数据源  然后进行适配
     */
    private void initViewPager() {
        fragments = new ArrayList<>();
        fragments.add(TopFragment.newInstance());
        fragments.add(SocialFragment.newInstance());
        fragments.add(SocialFragment.newInstance());
        fragments.add(SocialFragment.newInstance());
        fragments.add(SocialFragment.newInstance());
        fragments.add(SocialFragment.newInstance());
        fragments.add(SocialFragment.newInstance());
        fragments.add(SocialFragment.newInstance());
        fragments.add(SocialFragment.newInstance());
        fragments.add(SocialFragment.newInstance());


    }

    //
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
