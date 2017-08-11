package com.smart.melo.smartlover.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.smart.melo.smartlover.weight.ProgressWebView;

import butterknife.ButterKnife;

/**
 * Created by melo on 2017/6/15.
 */
public abstract class BaseWebViewActivity extends AppCompatActivity {
    private ProgressWebView webview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
        initData();

    }

    protected abstract void initView();

    protected abstract void initData();

    public abstract int getLayoutId();

    public void loadUrl(ProgressWebView mWebview,String url) {
        this.webview=mWebview;
        webview.loadUrl(url);
    }

    public void goBack() {
        if (webview.canGoBack()){
            webview.goBack();
        }else {
            finish();
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webview.canGoBack()) {
            webview.goBack();// 返回前一个页面
            return true;
        } else {
//            new AlertDialog.Builder(this).setMessage("确定退出？").setNegativeButton("no", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//
//                }
//            })
//                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            finish();
//                        }
//                    }).show();

            finish();
        }


        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
