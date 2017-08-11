package com.smart.melo.smartlover.presenter;

import android.util.Log;

import com.smart.melo.smartlover.bean.VideoBean;
import com.smart.melo.smartlover.http.ApiCallBack;
import com.smart.melo.smartlover.medel.NewsModel;
import com.smart.melo.smartlover.view.impl.INewsView;

/**
 * Created by melo on 2017/8/7.
 * news的p层
 */
public class NewsPresenter {
    private static final String TAG = NewsPresenter.class.getSimpleName();
    private NewsModel mNewsModel;
    private INewsView mINewsView;

    public NewsPresenter(INewsView mINewsView) {
        this.mINewsView = mINewsView;
        mNewsModel = new NewsModel();
    }

    public void pNewsMsg() {
        //调用业务逻辑  下载新闻
        mNewsModel.mNewsMsg(new ApiCallBack<VideoBean>() {
            @Override
            public void onCompleted() {
                Log.i("tag", "onCompleted下载成功~");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(VideoBean videoBean) {
                //由P层传递给v层
                mINewsView.OnMsgSuccess(videoBean);
                Log.i("tag", "onNext下载成功~");
            }
        });

    }
}
