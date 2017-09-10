package com.example.android.budapestguide;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class SightAdapter extends ArrayAdapter<Sight> {

    private int Color;

    public SightAdapter(Activity context, ArrayList<Sight> sights, int color) {
        super(context, 0, sights);
        Color = color;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Sight currentSight = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);
        nameTextView.setText(currentSight.getName());
        nameTextView.setTextColor(ContextCompat.getColor(getContext(), Color));

        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english_name);
        if (currentSight.hasEnglishName()) {
            englishTextView.setText(currentSight.getEnglishName());
            englishTextView.setVisibility(View.VISIBLE);
        } else {
            englishTextView.setVisibility(View.GONE);
        }

        TextView typeTextView = (TextView) listItemView.findViewById(R.id.type);
        typeTextView.setText(currentSight.getType());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentSight.hasImage()) {
            iconView.setImageResource(currentSight.getImageId());
            iconView.setVisibility(View.VISIBLE);
        } else {
            iconView.setVisibility(View.GONE);
        }
        return listItemView;
    }
}
