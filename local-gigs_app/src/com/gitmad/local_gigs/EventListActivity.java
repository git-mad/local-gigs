package com.gitmad.local_gigs;

import android.app.ListActivity;
import android.os.Bundle;

/**
 * EventListActivity is a ListActivity which will display a list of LocalEvents.
 * @author Andre Giron
 *
 */
public class EventListActivity extends ListActivity {
	  public void onCreate(Bundle icicle) {
	    super.onCreate(icicle);

	    //Create the list of events here
	    //We will use this list of events and pass it into a custom array adapter
	    //The custom array adapter will allow us to show the events in the list view that we created
	    LocalEvent[] eventList = new LocalEvent[3];
	    eventList[0] = (new LocalEvent("GIT MAD Meeting 5", "This meeting will be the best meeting yet! We will go over list views and how to use basic UI elements in Android.", "5/30/13", "5/30/13"));
	    eventList[1] = (new LocalEvent("Music Midtown", "Come listen to a bunch of different awesome concerts", "5/25/13", "5/27/13"));
	    eventList[2] = (new LocalEvent("Mobile Buzz Hackathon", "Come create an app that is somthing that Midtown can really use", "5/25/13", "5/27/13"));
	    
	    //This is all that we need to do with the new custom adapter that we created
	    EventListAdapter adapter = new EventListAdapter(this, eventList);
	    setListAdapter(adapter);
	    
	    //Here is an example of how to use the base ArrayAdapter class:
	    //It will just display one item TextViews. android.R.layout.simple_list_item_1 is a view that is available throughout all of android
	    //Takes in an array of Strings, which we will create below
	    /*
	     * 	String[] values = new String[] { "Music Midtown", "Mobile Buzz Hackathon", "RHOK",
	        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
	        "Linux", "OS/2" };
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	        android.R.layout.simple_list_item_1, values);
	    setListAdapter(adapter);
	    */
	  }
	} 