package com.dipakkr.github.bharathacks.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.dipakkr.github.bharathacks.R;
import com.dipakkr.github.bharathacks.activity.Emergency;

/**
 * Created by deepak on 6/17/17.
 */

public class EmergencyFragment extends Fragment implements View.OnClickListener, LocationListener{

    View rootview;
    Button upButton;

    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    TextView txtLat;
    Location location;
    CheckBox checkBox;

    String provider;
    protected String latitude, longitude;
    protected boolean gps_enabled, network_enabled;
    double lat,lon;
    Button ambu;

    public EmergencyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

        location = locationManager.getLastKnownLocation(locationManager.NETWORK_PROVIDER);
        lat = location.getLatitude();
        lon = location.getLongitude();

        latitude = String.valueOf(lat);
        longitude = String.valueOf(lon);
        Log.d("latitude location ---> ",latitude);
        Log.d("longitudelocation ---> ",longitude);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.frag_emergency, container, false);
        upButton = (Button) rootview.findViewById(R.id.ambulance);
        checkBox = (CheckBox) rootview.findViewById(R.id.hide);
        upButton.setOnClickListener(this);
        ambu = (Button) rootview.findViewById(R.id.ambulance);




        return rootview;
    }


    @Override
    public void onClick(View view) {
        Intent i = new Intent(getContext(),Emergency.class);
        i.putExtra("Latitude",latitude);
        i.putExtra("Longitude",longitude);
        startActivity(i);
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

        Log.d("Latitude","status");
    }

    @Override
    public void onProviderEnabled(String s) {
        Log.d("Latitude","enable");
    }

    @Override
    public void onProviderDisabled(String s) {
        Log.d("Latitude","disable");
    }



}
