package com.example.ayan.mediaplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class MediaAdapter extends ArrayAdapter<Media> {

    String CONSTANTS = "android.resource://com.example.ayan.mediaplayer/";

    public MediaAdapter (Context context, ArrayList<Media> mediaArrayList){
        super(context,0,mediaArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
            R.layout.list, parent, false);
        }

        Media currentMedia = getItem(position);

        TextView name = listItemView.findViewById(R.id.name);
        name.setText(currentMedia.getmName());

        TextView description = listItemView.findViewById(R.id.desc);
        description.setText(currentMedia.getmDescription());

        ImageView imageView = listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentMedia.getmImg_id());

        ProgressBar progressBar = listItemView.findViewById(R.id.progress_horizontal);
        currentMedia.setProgressBar(progressBar);

        return listItemView;
    }
}
