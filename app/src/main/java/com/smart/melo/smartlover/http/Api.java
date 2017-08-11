package com.smart.melo.smartlover.http;

import com.smart.melo.smartlover.bean.TopBean;
import com.smart.melo.smartlover.bean.VideoBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by melo on 2017/3/6.
 * 定义数据接口
 */
public interface Api {
    @GET(UrlConfig.VIDEO)
    Observable<VideoBean> getVideoData();

    @POST("{path}?")
    Observable<TopBean> getTopData(@Path("path") String path, @QueryMap() Map<String, String> map);

}
