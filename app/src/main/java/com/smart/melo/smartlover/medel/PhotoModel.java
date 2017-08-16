package com.smart.melo.smartlover.medel;

import android.util.Log;

import com.smart.melo.smartlover.bean.PhotoBean;
import com.smart.melo.smartlover.http.ApiCallBack;
import com.smart.melo.smartlover.http.RetrofitHelper;
import com.smart.melo.smartlover.http.UrlConfig;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by melo on 2017/8/15.
 */
public class PhotoModel {

    /**
     * 下载top数据，得到结果用过接口传递给P层
     * @param type   类型
     * @param amount  每次请求数量
     * @param page     页码
     * @param callBack
     */
    public void mPhotoMsg(String type ,String amount ,String page ,final ApiCallBack<PhotoBean> callBack) {
        Log.i( "PhotoFragment", type+amount+page);
        RetrofitHelper.getInstance().getService(UrlConfig.BASEURL_PHOTO).getPhotoData(type,amount,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PhotoBean>() {
                    @Override
                    public void onCompleted() {

                        callBack.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onError(e.getCause());
                    }

                    @Override
                    public void onNext(PhotoBean photoBean) {
                        if (photoBean != null) {
                            callBack.onNext(photoBean);
                        }
                    }
                });
    }
}
