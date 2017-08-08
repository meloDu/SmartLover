package com.smart.melo.smartlover.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by duyanfeng on 2017/8/4.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null == savedInstanceState) {
            setContentView(getLayoutId());
            ButterKnife.bind(this);
            initView();
            initData();
        }

    }



    protected abstract void initView();
    protected abstract void initData();

    protected abstract int getLayoutId();



    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        onDestroyed();
    }

    protected abstract void onDestroyed();
}
