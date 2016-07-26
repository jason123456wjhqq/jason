package com.example.wjh.duoduo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wjh.duoduo.MyApp.MyApp;
import com.example.wjh.duoduo.R;
import com.example.wjh.duoduo.adapter.NewsListViewAdapter;
import com.example.wjh.duoduo.bean.News;
import com.example.wjh.duoduo.contants.Contants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.lang.reflect.Type;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HeadLineFragment extends Fragment {



    private List<News> filterList;
    public HeadLineFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_head_line, container, false);

        initData();


        NewsListViewAdapter newslistviewadapter =new NewsListViewAdapter(filterList,getActivity());
        return view;

    }
    private void initData() {
        MyApp.getHttpUtils().send(HttpRequest.HttpMethod.GET, Contants.URL_HEADLINE, new RequestCallBack<Object>() {
            @Override
            public void onSuccess(ResponseInfo<Object> responseInfo) {
                Gson gson = new Gson();//创建Gson对象
                Type listtype2 = new TypeToken<List<News>>() {}.getType();//这里使用了一个匿名类

                filterList = gson.fromJson(responseInfo.result.toString(), listtype2);

            }

            @Override
            public void onFailure(HttpException error, String msg) {

            }
        });


    }


}
