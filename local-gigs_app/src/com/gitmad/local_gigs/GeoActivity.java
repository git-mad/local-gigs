package com.gitmad.local_gigs;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 10/6/13
 * Time: 2:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class GeoActivity extends Activity implements LocationListener {

    private LocationManager locationManager;
    private String provider;
    private TextView latView, longView;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geo_activity);

        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        Location location = locationManager.getLastKnownLocation(provider);

        latView = (TextView)findViewById(R.id.latView);
        longView = (TextView)findViewById(R.id.longView);

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
    public void onProviderEnabled(String provider) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onProviderDisabled(String provider) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}