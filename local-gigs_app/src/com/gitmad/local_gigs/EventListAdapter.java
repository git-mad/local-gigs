package com.gitmad.local_gigs;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * EventListAdapter is a class which creates a custom event adapter which will be 
 * used to display LocalEvents in a ListView
 * @author Andre Giron
 *
 */
public class EventListAdapter extends ArrayAdapter<LocalEvent> {
	  private final Context context;
	  private final LocalEvent[] values;

	  /**
	   * Constructor for EventListAdapter
	   * @param context The current Context of the application
	   * @param values The array of LocalEvents to use as the source of the ListView
	   */
	  public EventListAdapter(Context context, LocalEvent[] values) {
		  
		//need to define a layout for every item that we are going to be displaying in the list
	    //list_item_layout will contain the layout that we are going to be using for each cell in the list
	    super(context, R.layout.list_item_layout, values);
	    this.context = context;
	    this.values = values;
	  }
	  
	  //We will use this to create the custom list view.
	  //The Layout Inflater class takes every item in the ArrayList and makes the view appear
	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.list_item_layout, parent, false);
	    
	    //These two text views are part of the list_item_layout xml file
	    TextView titleTextView = (TextView) rowView.findViewById(R.id.title);
	    TextView startdateTextView = (TextView) rowView.findViewById(R.id.startdate);

	    titleTextView.setText(values[position].getTitle());
	    startdateTextView.setText(values[position].getStartDate());
	    
	    return rowView;
	  }

}
