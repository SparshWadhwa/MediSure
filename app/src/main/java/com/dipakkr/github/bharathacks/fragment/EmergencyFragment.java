package com.dipakkr.github.bharathacks.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dipakkr.github.bharathacks.R;
import com.dipakkr.github.bharathacks.activity.Emergency;

/**
 * Created by deepak on 6/17/17.
 */

public class EmergencyFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_emergency,container,false);

        Button bt_request = (Button)view.findViewById(R.id.ambulance);
        bt_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Emergency.class));
            }
        });
        return view;
    }
}
