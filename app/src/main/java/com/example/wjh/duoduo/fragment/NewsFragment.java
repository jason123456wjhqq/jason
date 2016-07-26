package com.example.wjh.duoduo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wjh.duoduo.R;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class NewsFragment extends Fragment {


    public NewsFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_news, container, false);

        initData();
        return view;

    }

    private void initData() {
        List<Fragment> news_fragment = new ArrayList<>();
        List<String> news_title = new ArrayList<>();
        news_title.add("头条");
        news_title.add("动漫");
        news_title.add("图片");
        news_title.add("段子");

     //   news_fragment.add(new );
    }


}
