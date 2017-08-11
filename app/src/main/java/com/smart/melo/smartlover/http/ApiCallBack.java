package com.smart.melo.smartlover.http;

/**
 * Created by melo on 2017/8/8.
 * 定义rx数据下载后的接口，用于传递到p层
 */
public interface ApiCallBack<T> {

    void onCompleted();

    void onError(Throwable e);

    void onNext(T t);
}
