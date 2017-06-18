package com.dipakkr.github.bharathacks.activity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dipakkr.github.bharathacks.MainActivity;
import com.dipakkr.github.bharathacks.R;

/**
 * Created by anshul on 18/6/17.
 */

public class ChooserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);


    Button bt_hospital = (Button)findViewById(R.id.bt_hospital);
        Button bt_user =(Button)findViewById(R.id.bt_user_portal);

        bt_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        bt_hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AmbulancePortal.class));
            }
        });
    }
}
