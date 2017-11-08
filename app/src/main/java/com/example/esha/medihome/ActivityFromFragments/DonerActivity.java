package com.example.esha.medihome.ActivityFromFragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.esha.medihome.Others.doner;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.List;

import com.example.esha.medihome.R;

public class DonerActivity extends AppCompatActivity {
    private Button mFirebutton;
    private DatabaseReference mdatabase;
    ListView listViewArtists;
    List<doner> artistList;

    private EditText mname;
    private EditText mBloodgroup;
    private EditText mMobile;
    private EditText mEmail;
    private EditText mAddress;
    private EditText mLastDonation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doner);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFirebutton = (Button)findViewById(R.id.button2);
        mdatabase = FirebaseDatabase.getInstance().getReference();

        mname= (EditText)findViewById(R.id.name);
        mBloodgroup= (EditText)findViewById(R.id.bloodgroup);
        mMobile= (EditText)findViewById(R.id.mobile);
        mEmail= (EditText)findViewById(R.id.email);
        mAddress= (EditText)findViewById(R.id.address);
        mLastDonation= (EditText)findViewById(R.id.lastDonat);

        /*this will put a object into database*/

        mFirebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name =mname.getText().toString().trim();
                String bloodgroup =mBloodgroup.getText().toString().trim();
                String mobile =mMobile.getText().toString().trim();
                String email =mEmail.getText().toString().trim();
                String add =mAddress.getText().toString().trim();
                String last =mLastDonation.getText().toString().trim();

                doner mDoner = new doner(name,bloodgroup,mobile,email,add,last);


                mdatabase.child("Donor").push().setValue(mDoner).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {

                            Toast.makeText(DonerActivity.this,"Stored",Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(DonerActivity.this,"Error",Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

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
}
