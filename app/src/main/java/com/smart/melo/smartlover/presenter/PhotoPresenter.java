package com.smart.melo.smartlover.presenter;

import android.util.Log;

import com.smart.melo.smartlover.bean.PhotoBean;
import com.smart.melo.smartlover.http.ApiCallBack;
import com.smart.melo.smartlover.medel.PhotoModel;
import com.smart.melo.smartlover.view.impl.IBaseView;

/**
 * Created by melo on 2017/8/15.
 */
public class PhotoPresenter {
    private static final String TAG = PhotoPresenter.class.getSimpleName();
    private PhotoModel mPhotoModel;
    private IBaseView iBaseView;


    public PhotoPresenter(IBaseView iBaseView) {
        this.iBaseView = iBaseView;
        mPhotoModel = new PhotoModel();
    }

    public void pPhotoMsg(String type ,String amount ,String page ) {
        //调用业务逻辑  下载新闻
        mPhotoModel.mPhotoMsg(type ,amount ,page ,new ApiCallBack<PhotoBean>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(PhotoBean photoBean) {
                //由P层传递给v层
                iBaseView.OnMsgSuccess(photoBean);
                Log.i(TAG, "onNext下载成功~");
            }
        });

    }
}
