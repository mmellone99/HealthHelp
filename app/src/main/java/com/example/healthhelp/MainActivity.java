package com.example.healthhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RegistrationDatabase db;
    public static EditText e1;
    EditText e2,e3, e4, e5, e6, e7, e8;
    Button b1,b2; //comment
    CheckBox c1, c2, c3, c4, c5, c6, c7, c8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new RegistrationDatabase(this);
        e1=(EditText)findViewById(R.id.txtemail);
        e2=(EditText)findViewById(R.id.txtpassword);
        e3=(EditText)findViewById(R.id.txtconfrimpassword);
        e4 = (EditText)findViewById(R.id.txtname);
        e5 = (EditText)findViewById(R.id.txtheightinput1);
        e6 = (EditText) findViewById(R.id.txtheightinput2);
        e7 = (EditText) findViewById(R.id.txtweight);
        e8 = (EditText) findViewById(R.id.txtage);
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
                String s4 = e4.getText().toString();
                int s5 = 0;
                int s6 = 0;
                int s7 = 0;
                int s8 = 0;

                // Inserts 0 into database if height, weight or age are left blank
                if (e5.getText().toString().equals("")){
                    s5 = 0;
                }
                else {
                    s5 = Integer.parseInt(e5.getText().toString());
                }
                if(e6.getText().toString().equals("")){
                    s6 = 0;
                }
                else{
                    s6 = Integer.parseInt(e6.getText().toString());
                }
                if(e7.getText().toString().equals("")){
                    s7 = 0;
                }
                else{
                    s7 = Integer.parseInt(e7.getText().toString());
                }
                if(e8.getText().toString().equals("")){
                    s8 = 0;
                }
                else{
                    s8 = Integer.parseInt(e8.getText().toString());
                }
                int totalheight = 0;
                // Can only check feet/inches or meteres/centimeters
                c1 = findViewById(R.id.checkfeet);
                c2 = findViewById(R.id.checkinches);
                c3 = findViewById(R.id.checkmeters);
                c4 = findViewById(R.id.checkcentimeters);
                if(c1.isChecked()&&c2.isChecked()){
                    totalheight = (12*s5)+s6;
                }
                // 1 inch = 2.5 cm
                else if (c3.isChecked()&&c4.isChecked()){
                    totalheight = ((100*s5)+s6)*2/5;
                }
                else if (c1.isChecked()&&c3.isChecked()){
                    Toast.makeText(getApplicationContext(),"Select only one unit for first height input",Toast.LENGTH_LONG).show();
                }
                else if(c2.isChecked()&&c4.isChecked()){
                    Toast.makeText(getApplicationContext(),"Select only one unit for second height input",Toast.LENGTH_LONG).show();
                }
                else if ((!(e5.getText().toString()).equals(""))&&(!(e6.getText().toString()).equals(""))){
                    Toast.makeText(getApplicationContext(),"Select either ft/in or m/cm",Toast.LENGTH_LONG).show();
                }

                int totalweight = 0;
                // Convertes kilograms to pounds using 1 kilogram = 2 pounds
                c5 = findViewById(R.id.checkpounds);
                c6 = findViewById(R.id.checkkilograms);
                if(c5.isChecked()&&c6.isChecked()){
                    Toast.makeText(getApplicationContext(),"Select only one unit for weight",Toast.LENGTH_LONG).show();
                }
                else if (c5.isChecked()){
                    totalweight = s7;
                }
                else if (c6.isChecked()){
                    totalweight = s7*2;
                }
                else if ((!(e5.getText().toString()).equals(""))){
                    Toast.makeText(getApplicationContext(),"Select unit for weight",Toast.LENGTH_LONG).show();

                }
                String gender = null;
                c7 = findViewById(R.id.checkfemale);
                c8 = findViewById(R.id.checkmale);
                if(c7.isChecked()){gender = "F";}
                else if(c8.isChecked()){gender = "M";}


                if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields Empty", Toast.LENGTH_LONG).show();
                }
                else{
                    if(s2.equals(s3)){
                        Boolean checkemailpassword = db.emailpassword(s1,s2);
                        Boolean checkemail = db.checkemail(s1);
                        // Valid Email and Password case
                        if(checkemailpassword==false){
                            Boolean insert = db.insert(s1,s2);
                            Boolean insertInformation = db.insertInformation(s1,s4,totalheight,totalweight,s8,gender);
                            Boolean insertGoalsTargetInitial = db.insertTargetGoals(s1, 0,0,0,0,0);

                            if(insert==true&&insertInformation==true)
                                Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_LONG).show();
                                Intent i = new Intent(MainActivity.this, NewUserGoals.class) ;
                                startActivity(i);
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Password or Email Already In Use", Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                        Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
