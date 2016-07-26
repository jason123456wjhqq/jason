package com.example.wjh.duoduo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.example.wjh.duoduo.fragment.BookFragment;
import com.example.wjh.duoduo.fragment.HomeFragment;
import com.example.wjh.duoduo.fragment.ManagerFragment;
import com.example.wjh.duoduo.fragment.NewsFragment;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnRadioGroupCheckedChange;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {



    private List<Fragment> list;
    private FragmentManager fragmentmanager;
    private Fragment currentFragment;

    @ViewInject(R.id.main_activity_radiogroup)
    private RadioGroup main_activity_radiogroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewUtils.inject(this);
        initfragment();
    }


    @OnRadioGroupCheckedChange(R.id.main_activity_radiogroup)
    public void radioGroupClick(RadioGroup group, int checkedId) {


        switch (checkedId) {
            case R.id.main_home_radiobutton:
                switchFragment(currentFragment, list.get(0));
                break;
            case R.id.main_book_radiobutton:
                switchFragment(currentFragment, list.get(1));
                break;
            case R.id.main_news_radiobutton:
                switchFragment(currentFragment,list.get(2));
                break;
            case R.id.main_manager_radiobutton:
                switchFragment(currentFragment,list.get(3));
                break;
        }

//



    }


    private void initfragment() {
        list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new BookFragment());
        list.add(new ManagerFragment());
        list.add(new NewsFragment());


        currentFragment = list.get(0);
        fragmentmanager = getSupportFragmentManager();
        fragmentmanager.beginTransaction().add(R.id.main_fragmentlaout, new HomeFragment()).commit();
    }



    public void switchFragment(Fragment from, Fragment to) {
        if (from == to) {
            return;
        }
        if (from == null || to == null)
            return;
        if (!to.isAdded()) {
            getSupportFragmentManager().beginTransaction().hide(from).add(R.id.main_fragmentlaout, to).commit();

        } else {
            getSupportFragmentManager().beginTransaction().hide(from).show(to).commit();
        }
        currentFragment = to;
    }


}
