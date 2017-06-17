package com.dipakkr.github.bharathacks;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by root on 6/17/17.
 */

public class SimpleAdapter extends FragmentPagerAdapter {

    Context mContext;
    public SimpleAdapter(Context context,FragmentManager fm) {
        super(fm);
        mContext =context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case  0 : return new MedicalFragment();

            case 1 : return new ClinicsFragment();

            case 2 : return  new HospitalFragment();
        }
        return new MedicalFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 : mContext.getResources().getString(R.string.medical);

            case 1 : mContext.getResources().getString(R.string.clinics);

            case 2 : mContext.getResources().getString(R.string.medical);

        }
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return 3;
    }

}
