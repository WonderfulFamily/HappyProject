package com.happy.happyproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class SmithyViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> data;
    private String[] title={"独立设计","匠物精选"};
    public SmithyViewPagerAdapter(FragmentManager fm,List<Fragment> data) {
        super(fm);
        if (data!=null) {
            this.data = data;
        }

    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return title[position];
    }
}
