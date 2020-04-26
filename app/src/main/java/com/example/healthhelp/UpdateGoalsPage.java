package com.example.healthhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class UpdateGoalsPage extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6;
    EditText e1,e2,e3,e4,e5;
    RegistrationDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_goal_page);
        b1 = findViewById(R.id.updateWeightGoalBtn);
        e1 = findViewById(R.id.WeightGoalUpdateTxt);
        b2 = findViewById(R.id.updateWaterGoalBtn);
        e2 = findViewById(R.id.WaterGoalUpdateTxt);
        b3 = findViewById(R.id.updateStepsGoalBtn);
        e3 = findViewById(R.id.StepsGoalUpdateTxt);
        b4 = findViewById(R.id.updateCaloriesGoalBtn);
        e4 = findViewById(R.id.CaloriesGoalUpdateTxt);
        b5 = findViewById(R.id.updateSleepGoalBtn);
        e5 = findViewById(R.id.CaloriesSleepUpdateTxt);
        b6 = findViewById(R.id.btnUpdateGoalHome);
        db = new RegistrationDatabase(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightTarget = e1.getText().toString();
                int weightTargetInt = 0;
                weightTargetInt = Integer.parseInt(weightTarget);
                Boolean updateWeighTarget = db.updateWeightTargetProfile(weightTargetInt);
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
            public void onClick(View v) {
                String waterTarget = e2.getText().toString();
                int waterTargetInt = 0;
                waterTargetInt = Integer.parseInt(waterTarget);
                Boolean updateHydrateGoalProfile = db.updateHydrateGoalProfile(waterTargetInt);
                if(updateHydrateGoalProfile== true){
                    Toast.makeText(getApplicationContext(),"Water entered success: "+waterTarget,Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Water entered failed",Toast.LENGTH_LONG).show();
                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stepsTarget = e3.getText().toString();
                int stepsGoalInt = 0;
                stepsGoalInt = Integer.parseInt(stepsTarget);
                Boolean updateStepsGoalProfile = db.updateStepsGoalProfile(stepsGoalInt);
                if(updateStepsGoalProfile== true){
                    Toast.makeText(getApplicationContext(),"Steps entered success: "+stepsTarget,Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Steps entered failed",Toast.LENGTH_LONG).show();
                }

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String caloriesTarget = e4.getText().toString();
                int caloriesGoalInt = 0;
                caloriesGoalInt = Integer.parseInt(caloriesTarget);
                Boolean updateCaloriesGoalProfile = db.updateCaloriesGoalProfile(caloriesGoalInt);
                if(updateCaloriesGoalProfile== true){
                    Toast.makeText(getApplicationContext(),"Calories entered success: "+caloriesTarget,Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Calories entered failed",Toast.LENGTH_LONG).show();
                }

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sleepTarget = e5.getText().toString();
                int sleepGoalInt = 0;
                sleepGoalInt = Integer.parseInt(sleepTarget);
                Boolean updateSleepGoalProfile = db.updateSleepGoalProfile(sleepGoalInt);
                if(updateSleepGoalProfile== true){
                    Toast.makeText(getApplicationContext(),"Sleep entered success: "+sleepTarget,Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Sleep entered failed",Toast.LENGTH_LONG).show();
                }

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(UpdateGoalsPage.this, HomePage.class) ;
                startActivity(i);
            }
        });


    }
}

