package com.example.esha.medihome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Flash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        Thread myThread=new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    sleep(3000);
                    Intent n=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(n);
                    finish();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }

            }


        };
        myThread.start();

    }
}
