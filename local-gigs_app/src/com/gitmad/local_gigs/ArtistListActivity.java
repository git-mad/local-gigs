package com.gitmad.local_gigs;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by thedekel on 10/28/13.
 */
public class ArtistListActivity extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArtistDatabaseHelper.ArtistCursor ac =
                new ArtistDatabaseHelper(getApplicationContext()).queryArtists();
        ArtistListAdapter adapter = new ArtistListAdapter(this, ac);
        setListAdapter(adapter);
    }
}