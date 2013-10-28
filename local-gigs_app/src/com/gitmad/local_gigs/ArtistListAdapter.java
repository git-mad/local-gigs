package com.gitmad.local_gigs;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thedekel on 10/28/13.
 */
public class ArtistListAdapter extends CursorAdapter {
    private ArtistDatabaseHelper.ArtistCursor mArtistCursor;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public ArtistListAdapter(Context context, ArtistDatabaseHelper.ArtistCursor cursor) {
        super(context, cursor, 0);
        mArtistCursor = cursor;
    }



    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_layout, parent, false);


        return rowView;

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        Artist artist = mArtistCursor.getArtist();

        TextView titleTextView = (TextView) view.findViewById(R.id.title);
        TextView message = (TextView) view.findViewById(R.id.startdate);
        titleTextView.setText(artist.name);
        message.setText(artist.info);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Log.d("ArtistListAdapter", "code for interacting with specific artist goes here");
            }
        });

    }
}
