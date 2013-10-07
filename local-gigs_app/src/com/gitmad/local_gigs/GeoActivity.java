package com.gitmad.local_gigs;

import android.app.Activity;
import android.content.Context;
import android.location.*;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 10/6/13
 * Time: 2:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class GeoActivity extends Activity implements LocationListener, View.OnClickListener {

    private LocationManager locationManager;
    private String provider;
    private TextView latView, longView;
    private ListView listView;
    private Button button;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geo_activity);

        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        Location location = locationManager.getLastKnownLocation(provider);

        latView = (TextView)findViewById(R.id.latView);
        longView = (TextView)findViewById(R.id.longView);

        listView = (ListView)findViewById(R.id.listView);

        button = (Button)findViewById(R.id.geocode_button);
        button.setOnClickListener(this);

        if(location!=null)
        {
            latView.setText(location.getLatitude()+"");
            longView.setText(location.getLongitude()+"");
        }


    }
    public void onResume()
    {
        super.onResume();
        locationManager.requestLocationUpdates(provider, 400, 1, this);
    }
    public void onPause()
    {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {

        if(location!=null)
        {
            latView.setText(location.getLatitude()+"");
            longView.setText(location.getLongitude()+"");
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onProviderEnabled(String provider)
    {
        Toast toast = Toast.makeText(this, provider, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onProviderDisabled(String provider) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onClick(View v)
    {
        GeocodeTask task = new GeocodeTask();
        double latitude = Double.parseDouble(latView.getText().toString());
        double longitude = Double.parseDouble(longView.getText().toString());
        task.execute(latitude,longitude);
    }

    private class GeocodeTask extends AsyncTask<Double, String, List<Address>>
    {

        @Override
        protected List<Address> doInBackground(Double... params)
        {
            Geocoder coder = new Geocoder(GeoActivity.this);
            List<Address> addresses = new ArrayList<Address>();
            try
            {
                addresses = coder.getFromLocation(params[0], params[1],10);

            }
            catch(IOException ioex)
            {}
            return addresses;

        }
        protected void onPostExecute(List<Address> results)
        {
            Address[] resultsarr = new Address[10];
            results.toArray(resultsarr);
            ArrayAdapter<Address> adapter = new ArrayAdapter<Address>(GeoActivity.this, android.R.layout.simple_list_item_1, resultsarr);
            listView.setAdapter(adapter);


        }

    }
}