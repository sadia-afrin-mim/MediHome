package com.example.esha.medihome.DoctorInfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.esha.medihome.R;

public class emergency extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        Button button1, button2;
        button1 = (Button) findViewById(R.id.prescription);
        button2 = (Button) findViewById(R.id.hospital);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(emergency.this, Prescription.class);
                startActivity(Intent);
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent Intent = new Intent(emergency.this,maps.class);
                //startActivity(Intent);
            }
        });
    }
}

