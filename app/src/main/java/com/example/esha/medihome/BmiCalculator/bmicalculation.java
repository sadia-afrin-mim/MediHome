package com.example.esha.medihome.BmiCalculator;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.esha.medihome.R;

import static android.icu.text.DateFormat.getDateInstance;
import static android.icu.util.Calendar.getInstance;

public class bmicalculation extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView result;
    private TextView date;
    Button save;
    Button date1;
    Button graph;
    String dateString;

    Calendar cal= getInstance();
    databaseHelper bmidb;
    DateFormat formatDate = getDateInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculation2);

        height=(EditText)findViewById(R.id.height);
        weight=(EditText)findViewById(R.id.weight);
        result=(TextView) findViewById(R.id.result);
        date=(TextView) findViewById(R.id.datetextview);
        date1=(Button) findViewById(R.id.datebutton);
        save=(Button)findViewById(R.id.calc) ;
        graph=(Button) findViewById(R.id.stat);
        bmidb=new databaseHelper(this);


        date1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                getDate();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();




            }
        });

        graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(bmicalculation.this, bmigraph.class);
                startActivity(p);


            }
        });

    }
    public void calculateBMI()
    {
        Double bmi=0.0;
        String bmiString;
        String heightstr=height.getText().toString();
        String weightstr=weight.getText().toString();


        if(heightstr!=null && !"".equals(heightstr))
        {
            Double heightvalue= Double.parseDouble(heightstr)/100;
            Double weightvalue= Double.parseDouble(weightstr);
            bmi=(weightvalue)/(heightvalue*heightvalue);
            displayBMI(bmi);
        }
        bmiString = Double.toString(bmi);

/*if we do not insert value in height,weight and date..it wil not be inserted in database*/

        if(!TextUtils.isEmpty(heightstr)&& !TextUtils.isEmpty(weightstr)&& !TextUtils.isEmpty(dateString))
        {
            boolean flag =bmidb.insertData(dateString,bmiString);

            if(flag==true){
                Toast.makeText(bmicalculation.this,"inserted", Toast.LENGTH_SHORT).show();
            }
            else Toast.makeText(bmicalculation.this," not inserted",Toast.LENGTH_SHORT).show();

        }

        return ;

    }


    /*this will display the BMI result and your condition*/

    public void displayBMI(Double bmi)
    {
        String bmilevel="";
        if(Double.compare(bmi,15f)<=0)
        {
            bmilevel=getString(R.string.very_severly_underweight);

        }
        else if(Double.compare(bmi,15f)>0 && Double.compare(bmi,16f)<=0 )
        {
            bmilevel=getString(R.string.severly_underweight);

        }

        else if(Double.compare(bmi,16f)>0 && Double.compare(bmi,18.5f)<=0 )
        {
            bmilevel=getString(R.string.underweight);

        }

        else if(Double.compare(bmi,18.5f)>0 && Double.compare(bmi,25f)<=0 )
        {
            bmilevel=getString(R.string.normal);

        }

        else if(Double.compare(bmi,25f)>0 && Double.compare(bmi,30f)<=0 )
        {
            bmilevel=getString(R.string.overweight);

        }

        else if(Double.compare(bmi,30f)>0 && Double.compare(bmi,35f)<=0 )
        {
            bmilevel=getString(R.string.overweight_class_1);

        }

        else if(Double.compare(bmi,35f)>0 && Double.compare(bmi,40f)<=0 )
        {
            bmilevel=getString(R.string.overweight_class_2);

        }
        else
        {
            bmilevel=getString(R.string.over_weight_class_3);
        }
        bmilevel=bmi+"   "+bmilevel;
        result.setText(bmilevel);
    }

  /*this will get data according to a calander*/

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void getDate(){

        new DatePickerDialog(this,d, cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH)).show();
    }

    DatePickerDialog.OnDateSetListener d= new DatePickerDialog.OnDateSetListener() {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthofYear, int dayofMonth){

            cal.set(Calendar.YEAR,year);
            cal.set(Calendar.MONTH,monthofYear);
            cal.set(Calendar.DAY_OF_MONTH,dayofMonth);
            updateDate();

        }
    };


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void updateDate(){


        date.setText(formatDate.format(cal.getTime()));
        dateString = date.getText().toString();

    }

}
