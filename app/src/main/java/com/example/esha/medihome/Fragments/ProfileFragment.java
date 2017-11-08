package com.example.esha.medihome.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.esha.medihome.Others.Users;
import com.example.esha.medihome.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

/**
 * Created by esha on 02/11/17.
 */

public class ProfileFragment extends Fragment {
    private TextView username;
    private TextView email;
    private  TextView phoneno;
    FirebaseAuth auth;
    DatabaseReference mRef;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_profile,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        username=view.findViewById(R.id.pro_user);
        email=view.findViewById(R.id.pro_email);
        phoneno=view.findViewById(R.id.pro_phoneno);
        username.setText("esha");
        Toast.makeText(getActivity(),"profile",Toast.LENGTH_LONG).show();
        auth= FirebaseAuth.getInstance();
        mRef= FirebaseDatabase.getInstance().getReference().child("users");

        Query qRef= mRef.orderByChild("email").equalTo(auth.getCurrentUser().getEmail());



        qRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Users u = dataSnapshot.getValue(Users.class);
                email.setText(u.getEmail());
                username.setText(u.getUsername());
                phoneno.setText(u.getPhone());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}

