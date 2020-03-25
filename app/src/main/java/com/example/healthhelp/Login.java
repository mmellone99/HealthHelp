package com.example.healthhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;
    RegistrationDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        db = new RegistrationDatabase(this);
        e1 = (EditText)findViewById(R.id.txtemail2);
        e2 = (EditText)findViewById(R.id.txtpassword2);
        b1 = (Button)findViewById(R.id.btnlogin2);
        b2=(Button)findViewById(R.id.btnsignup);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(Login.this, MainActivity.class) ;
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean checkemailpass = db.emailpassword(email,password);
                if(checkemailpass==true) {
                    Toast.makeText(getApplicationContext(), "successful login", Toast.LENGTH_LONG).show();
                    Intent i = new Intent (Login.this, HomePage.class);
                    startActivity(i);
                }
                else
                    Toast.makeText(getApplicationContext(),"login failed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
