package com.smart.melo.smartlover.view.activity;

import android.text.TextUtils;

import com.smart.melo.smartlover.R;
import com.smart.melo.smartlover.base.BaseWebViewActivity;

/**
 * Created by duyanfeng on 2017/8/11.
 */
public class TopDetailsActivity extends BaseWebViewActivity {
    private static final String TAG = TopDetailsActivity.class.getSimpleName();


    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        String url = getIntent().getStringExtra("detailsUrl");
        if (!TextUtils.isEmpty(url)) {
            loadUrl(url);
        }

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_topdetails;
    }

}
