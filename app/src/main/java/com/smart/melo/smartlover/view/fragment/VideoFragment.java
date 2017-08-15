package com.smart.melo.smartlover.view.fragment;

import android.os.Bundle;
import android.util.Log;

import com.smart.melo.smartlover.R;
import com.smart.melo.smartlover.base.BaseFragment;

/**
 * Created by melo on 2017/8/7.
 *
 */
public class VideoFragment extends BaseFragment {
    private static final String TAG = VideoFragment.class.getSimpleName();



    public static VideoFragment newInstance() {
        Bundle args = new Bundle();
        VideoFragment fragment = new VideoFragment();
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
        return R.layout.fragment_video;
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
