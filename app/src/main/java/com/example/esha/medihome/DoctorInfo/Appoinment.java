package com.example.esha.medihome.DoctorInfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.esha.medihome.R;

import android.widget.EditText;
import android.widget.ListView;

import com.example.esha.medihome.ActivityFromFragments.ListViewOfDoner;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fatema on 11/8/17.
 */

public class Appoinment extends Fragment{
    DatabaseReference databaseArtists;
    ListView listViewArtists;
    List<Doctor> artistList;
    EditText editText1;
    EditText editTextName;
    EditText editTextType;
    EditText editTextPhone;

    private static final String TAG = "tab2fragment";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_doctor_list, container, false);
        return view;
    }


}
