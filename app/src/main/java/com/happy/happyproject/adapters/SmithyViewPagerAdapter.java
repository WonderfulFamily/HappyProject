package com.happy.happyproject.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class SmithyViewPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = SmithyViewPagerAdapter.class.getSimpleName();
    private List<Fragment> data;
    private List<String> title;
    public SmithyViewPagerAdapter(FragmentManager fm,List<Fragment> data,List<String> title) {
        super(fm);
        if (data!=null) {
            this.data = data;
        }
        if (title!=null)
            this.title = title;
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
        Log.e(TAG, "getPageTitle: " +title.get(position));
        return title.get(position);
    }
}
