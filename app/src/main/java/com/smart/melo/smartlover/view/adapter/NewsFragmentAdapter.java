package com.smart.melo.smartlover.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by melo on 2017/8/9.
 * news新闻碎片
 */
public class NewsFragmentAdapter extends FragmentPagerAdapter{
    private String[] titles;
    private List<Fragment> fragments;

    public NewsFragmentAdapter(String[] titles, List<Fragment> fragments ,FragmentManager fm) {
        super(fm);
        this.titles=titles;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return titles.length;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
