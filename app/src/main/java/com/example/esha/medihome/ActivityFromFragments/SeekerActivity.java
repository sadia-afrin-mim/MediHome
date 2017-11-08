package com.example.esha.medihome.ActivityFromFragments;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.esha.medihome.Others.doner;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.button;
import com.example.esha.medihome.R;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.esha.medihome.R;

public class SeekerActivity extends AppCompatActivity {
    DatabaseReference databaseArtists;
    ListView listViewArtists;
    List<doner> artistList;
    EditText editText1;
    Button b;
    EditText editTextName;
    EditText editTextType;
    EditText editTextPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        databaseArtists = FirebaseDatabase.getInstance().getReference("Donor");
        listViewArtists = (ListView) findViewById(R.id.listViewArtists);
        artistList = new ArrayList<>();
        editText1=(EditText) findViewById(R.id.editText2);
        b=(Button) findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=editText1.getText().toString();
                Intent callintent= new Intent(Intent.ACTION_CALL);
                callintent.setData(Uri.parse("tel:"+number));
                startActivity(callintent);
            }
        });

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
                    doner artist = artistSnapshot.getValue(doner.class);
                    artistList.add(artist);
                }
                ListViewOfDoner adapter = new ListViewOfDoner(SeekerActivity.this, artistList);
                listViewArtists.setAdapter(adapter);

            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    }

