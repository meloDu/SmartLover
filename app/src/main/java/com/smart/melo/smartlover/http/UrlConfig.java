package com.smart.melo.smartlover.http;

/**
 * Created by melo on 2017/3/6.
 */
public class UrlConfig {


    //BaseUrl
    public static final String BASEURL_NEWS = "http://v.juhe.cn/toutiao/";
    public static final String VIDEO = "/kkuser/listinfo/list/appclassid/609/timestamp/";
    //头条
    public static final String TOP = "index";

    //图片欣赏
    public static final String BASEURL_PHOTO = "http://gank.io/api/data/";


    public static class RequestColumn {
        public static final String TYPE = "福利";
        public static final String AMOUNT = "10";
        public static final String PAGE = "1";
    }

    public static class RequestKey {
        public static final String TYPE = "type";
        public static final String KEY = "key";
    }

    public static class DefaultVAULE {
        public static final String TOP = "top";
        public static final String SOCIAL = "shehui";
        public static final String KEY_VAULE = "723060051cc0b5baa348a8024b1bb7e1";
    }
}
