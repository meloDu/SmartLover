package com.smart.melo.smartlover.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smart.melo.smartlover.R;
import com.smart.melo.smartlover.weight.CustomDialog;

import butterknife.ButterKnife;

/**
 * Created by melo on 2017/3/6.
 */
public abstract class BaseFragment extends Fragment {
    private static final String TAG = "BaseFragment";
    /**
     * Fragment当前状态是否可见
     * setUserVisibleHint  adapter中的每个fragment切换的时候都会被调用，
     * 如果是切换到当前页，那么isVisibleToUser==true，否则为false
     */
    protected boolean isVisible;

    public static final String FRAGMENT_OUT_STATE = "outState";

    private CustomDialog dialog;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean(FRAGMENT_OUT_STATE)) {
                getFragmentManager().beginTransaction().show(this).commit();
            } else {
                getFragmentManager().beginTransaction().hide(this).commit();
            }
        }
        inject();
        initDiaLog();
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }


    /**
     * 可见
     */
    protected void onVisible() {
        lazyLoad();
    }

    /**
     * 不可见
     */
    protected void onInvisible() {
        disappear();
    }

    /**
     * 延迟加载	 * 子类必须重写此方法
     */
    protected abstract void lazyLoad();

    /**
     * 当前fragment
     */
    protected abstract void disappear();
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(FRAGMENT_OUT_STATE, isVisible());
    }


    public abstract int getLayoutId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }



    public final void init() {

        initView();
        initData();
    }

    protected abstract void inject();

    protected abstract void initData();

    protected abstract void initView();

    //初始化dialog
    protected void initDiaLog() {
        //初始化diaplg
        dialog = new CustomDialog(getActivity(), 100, 100, R.layout.dialog_loding, R.style.Theme_dialog, Gravity.CENTER, R.style.pop_anim_style);
        //设置加载中不许取消
//        dialog.setCancelable(false);
    }
    //显示dialog
    protected void showDiaLog() {
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }
    //关闭dialog
    protected void dismissDiaLog() {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
    @Override
    public void onDestroy() {

        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
