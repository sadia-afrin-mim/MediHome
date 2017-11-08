package com.example.esha.medihome.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.esha.medihome.ActivityFromFragments.DonerActivity;
import com.example.esha.medihome.ActivityFromFragments.SeekerActivity;
import com.example.esha.medihome.R;

/**
 * Created by esha on 03/11/17.
 */

public class BloodInfoFragment extends Fragment {

    @Override

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_blood_info,container,false);
        Button donerpage=(Button)view.findViewById(R.id.donor_button);
        donerpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent donerpage=new Intent(getActivity(),DonerActivity.class);
                startActivity(donerpage);

            }
        });
        Button seekerpage=(Button)view.findViewById(R.id.seeker_button);
        seekerpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent seekerpage=new Intent(getActivity(),SeekerActivity.class);
                startActivity(seekerpage);
            }
        });

        return view;




    }

}
