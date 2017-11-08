package com.example.esha.medihome.LoginAndSignUp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.esha.medihome.Medihome;
import com.example.esha.medihome.OnlineCare;
import com.example.esha.medihome.Others.Users;
import com.example.esha.medihome.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpPage extends AppCompatActivity {

    private Button signup;
    private EditText username;
    private EditText pass;
    private EditText email;
    private EditText phone;
    private EditText confirmpass;
    private FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    protected void connect_to_firebase() {
        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        firebaseAuth = FirebaseAuth.getInstance();

    }

    protected void setId() {
        signup = (Button) findViewById(R.id.regi_button);
        username = (EditText) findViewById(R.id.regi_user);
        pass = (EditText) findViewById(R.id.regi_pass);
        email = (EditText) findViewById(R.id.regi_email);
        phone = (EditText) findViewById(R.id.regi_phone);
        confirmpass = (EditText) findViewById(R.id.regi_con_pass);
    }
    protected void adduser()
    {
        final String usern=username.getText().toString().trim();
        final  String pas=pass.getText().toString().trim();
        final String mail=email.getText().toString().trim();
        final String phon=phone.getText().toString().trim();
        final String con=confirmpass.getText().toString().trim();
        if(!TextUtils.isEmpty(usern) && !TextUtils.isEmpty(pas) && !TextUtils.isEmpty(mail) && !TextUtils.isEmpty(phon))
        {
            if(phon.length()<11)
            {
                Toast.makeText(SignUpPage.this, "Invalid Phone no", Toast.LENGTH_LONG).show();


            }
            else if(!pas.equals(con))
            {
                Toast.makeText(SignUpPage.this, "Password Not Matched", Toast.LENGTH_LONG).show();

            }

            else {
                final ProgressDialog progressDialog=ProgressDialog.show(SignUpPage.this,"Please wait...","Processing",true);
                (firebaseAuth.createUserWithEmailAndPassword(mail,pas)).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override

                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()) {
                            String id = databaseReference.push().getKey();
                            Users u = new Users(usern,mail, phon);
                            databaseReference.child(id).setValue(u);
                            Toast.makeText(SignUpPage.this, "Registration Successful!!!", Toast.LENGTH_LONG).show();
                            Intent n = new Intent(getApplication(), OnlineCare.class);
                            startActivity(n);
                        }
                        else
                        {
                            Log.e("ERROR",task.getException().toString());
                            Toast.makeText(SignUpPage.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });



            }

        }
        else
        {
            Toast.makeText(this,"Some field missing",Toast.LENGTH_LONG).show();
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        setId();
        connect_to_firebase();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adduser();
            }
        });
    }
}
