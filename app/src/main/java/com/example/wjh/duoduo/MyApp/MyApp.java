package com.example.wjh.duoduo.MyApp;

import android.app.Application;

import com.lidroid.xutils.HttpUtils;

/**
 * Created by 建辉 on 2016/7/26.
 */
public class MyApp extends Application {

    private static  HttpUtils  httpUtils;
    @Override
    public void onCreate() {
        super.onCreate();
        httpUtils = new HttpUtils();

    }
    public static HttpUtils getHttpUtils(){

        return httpUtils;
    }


}
