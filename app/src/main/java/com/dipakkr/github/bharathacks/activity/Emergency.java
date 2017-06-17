package com.dipakkr.github.bharathacks.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.dipakkr.github.bharathacks.R;
import com.dipakkr.github.bharathacks.Utils.JsonParsing;

import org.json.JSONArray;
import org.json.JSONObject;

public class Emergency extends AppCompatActivity {
    String lat,lon;
    String name,address;
    String latitude,longitude;
    TextView na,add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        lat = getIntent().getStringExtra("Latitude");
        lon = getIntent().getStringExtra("Longitude");

        na = (TextView) findViewById(R.id.name);
        add = (TextView) findViewById(R.id.address);

        Log.d("lat------->",lat);
        Log.d("lon------>",lon);

        new Location_asynk().execute();

    }

    private class Location_asynk extends AsyncTask<String,String,JSONObject> {

        @Override
        protected JSONObject doInBackground(String... strings) {

            String url="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+lat+","+lon+"&rankby=distance&type=private&keyword=ambulance&key=AIzaSyAZjTINw8fOMSsw5oEaM9X4_sMKztd_S8I";
            Log.d("URL",""+url);

            JSONObject json=  JsonParsing.getJSONfromURL(url);
            Log.d("JSON",""+json);
            return json;

        }

        protected void onPostExecute(JSONObject jsonObj) {
            try {

                JSONArray jsonArray = jsonObj.getJSONArray("results");
                Log.d("jsonarray", ">" + jsonArray);
                int length=jsonArray.length();
                Log.d("length",""+length);


                JSONObject json=jsonArray.getJSONObject(0);
                String geometry=json.getString("geometry");
                Log.d("description", ">" + geometry);


                JSONObject json2=json.getJSONObject("geometry");
                Log.i("geometry",""+json2);
                int l=json2.length();
                Log.d("len",""+l);
                JSONObject json3 = json2.getJSONObject("location");
                latitude =json3.getString("lat");
                Log.d("latitude-->",""+latitude);

                longitude=json3.getString("lng");
                Log.d("longitude-->",""+longitude);

                name  = json.getString("name");
                Log.d("name-->",""+name);

                address  = json.getString("vicinity");
                Log.d("address-->",""+address);

                na.setText(name);
                add.setText(address);


            }catch (Exception e){
                e.printStackTrace();
            }
            super.onPostExecute(jsonObj);
        }


    }



}
