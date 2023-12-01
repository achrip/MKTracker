package com.achrip.mktracker;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class SwichListAdapter extends ArrayAdapter<Switches> {


    public SwichListAdapter(@NonNull Context context, ArrayList<Switches> switchesArrayList){
        super(context, R.layout.item_list_view, switchesArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Switches s = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_view,
                    parent, false);
        }

        ShapeableImageView switchImage = convertView.findViewById(R.id.image);
        TextView switchTitle = convertView.findViewById(R.id.title);
        TextView switchDesc = convertView.findViewById(R.id.descripion);

        switchTitle.setText(s.getBrandName() + s.getModelName());
        switchDesc.setText("Measure once, cut twice");

        return convertView;
    }
}
