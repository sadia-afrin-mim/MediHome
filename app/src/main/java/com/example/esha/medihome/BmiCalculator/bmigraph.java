package com.example.esha.medihome.BmiCalculator;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.esha.medihome.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class bmigraph extends AppCompatActivity {
    databaseHelper database;
    GraphView graphview;
    LineGraphSeries<DataPoint> series;
    Button clear;
    double x,y,bmivalue;
    int numberOfPoints,index=0;
    double bmiarray[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmigraph);


        database=new databaseHelper(this);
        graphview=(GraphView) findViewById(R.id.bmigraph);
        series = new LineGraphSeries<DataPoint>();
        clear=(Button) findViewById(R.id.button);

        getData();
        DrawGraph();


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.deleteData();
            }
        });
    }

    public void DrawGraph()
    {
        x=0;

        for(int i=0;i<numberOfPoints;i++)
        {
            x=x+2;
            y=bmiarray[i];
            series.appendData(new DataPoint(x,y),true, numberOfPoints);
        }

        graphview.addSeries(series);
        series.setDrawDataPoints(true);

    }

/*This function will get values(x,y) from database and set it to an array*/

    void getData()
    {
        Cursor res= database.getAllData();
        numberOfPoints= res.getCount();


        if(numberOfPoints==0)
        {
            Toast.makeText(this,"No values",Toast.LENGTH_SHORT).show();
            return;
        }

        else
        {
            Toast.makeText(this,"Values",Toast.LENGTH_SHORT).show();
            bmiarray = new double[numberOfPoints];
        }

        index =0;

        while(res.moveToNext()){

            bmiarray[index++]=Double.parseDouble(res.getString(2).trim());
        }
    }
}
