package com.example.healthhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class NewUserGoals extends AppCompatActivity {
    RegistrationDatabase db;
    String email;
    Button b1, b2,b3,b4,b5,b6;
    EditText e2,e3,e4,e5,e6;
    CheckBox c1,c2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_goals);
        db = new RegistrationDatabase(this);
        email = MainActivity.e1.getText().toString();
        e2 = (EditText) findViewById(R.id.targetWeightTxt);
        b1 = findViewById(R.id.setweightgoalbtn);
        e3 = findViewById(R.id.targetHydrateTxt);
        b2 = findViewById(R.id.sethydrategoalbtn);
        e4 = findViewById(R.id.targetSleepTxt);
        b3 = findViewById(R.id.setsleepgoalbtn);
        e5 = findViewById(R.id.targetStepsTxt);
        b4 = findViewById(R.id.setstepsgoalbtn);
        e6 = findViewById(R.id.targetCaloriesTxt);
        b5 = findViewById(R.id.setcaloriesgoalbtn);
        c1 = findViewById(R.id.checkKilogramWeightTarget);
        c2 = findViewById(R.id.checkPoundsWeightTarget);
        b6 = findViewById(R.id.finishNewUserProfileBtn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String weightTarget = e2.getText().toString();
                int weightTargetInt = 0;
                weightTargetInt = Integer.parseInt(weightTarget);
                if(c1.isChecked()){
                    weightTargetInt = weightTargetInt*2;
                }
                Boolean updateWeighTarget = db.updateWeightTarget(email,weightTargetInt);
                if(updateWeighTarget== true){
                    Toast.makeText(getApplicationContext(),"Weight entered success: "+weightTargetInt+"-",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Weight entered failed",Toast.LENGTH_LONG).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String hydrateTarget = e3.getText().toString();
                int hydrateTargetInt = 0;
                hydrateTargetInt = Integer.parseInt(hydrateTarget);
                Boolean updateHydrateTarget = db.updateHydrateGoal(email,hydrateTargetInt);
                if(updateHydrateTarget== true){
                    Toast.makeText(getApplicationContext(),"Hydrate entered success: "+hydrateTargetInt+"-",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Hydrate entered failed",Toast.LENGTH_LONG).show();
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String sleepTarget = e4.getText().toString();
                int sleepTargetInt = 0;
                sleepTargetInt = Integer.parseInt(sleepTarget);
                Boolean updateSleepTarget = db.updateSleepGoal(email,sleepTargetInt);
                if(updateSleepTarget== true){
                    Toast.makeText(getApplicationContext(),"Sleep entered success: "+sleepTargetInt+"-",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Sleep entered failed"+sleepTargetInt,Toast.LENGTH_LONG).show();
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String stepsTarget = e5.getText().toString();
                int stepsTargetInt = 0;
                stepsTargetInt = Integer.parseInt(stepsTarget);
                Boolean updateStepsTarget = db.updateStepsGoal(email,stepsTargetInt);
                if(updateStepsTarget== true){
                    Toast.makeText(getApplicationContext(),"Steps entered success: "+stepsTargetInt+"-",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Steps entered failed",Toast.LENGTH_LONG).show();
                }
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String caloriesTarget = e6.getText().toString();
                int caloriesTargetInt = 0;
                caloriesTargetInt = Integer.parseInt(caloriesTarget);
                Boolean updateCaloriesTarget = db.updateCaloriesGoal(email,caloriesTargetInt);
                if(updateCaloriesTarget== true){
                    Toast.makeText(getApplicationContext(),"Calories entered success: "+caloriesTargetInt+"-",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Calories entered failed",Toast.LENGTH_LONG).show();
                }
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NewUserGoals.this, HomePage.class) ;
                startActivity(i);
            }
        });

    }
}
