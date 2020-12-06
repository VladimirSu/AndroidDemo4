package com.example.androiddemo4;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class TableLayoutAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments;
    String[] title = {"推荐"};
    public TableLayoutAdapter(@NonNull FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.fragments = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }
}
