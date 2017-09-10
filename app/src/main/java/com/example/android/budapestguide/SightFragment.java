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

import java.util.ArrayList;

public class SightFragment extends Fragment {

    public SightFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words_list, container, false);

        final ArrayList<Sight> sights = new ArrayList<Sight>();
        sights.add(new Sight(R.string.sight_0, R.string.sight_english_0, R.string.sight_type_0, R.string.sight_url_0, R.drawable.sight_0));
        sights.add(new Sight(R.string.sight_1, R.string.sight_english_1, R.string.sight_type_1, R.string.sight_url_1, R.drawable.sight_1));
        sights.add(new Sight(R.string.sight_2, R.string.sight_english_2, R.string.sight_type_2, R.string.sight_url_2, R.drawable.sight_2));
        sights.add(new Sight(R.string.sight_3, R.string.sight_english_3, R.string.sight_type_3, -1, R.drawable.sight_3));
        sights.add(new Sight(R.string.sight_4, R.string.sight_english_4, R.string.sight_type_4, -1, R.drawable.sight_4));
        sights.add(new Sight(R.string.sight_5, R.string.sight_english_5, R.string.sight_type_5, -1, R.drawable.sight_5));
        sights.add(new Sight(R.string.sight_6, R.string.sight_english_6, R.string.sight_type_6, -1, R.drawable.sight_6));
        sights.add(new Sight(R.string.sight_7, R.string.sight_english_7, R.string.sight_type_7, R.string.sight_url_7, R.drawable.sight_7));
        sights.add(new Sight(R.string.sight_8, R.string.sight_english_8, R.string.sight_type_8, -1, R.drawable.sight_8));
        sights.add(new Sight(R.string.sight_9, R.string.sight_english_9, R.string.sight_type_9, -1, R.drawable.sight_9));
        sights.add(new Sight(R.string.sight_10, R.string.sight_english_10, R.string.sight_type_10, -1, R.drawable.sight_10));
        sights.add(new Sight(R.string.sight_11, R.string.sight_english_11, R.string.sight_type_11, -1, R.drawable.sight_11));
        sights.add(new Sight(R.string.sight_12, R.string.sight_english_12, R.string.sight_type_12, -1, R.drawable.sight_12));
        sights.add(new Sight(R.string.sight_13, R.string.sight_english_13, R.string.sight_type_13, -1, R.drawable.sight_13));
        sights.add(new Sight(R.string.sight_14, R.string.sight_english_14, R.string.sight_type_14, R.string.sight_url_14, R.drawable.sight_14));
        sights.add(new Sight(R.string.sight_15, R.string.sight_english_15, R.string.sight_type_15, R.string.sight_url_15, R.drawable.sight_15));
        sights.add(new Sight(R.string.sight_16, R.string.sight_english_16, R.string.sight_type_16, R.string.sight_url_16, R.drawable.sight_16));
        sights.add(new Sight(R.string.sight_17, R.string.sight_english_17, R.string.sight_type_17, R.string.sight_url_17, R.drawable.sight_17));
        sights.add(new Sight(R.string.sight_18, R.string.sight_english_18, R.string.sight_type_18, R.string.sight_url_18, R.drawable.sight_18));
        sights.add(new Sight(R.string.sight_19, R.string.sight_english_19, R.string.sight_type_19, -1, R.drawable.sight_19));

        final SightAdapter adapter = new SightAdapter(getActivity(), sights, R.color.category_sight);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

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
                    startActivity(searchIntent);
                }
            }
        });

        return rootView;
    }

}
