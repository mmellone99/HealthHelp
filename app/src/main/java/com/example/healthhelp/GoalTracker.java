package com.example.healthhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class GoalTracker extends AppCompatActivity {
    EditText e1;
    Button b1;
    RegistrationDatabase db;
    //String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_tracker);
        db = new RegistrationDatabase(this);
        e1 = (EditText)findViewById(R.id.txtCurWeight);
        b1 = (Button)findViewById(R.id.btnEnterCurWeight);
        //email = MainActivity.e1.getText().toString();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String weightTracker = e1.getText().toString();
                int weightGoalTrackingInt = 0;
                weightGoalTrackingInt = Integer.parseInt(weightTracker);
                Boolean weightGoalProgress = db.weightGoalProgress(weightGoalTrackingInt);
                if(weightGoalProgress== true){
                    Toast.makeText(getApplicationContext(),"Hydrate entered success: "+weightGoalTrackingInt+"-",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Hydrate entered failed",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
