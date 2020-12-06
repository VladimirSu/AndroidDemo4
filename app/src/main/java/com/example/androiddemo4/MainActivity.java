package com.example.androiddemo4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Adapter;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    List<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tabLayout = findViewById(R.id.tab_layout);
        this.viewPager = findViewById(R.id.view_pager);

        fragments = new ArrayList<>();

        fragments.add(new BlankFragment());

        viewPager.setAdapter(new TableLayoutAdapter(getSupportFragmentManager(),fragments));

        tabLayout.setupWithViewPager(viewPager);
    }
}