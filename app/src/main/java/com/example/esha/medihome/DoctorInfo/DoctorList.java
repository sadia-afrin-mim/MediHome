package com.example.esha.medihome.DoctorInfo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.esha.medihome.R;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.esha.medihome.ActivityFromFragments.ListViewOfDoner;
import com.example.esha.medihome.Others.doner;
import com.example.esha.medihome.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
public class DoctorList extends AppCompatActivity {
    DatabaseReference databaseArtists;
    ListView listViewArtists;
    List<Doctor> artistList;
    EditText editText1;
    EditText editTextName;
    EditText editTextType;
    EditText editTextPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        databaseArtists = FirebaseDatabase.getInstance().getReference("Artists");
        listViewArtists = (ListView) findViewById(R.id.listViewArtists);
        artistList = new ArrayList<>();
        editText1=(EditText) findViewById(R.id.editText2);

        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onStart() {
        super.onStart();
        databaseArtists.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                artistList.clear();
                for (DataSnapshot artistSnapshot : dataSnapshot.getChildren()) {
                    Doctor artist = artistSnapshot.getValue(Doctor.class);
                    artistList.add(artist);
                }
                ListViewOfDoctor adapter = new ListViewOfDoctor(DoctorList.this, artistList);
                listViewArtists.setAdapter(adapter);

            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
