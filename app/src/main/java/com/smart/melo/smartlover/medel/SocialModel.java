package com.smart.melo.smartlover.medel;

import com.smart.melo.smartlover.bean.SocialBean;
import com.smart.melo.smartlover.http.ApiCallBack;
import com.smart.melo.smartlover.http.RetrofitHelper;
import com.smart.melo.smartlover.http.UrlConfig;

import java.util.HashMap;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by melo on 2017/8/14.
 */
public class SocialModel {
    //下载top数据，得到结果用过接口传递给P层
    public void mSocialMsg(String pageIdx ,final ApiCallBack<SocialBean> callBack) {

        HashMap<String, String> map = new HashMap<>();
        map.put(UrlConfig.RequestKey.TYPE, UrlConfig.DefaultVAULE.SOCIAL);
        map.put(UrlConfig.RequestKey.KEY,  UrlConfig.DefaultVAULE.KEY_VAULE);

        RetrofitHelper.getInstance().getService(UrlConfig.BASEURL_NEWS).getSocialData(UrlConfig.TOP,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SocialBean>() {
                    @Override
                    public void onCompleted() {

                        callBack.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onError(e.getCause());
                    }

                    @Override
                    public void onNext(SocialBean socialBean) {
                        if (socialBean != null) {
                            callBack.onNext(socialBean);
                        }
                    }
                });
    }
}
