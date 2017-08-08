package com.smart.melo.smartlover.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.RadioGroup;

import com.smart.melo.smartlover.R;
import com.smart.melo.smartlover.base.BaseActivity;
import com.smart.melo.smartlover.utils.BottomTabManager;
import com.smart.melo.smartlover.view.fragment.NewsFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements BottomTabManager.OnBottomTabSelectListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    //默认选中的页面下标
    public static final int CHECK_HOME_INDEX = 0;
    @Bind(R.id.radiogroup_bottom)
    RadioGroup mRadiogroupBottom;

    @Override
    protected void initView() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(NewsFragment.newInstance());
        fragments.add(NewsFragment.newInstance());
        fragments.add(NewsFragment.newInstance());
        fragments.add(NewsFragment.newInstance());
        new BottomTabManager(fragments, mRadiogroupBottom, getSupportFragmentManager(),
                R.id.layout_content
                , this);


    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onDestroyed() {

    }

    @Override
    public void onBottomTabSelectListener(RadioGroup group, int checkedId, int index) {
        switch (index) {
            case CHECK_HOME_INDEX:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
