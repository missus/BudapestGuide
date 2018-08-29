/*
 * Created by Karolin Fornet.
 * Copyright (c) 2017.  All rights reserved.
 */

package com.example.android.budapestguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ProgramFragment();
            case 1:
                return new SightFragment();
            case 2:
                return new MuseumFragment();
            case 3:
                return new NatureFragment();
            case 4:
                return new RestaurantFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}