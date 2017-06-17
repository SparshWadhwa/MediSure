package com.dipakkr.github.bharathacks.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.dipakkr.github.bharathacks.ClinicsFragment;
import com.dipakkr.github.bharathacks.HospitalFragment;
import com.dipakkr.github.bharathacks.MedicalFragment;
import com.dipakkr.github.bharathacks.R;
import com.dipakkr.github.bharathacks.Utils.HelpUtils;
import com.dipakkr.github.bharathacks.fragment.EmergencyFragment;

/**
 * Created by root on 6/17/17.
 */

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:

                    Fragment fragment = new EmergencyFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content, fragment, fragment.getClass().getSimpleName()).commit();

                    return true;

                case R.id.navigation_dashboard:

                    return true;

                case R.id.navigation_notifications:


                    return true;
            }
            return true;
        }

    };
}
