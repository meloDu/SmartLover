package com.smart.melo.smartlover.medel;

import com.smart.melo.smartlover.bean.VideoBean;
import com.smart.melo.smartlover.http.ApiCallBack;
import com.smart.melo.smartlover.http.RetrofitHelper;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by melo on 2017/8/7.
 * 处理news碎片的业务
 */
public class NewsModel {
    //下载news数据，得到结果用过接口传递给P层
    public void mNewsMsg(final ApiCallBack<VideoBean> callBack){
        RetrofitHelper.getInstance().getService().getVideoData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<VideoBean>() {
                    @Override
                    public void onCompleted() {

                        callBack.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onError(e.getCause());
                    }

                    @Override
                    public void onNext(VideoBean videoBean) {
                        if (videoBean != null) {
                            callBack.onNext(videoBean);
                        }
                    }
                });
    }
}
