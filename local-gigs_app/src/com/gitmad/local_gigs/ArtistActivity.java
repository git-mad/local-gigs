package com.gitmad.local_gigs;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by thedekel on 10/27/13.
 */
public class ArtistActivity extends Activity implements View.OnClickListener{
    Button artist_search_button;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artists_layout);
        artist_search_button = (Button)findViewById(R.id.add_artist_button);
        artist_search_button.setOnClickListener(this);
    }

    public void onClick(View v){
        String name = ((EditText)findViewById(R.id.artist_name)).getText().toString();
        String info = ((EditText)findViewById(R.id.artist_info)).getText().toString();
        int age = Integer.parseInt(((EditText) findViewById(R.id.artist_age)).getText().toString());
        Artist artist = new Artist();
        artist.name = name;
        artist.info = info;
        artist.age = age;
        long success = new ArtistDatabaseHelper(v.getContext()).insertArtist(artist);
        Log.e("ArtistActivity", "" + success);

    }
}