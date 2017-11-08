package com.example.esha.medihome.DoctorInfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.esha.medihome.Medihome;
import com.example.esha.medihome.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.esha.medihome.R;
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

public class AddDoctor extends Fragment{
    EditText editTextName;
    EditText editTextType;
    EditText editTextPhone;
    Spinner spinnerGenre;
    Button buttonAdd;
    Button buttonshow;
    DatabaseReference databaseDoctors;
    ListView listViewDoctors;

    List<Doctor> artistList;

    private static final String TAG = "tab3fragment";
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_add_doctor, container, false);
        final String Doctor_Name = "doctorname";
        databaseDoctors = FirebaseDatabase.getInstance().getReference("Artists");
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("sadia");
       editTextName = (EditText)view.findViewById(R.id.editTextName);
        editTextType = (EditText)view.findViewById(R.id.editTextType);
        editTextPhone = (EditText)view.findViewById(R.id.editTextPhone);
        spinnerGenre = (Spinner)view.findViewById(R.id.spinnerGenre);

        artistList = new ArrayList<>();

        buttonAdd = (Button)view.findViewById(R.id.buttonAddArtist);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addArtist();

            }
        });

        buttonshow=(Button)view.findViewById(R.id.showdoctor);
        buttonshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newactivity();

            }
        });

        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        databaseDoctors.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                artistList.clear();
                for (DataSnapshot artistSnapshot : dataSnapshot.getChildren()) {
                    Doctor artist = artistSnapshot.getValue(Doctor.class);
                    artistList.add(artist);
                }
  }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void addArtist() {
        String name = editTextName.getText().toString().trim();
        String genre = spinnerGenre.getSelectedItem().toString();
        String type = editTextType.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        if (!TextUtils.isEmpty(name)) {
            String id = databaseDoctors.push().getKey();
            Doctor doctor = new Doctor(name, genre, type, phone);
            databaseDoctors.child(id).setValue(doctor);


        } else {

        }
    }
    public void newactivity()
    {
        Intent intent = new Intent(getActivity(),DoctorList.class);
        startActivity(intent);
    }
}
