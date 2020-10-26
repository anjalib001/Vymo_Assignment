package com.vymo.vymoassignment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class LogsPager  extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    public LogsPager(@NonNull FragmentManager fm, ArrayList<Fragment> fragments)
    {
        super(fm);
        mFragments=fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
