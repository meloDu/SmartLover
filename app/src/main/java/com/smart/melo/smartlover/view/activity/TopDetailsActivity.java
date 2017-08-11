package com.smart.melo.smartlover.view.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.smart.melo.smartlover.R;
import com.smart.melo.smartlover.base.BaseWebViewActivity;
import com.smart.melo.smartlover.weight.ProgressWebView;

import butterknife.Bind;

/**
 * Created by melo on 2017/8/11.
 */
public class TopDetailsActivity extends BaseWebViewActivity {
    private static final String TAG = TopDetailsActivity.class.getSimpleName();
    @Bind(R.id.iv_goback)
    ImageView mIvGoback;
    @Bind(R.id.webview)
    ProgressWebView mWebview;


    @Override
    protected void initView() {
        mIvGoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });
    }

    @Override
    protected void initData() {
        String url = getIntent().getStringExtra("detailsUrl");
        if (!TextUtils.isEmpty(url)) {
            loadUrl(mWebview, url);
        }

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_topdetails;
    }

}
