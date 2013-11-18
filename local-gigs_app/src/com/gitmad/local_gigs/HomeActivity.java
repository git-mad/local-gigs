package com.gitmad.local_gigs;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends Activity implements View.OnClickListener{

    Button artists_button;
    Button artistSearchButton;
    Button geoButton;
    Button netButton;
    Button cameraButton;
    Button notificationsButton;

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

        cameraButton = (Button)findViewById(R.id.camera_button);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), CameraActivity.class);
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

        //2
        netButton = (Button) findViewById(R.id.net_button);
        netButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NetActivity.class);
                startActivity(i);
            }
        });
        //2
        
        notificationsButton = (Button)findViewById(R.id.notifications_button);

        notificationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	launchNotification(v);
            } 
        });

	}
	
	public void launchNotification(View view)
	{

       Intent intent = new Intent(view.getContext(), NotificationReceiverActivity.class);
       PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

       long[] vibrate_pattern = new long[]{1000};
       
       // Construct the notification
       //we can add up to three actions here, but right now they don't do anything.
       Notification noti = new Notification.Builder(this)
           .setContentTitle("Thanks for using LocalGigs!")
           .setContentText("Subject").setSmallIcon(R.drawable.gitmad_logo)
           .setStyle(new Notification.BigTextStyle().bigText("This is an example of how you can have a longer string of " +
           		"text in your notifications, so that you can add extra detail for your users!" +
           		" Please add more artists"))
           .setContentIntent(pIntent)
           .setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 }) //example of how we can add things like vibration
           .addAction(R.drawable.gitmad_logo, "Call", pIntent)
           .addAction(R.drawable.gitmad_logo, "More", pIntent)
           .addAction(R.drawable.gitmad_logo, "And more", pIntent).build();
       NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
       // hide the notification after its selected
       noti.flags |= Notification.FLAG_AUTO_CANCEL;

       notificationManager.notify(0, noti);
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
