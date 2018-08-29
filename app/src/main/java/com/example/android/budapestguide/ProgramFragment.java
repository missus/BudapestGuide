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

public class ProgramFragment extends Fragment {

    public ProgramFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);

        final ArrayList<Sight> sights = new ArrayList<>();
        sights.add(new Sight(R.string.program_0, R.string.program_english_0, R.string.program_type_0, R.string.program_url_0));
        sights.add(new Sight(R.string.program_1, R.string.program_english_1, R.string.program_type_1, R.string.program_url_1));
        sights.add(new Sight(R.string.program_2, R.string.program_english_2, R.string.program_type_2, R.string.program_url_2));
        sights.add(new Sight(R.string.program_3, R.string.program_english_3, R.string.program_type_3, R.string.program_url_3));
        sights.add(new Sight(R.string.program_4, R.string.program_english_4, R.string.program_type_4, -1));
        sights.add(new Sight(R.string.program_5, R.string.program_english_5, R.string.program_type_5, R.string.program_url_5));
        sights.add(new Sight(R.string.program_6, R.string.program_english_6, R.string.program_type_6, R.string.program_url_6));
        sights.add(new Sight(R.string.program_7, R.string.program_english_7, R.string.program_type_7, R.string.program_url_7));
        sights.add(new Sight(R.string.program_8, R.string.program_english_8, R.string.program_type_8, R.string.program_url_8));
        sights.add(new Sight(R.string.program_9, R.string.program_english_9, R.string.program_type_9, R.string.program_url_9));

        final SightAdapter adapter = new SightAdapter(getActivity(), sights, R.color.category_program);
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
