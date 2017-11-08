package com.example.esha.medihome.chatbot;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.esha.medihome.R;

public class bot extends AppCompatActivity {
    private Button bp;
    private TextView t;
    private EditText e;

    String[][] chatbot={
            {"hi","hello"},
            {"hi","hello"},
            {"how r u","how are you"},{"good","well"},
            {"yes"},{"no"},
            {"stop","shut up"},{"not available"}
    };
    void define()
    {
        bp=(Button)findViewById(R.id.botbutton);
        t=(TextView)findViewById(R.id.bot);
        e=(EditText)findViewById(R.id.ppl);
    }
    private boolean inarray(String in, String[] str)
    {
        boolean match=false;
        for(int i=0;i<str.length;i++)
        {
            if(str[i].equals(in))
            {
                match=true;
            }
        }
        return match;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String msg=e.getText().toString().trim();
        char c=msg.charAt(msg.length()-1);
        while(c=='!' || c=='?' || c=='.')
        {
             msg=msg.substring(0,msg.length()-1);

        }
        msg.trim();
        byte responce=0;
        int j=0;
        while(responce==0)
        {
            if(inarray(msg.toLowerCase(),chatbot[j*2]))
            {
                  responce=2;
                int r=(int)Math.floor(Math.random()*chatbot[(j*2)+1].length);
                t.setText(chatbot[(j*2)+1][r]);
            }
            j++;
           if(j*2==chatbot.length-1 && responce==0)
           {
               responce=1;
           }
           if(responce==1)
           {
               int r=(int)Math.floor(Math.random()*chatbot[chatbot.length-1].length);
               t.setText(chatbot[chatbot.length-1][r]);
           }
        }


    }

}
