package com.dipakkr.github.bharathacks.Utils;

import android.app.Activity;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by root on 6/17/17.
 */

public class HelpUtils {
    public static void showEmergency(AppCompatActivity activity){
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Fragment fragment = fm.findFragmentByTag("about_dialog");

        if(fragment !=null){
            ft.remove(fragment);
        }
        ft.addToBackStack(null);

        new ShowEmergency();
    }
    public static class ShowEmergency extends Fragment{

    }

}
