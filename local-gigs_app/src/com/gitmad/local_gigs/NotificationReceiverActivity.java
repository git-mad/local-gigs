package com.gitmad.local_gigs;

import android.app.Activity;
import android.os.Bundle;

public class NotificationReceiverActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
	//This activity is launched after the user touches the notification.
    super.onCreate(savedInstanceState);
    setContentView(R.layout.artists_layout);
  }
} 