package com.dipakkr.github.bharathacks.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.dipakkr.github.bharathacks.R;
import com.dipakkr.github.bharathacks.model.PatientRequestData;
import com.dipakkr.github.bharathacks.model.UserInfo;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by anshul on 18/6/17.
 */

public class AmbulancePortal extends AppCompatActivity {

    ListView listView ;
    DatabaseReference mRef;
    FirebaseDatabase database;
    String key = "placeid";
    String latt,longg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_portal);

        mRef = FirebaseDatabase.getInstance().getReference("user");

        listView = (ListView) findViewById(R.id.list);
        String[] values = new String[] { "REQUEST FOR AMBULANCE 1"

        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);


        mRef.orderByChild(key).startAt("ChIJZ2R5uU_kDDkRge2NXfRngJU").endAt("ChIJZ2R5uU_kDDkRge2NXfRngJU")
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        UserInfo info = dataSnapshot.getValue(UserInfo.class);
                        PatientRequestData data = new PatientRequestData(info.latitude,info.longitude);
                        latt = data.getLatitude();
                        longg = data.getLongitude();
                        Log.e("LATITUDE ----->> ",latt);
                        Log.e("Longitude ---- >> ", longg);


                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;
                if(itemPosition ==0){
                    Intent i = new Intent(getApplicationContext(),UserLocation.class);
                    i.putExtra("Latitude",latt);
                    i.putExtra("Longitude",longg);
                    startActivity(i);
                }

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();

            }

        });
    }


}
