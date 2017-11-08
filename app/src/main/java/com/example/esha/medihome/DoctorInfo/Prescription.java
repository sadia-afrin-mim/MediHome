package com.example.esha.medihome.DoctorInfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.esha.medihome.R;

public class Prescription extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Spinner spinnerGenre;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);
        Button asthma, cp, dengue, diarrohoea, diptheria, influenza, pneumonia, hp, lp, ls;
        asthma = (Button) findViewById(R.id.asthma);
        cp = (Button) findViewById(R.id.cp);
        dengue = (Button) findViewById(R.id.dengue);
        diarrohoea = (Button) findViewById(R.id.diarrohoea);
        diptheria = (Button) findViewById(R.id.diptheria);
        influenza = (Button) findViewById(R.id.influenza);
        pneumonia = (Button) findViewById(R.id.pneumonia);
        hp = (Button) findViewById(R.id.pneumonia);
        lp = (Button) findViewById(R.id.lp);
        ls = (Button) findViewById(R.id.ls);
        asthma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Prescription.this, " albuterol   (0+0+1)per day", Toast.LENGTH_LONG).show();

            }
        });
        cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Prescription.this, "Acyclovir  (1+1+1) per day ", Toast.LENGTH_LONG).show();

            }
        });
        dengue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Prescription.this, "Acetaminophen (1+0+1) per day ", Toast.LENGTH_LONG).show();

            }
        });
        diarrohoea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Prescription.this, "modium (1+1+1) per day ", Toast.LENGTH_LONG).show();

            }
        });
        diptheria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Prescription.this, " penicillin (1+0+1) per day", Toast.LENGTH_LONG).show();

            }
        });
        influenza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Prescription.this, " zanamivir  (0+0+1) per day", Toast.LENGTH_LONG).show();
            }
        });
        pneumonia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Prescription.this, "Levofloxacin (1+0+1) per day ", Toast.LENGTH_LONG).show();

            }
        });
        hp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Prescription.this, " Bumetanide (1+0+0) per day", Toast.LENGTH_LONG).show();

            }
        });
        lp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Prescription.this, " Orvaten (1+0+1) per day", Toast.LENGTH_LONG).show();

            }
        });

        ls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Prescription.this, " sulfonylureas ", Toast.LENGTH_LONG).show();

            }
        });


    }
}
