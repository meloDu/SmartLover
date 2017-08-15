package com.smart.melo.smartlover.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart.melo.smartlover.R;
import com.smart.melo.smartlover.utils.LogUtils;

/**
 * Created by melo on 2017/8/7.
 */
public class MineFragment extends Fragment {
    private static final String TAG = MineFragment.class.getSimpleName();


    public static MineFragment newInstance() {
        Bundle args = new Bundle();
        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        return view;
    }

    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.i(TAG, "onResume  ");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.i(TAG, "onPause  ");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        LogUtils.i(TAG, "isHidden  "+isHidden());
    }

    //    @Override
//    protected void lazyLoad() {
//        Log.i(TAG, "appear  isVisible:"+isVisible);
//    }
//
//    @Override
//    protected void disappear() {
//        Log.i(TAG, "disappear  isVisible:"+isVisible);
//    }
//
//
//    @Override
//    public int getLayoutId() {
//        return R.layout.fragment_mine;
//    }
//
//    @Override
//    protected void inject() {
//
//    }
//
//    @Override
//    protected void initData() {
//
//    }
//
//    @Override
//    protected void initView() {
//
//    }


}
