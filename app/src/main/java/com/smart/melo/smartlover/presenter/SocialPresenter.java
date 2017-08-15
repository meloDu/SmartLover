package com.smart.melo.smartlover.presenter;

import android.util.Log;

import com.smart.melo.smartlover.bean.SocialBean;
import com.smart.melo.smartlover.http.ApiCallBack;
import com.smart.melo.smartlover.medel.SocialModel;
import com.smart.melo.smartlover.view.impl.IBaseView;

/**
 * Created by melo on 2017/8/10.
 */
public class SocialPresenter {
    private static final String TAG = SocialPresenter.class.getSimpleName();
    private SocialModel mSocialModel;
    private IBaseView iBaseView;


    public SocialPresenter(IBaseView iBaseView) {
        this.iBaseView = iBaseView;
        mSocialModel = new SocialModel();
    }

    public void pSocialMsg(String pageIdx) {
        //调用业务逻辑  下载新闻
        mSocialModel.mSocialMsg(pageIdx,new ApiCallBack<SocialBean>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(SocialBean socialBean) {
                //由P层传递给v层
                iBaseView.OnMsgSuccess(socialBean);
                Log.i(TAG, "onNext下载成功~");
            }
        });

    }
}
