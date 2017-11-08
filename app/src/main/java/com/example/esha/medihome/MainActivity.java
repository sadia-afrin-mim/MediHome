package com.example.esha.medihome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.example.esha.medihome.BmiCalculator.bmicalculation;
import com.example.esha.medihome.DoctorInfo.DoctorTab;
import com.example.esha.medihome.LoginAndSignUp.SignUpPage;
import com.example.esha.medihome.Map.MapsActivity;
import com.example.esha.medihome.Yoga.Cat;
import com.example.esha.medihome.Yoga.Cow;
import com.example.esha.medihome.Yoga.Warrior;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button nevi;
    Button about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        nevi=(Button)findViewById(R.id.home_page_continue);
        about=(Button)findViewById(R.id.home_page_about);
        nevi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n=new Intent(getApplication(), OnlineCare.class);
                startActivity(n);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n=new Intent(getApplication(),About.class);
                startActivity(n);

            }
        });

    }
}
