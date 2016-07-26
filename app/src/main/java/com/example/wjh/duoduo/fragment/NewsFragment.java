package com.example.wjh.duoduo.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wjh.duoduo.R;
import com.example.wjh.duoduo.adapter.NewsFragmentPagerAdapter;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class NewsFragment extends Fragment {


    @ViewInject(R.id.news_viewpager)
    private ViewPager news_viewpager;
    @ViewInject(R.id.tab_layout)
    private TabLayout tab_layout;
    public NewsFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_news, container, false);
        ViewUtils.inject(this,view);

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

        news_fragment.add(new HeadLineFragment());
        news_fragment.add(new AnimeFragment());
        news_fragment.add(new JOKEFragment());
        news_fragment.add(new PictureFragment());

        NewsFragmentPagerAdapter newsFragmentPagerAdapter = new NewsFragmentPagerAdapter(getActivity().getSupportFragmentManager(), news_fragment, news_title);
        news_viewpager.setAdapter(newsFragmentPagerAdapter);
        //预加载
//        shop_viewPager.setOffscreenPageLimit(4);
//        news_viewpager.setCurrentItem(2);


//        和viewpager进行关联
        tab_layout.setupWithViewPager(news_viewpager);
        tab_layout.setTabMode(TabLayout.MODE_FIXED);

    }


}
