package com.gitmad.local_gigs;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends Activity implements View.OnClickListener{

    Button artists_button;
    Button artistSearchButton;
    Button geoButton;
    Button netButton;
    EditText textBox;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_activity);

        artists_button = (Button)findViewById(R.id.artists_button);
        artists_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ArtistListActivity.class);
                startActivity(i);
            }
        });

        artistSearchButton = (Button)findViewById(R.id.artist_search_button);
        //Create another OnClickListener for the local events button.
        //here is another way to go about making the on click listener:
        artistSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ArtistActivity.class);
                startActivity(i);
            }
        });

        geoButton = (Button)findViewById(R.id.geo_button);

        geoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), GeoActivity.class);
                startActivity(i);
            }
        });
        netButton = (Button)findViewById(R.id.net_button);

        netButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NetActivity.class);
                startActivity(i);
            }
        });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello_world, menu);
		return true;
	}

    @Override
    public void onClick(View v)
    {
        //get text from text box, start activity
        String text = "hammers";
        Intent i = new Intent(this, TextActivity.class);
        i.putExtra("My Text", text);
        startActivity(i);

    }
}
