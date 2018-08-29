/*
 * Created by Karolin Fornet.
 * Copyright (c) 2017.  All rights reserved.
 */

package com.example.android.budapestguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.viewpager);

        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_program);
        tabLayout.getTabAt(0).setContentDescription(R.string.category_program);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_sight);
        tabLayout.getTabAt(1).setContentDescription(R.string.category_sight);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_museum);
        tabLayout.getTabAt(2).setContentDescription(R.string.category_museum);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_nature);
        tabLayout.getTabAt(3).setContentDescription(R.string.category_nature);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_restaurant);
        tabLayout.getTabAt(4).setContentDescription(R.string.category_restaurant);
    }
}