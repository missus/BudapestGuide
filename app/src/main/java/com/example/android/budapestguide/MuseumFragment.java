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

public class MuseumFragment extends Fragment {


    public MuseumFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);

        final ArrayList<Sight> sights = new ArrayList<>();
        sights.add(new Sight(R.string.museum_0, R.string.museum_english_0, R.string.museum_type_0, R.string.museum_url_0, R.drawable.museum_0));
        sights.add(new Sight(R.string.museum_1, R.string.museum_english_1, R.string.museum_type_1, R.string.museum_url_1, R.drawable.museum_1));
        sights.add(new Sight(R.string.museum_2, R.string.museum_english_2, R.string.museum_type_2, R.string.museum_url_2, R.drawable.museum_2));
        sights.add(new Sight(R.string.museum_3, R.string.museum_english_3, R.string.museum_type_3, R.string.museum_url_3, R.drawable.museum_3));

        final SightAdapter adapter = new SightAdapter(getActivity(), sights, R.color.category_museum);

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
