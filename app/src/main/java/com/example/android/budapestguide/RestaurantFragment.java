/*
 * Created by Karolin Fornet.
 * Copyright (c) 2017.  All rights reserved.
 */

package com.example.android.budapestguide;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RestaurantFragment extends Fragment {

    public RestaurantFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);

        final ArrayList<Sight> sights = new ArrayList<>();
        sights.add(new Sight(R.string.restaurant_0, R.string.restaurant_type_0, R.string.restaurant_url_0));
        sights.add(new Sight(R.string.restaurant_1, R.string.restaurant_type_1, R.string.restaurant_url_1));
        sights.add(new Sight(R.string.restaurant_2, R.string.restaurant_type_2, R.string.restaurant_url_2));
        sights.add(new Sight(R.string.restaurant_3, R.string.restaurant_type_3, R.string.restaurant_url_3));
        sights.add(new Sight(R.string.restaurant_4, R.string.restaurant_type_4, R.string.restaurant_url_4));
        sights.add(new Sight(R.string.restaurant_5, R.string.restaurant_type_5, R.string.restaurant_url_5));
        sights.add(new Sight(R.string.restaurant_6, R.string.restaurant_type_6, R.string.restaurant_url_6));
        sights.add(new Sight(R.string.restaurant_7, R.string.restaurant_type_7, R.string.restaurant_url_7));
        sights.add(new Sight(R.string.restaurant_8, R.string.restaurant_type_8, R.string.restaurant_url_8));
        sights.add(new Sight(R.string.restaurant_9, R.string.restaurant_type_9, R.string.restaurant_url_9));
        sights.add(new Sight(R.string.restaurant_10, R.string.restaurant_type_10, R.string.restaurant_url_10));
        sights.add(new Sight(R.string.restaurant_11, R.string.restaurant_type_11, R.string.restaurant_url_11));
        sights.add(new Sight(R.string.restaurant_12, R.string.restaurant_type_12, R.string.restaurant_url_12));

        final SightAdapter adapter = new SightAdapter(getActivity(), sights, R.color.category_restaurant);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Sight currentSight = adapter.getItem(i);
                if (currentSight.hasUrl()) {
                    Uri sightUri = Uri.parse(getResources().getString(currentSight.getUrl()));
                    Intent websiteIntent = new Intent(Intent.ACTION_VIEW, sightUri);
                    startActivity(websiteIntent);
                } else {
                    Intent searchIntent = new Intent(Intent.ACTION_WEB_SEARCH);
                    searchIntent.putExtra(SearchManager.QUERY, getResources().getString(currentSight.getName()));
                    if (searchIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(searchIntent);
                    } else {
                        Toast.makeText(getContext(), R.string.google_search, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return rootView;
    }
}
