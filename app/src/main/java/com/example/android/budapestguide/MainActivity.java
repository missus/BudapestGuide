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

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_program);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_sight);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_museum);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_nature);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_restaurant);

    }

}