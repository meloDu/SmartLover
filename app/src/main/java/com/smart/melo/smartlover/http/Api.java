package com.smart.melo.smartlover.http;

import com.smart.melo.smartlover.bean.VideoBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by melo on 2017/3/6.
 * 定义数据接口
 */
public interface Api {
    //    @GET(UrlConfig.VIDEO)
//    Call<VideoBean> getVideoData();
    @GET(UrlConfig.VIDEO)
    Observable<VideoBean> getVideoData();

//    @POST("{path}?")
//    Call<HotBean> getHotData(@Path("path") String path, @QueryMap() Map<String, String> map);
}
