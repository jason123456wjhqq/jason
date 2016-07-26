package com.example.wjh.duoduo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 建辉 on 2016/7/18.
 */
public class NewsFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;
    private List<String> shop_title;

    public NewsFragmentPagerAdapter(FragmentManager fm, List<Fragment> list, List<String> shop_title) {
        super(fm);
        this.list = list;
        this.shop_title = shop_title;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list!=null?list.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return shop_title.get(position);
    }


//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        //super.destroyItem(container, position, object);
//    }





}
