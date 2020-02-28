package com.example.healthhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RegistrationDatabase db;
    EditText e1,e2,e3;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new RegistrationDatabase(this);
        e1=(EditText)findViewById(R.id.txtemail);
        e2=(EditText)findViewById(R.id.txtpassword);
        e3=(EditText)findViewById(R.id.txtconfrimpassword);
        b1=(Button)findViewById(R.id.btnreg);
        b2=(Button)findViewById(R.id.btnlogin);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
               Intent i = new Intent(MainActivity.this, Login.class) ;
               startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields Empty", Toast.LENGTH_LONG).show();
                }
                else{
                    if(s2.equals(s3)){
                        Boolean checkemail = db.checkemail(s1);
                        if(checkemail==true){
                            Boolean insert = db.insert(s1,s2);
                            if(insert==true)
                                Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Email Already exists", Toast.LENGTH_LONG).show();
                        }

                    }
                    Toast.makeText(getApplicationContext(), "Passwords do not match",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
