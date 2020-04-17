package com.example.healthhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class GoalTracker extends AppCompatActivity {
    EditText e1;
    Button b1, b2;
    RegistrationDatabase db;
    //String email;
    String yesterdaysDate;
    Calendar yesterdaysCalender;
    CheckBox c1, c2,c3,c4,c5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_tracker);
        db = new RegistrationDatabase(this);
        e1 = (EditText)findViewById(R.id.txtCurWeight);
        b1 = (Button)findViewById(R.id.btnEnterCurWeight);
        b2 = findViewById(R.id.backHomeGoalTrackerBtn);
        c1 = findViewById(R.id.checkWeightGoalInput);
        c2 = findViewById(R.id.checkWaterGoalInput);
        c3 = findViewById(R.id.checkSleepGoalInput);
        c4 = findViewById(R.id.checkStepsGoalInput);
        c5 = findViewById(R.id.checkCaloriesInput);
        //email = MainActivity.e1.getText().toString();
        Calendar calender = Calendar.getInstance();
        final String currentDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(calender.getTime());

        yesterdaysCalender = Calendar.getInstance();
        yesterdaysCalender.add(Calendar.DATE,-1);
        yesterdaysDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(yesterdaysCalender.getTime());
        TextView textViewDate= findViewById(R.id.yesterdaysDateTxt);
        textViewDate.setText(yesterdaysDate);

        // Weight Daily Trend
        String yesterdaysWeighDatabase = db.weightGoalTrackerYesterday();
        String todaysWeightDatabse = db.getWeightGoalTrackerToday();
        TextView textViewWeightDaily = findViewById(R.id.weightGoalDailyTrendTxt);
        if(yesterdaysWeighDatabase.equals("null")){
            textViewWeightDaily.setText("Data Unavaliable");
        }
        else {
            if(todaysWeightDatabse.equals("null")){
                textViewWeightDaily.setText((yesterdaysWeighDatabase) + " lbs");
            }
            else {
                int todaysWeightInt = Integer.parseInt(todaysWeightDatabse);
                int yesterdaysWeightInt = Integer.parseInt(yesterdaysWeighDatabase);
                int trendWeightDaily = todaysWeightInt - yesterdaysWeightInt;
                if(trendWeightDaily>0){
                    textViewWeightDaily.setText((yesterdaysWeighDatabase) + " lbs (Trend: +"+trendWeightDaily+" lbs) ");
                }
                else{
                    textViewWeightDaily.setText((yesterdaysWeighDatabase) + " lbs (Trend: "+trendWeightDaily+" lbs) ");
                }
            }
        }

        // Calculate Hydrate Daily Trend
        String yesterdaysHydrateDatabase = db.getHydrateGoalTrackerYesterday();
        String todaysHydrate = db.getHydrateGoalTrackerToday();
        TextView textViewHydrateDaily = findViewById(R.id.hydrateGoalDailyTrendTxt);
        if(yesterdaysHydrateDatabase.equals("null")){
            textViewHydrateDaily.setText("Data Unavaliable");
        }
        else {
            if(todaysHydrate.equals("null")){
                textViewHydrateDaily.setText((yesterdaysHydrateDatabase) + " cups");
            }
            else {
                int todaysHydrateInt = Integer.parseInt(todaysHydrate);
                int yesterdaysHydrateInt = Integer.parseInt(yesterdaysHydrateDatabase);
                int trendHydrateDaily = todaysHydrateInt - yesterdaysHydrateInt;
                if(trendHydrateDaily>0){
                    textViewHydrateDaily.setText((yesterdaysHydrateDatabase) + " cups (Trend: +"+trendHydrateDaily+" cups) ");
                }
                else{
                    textViewHydrateDaily.setText((yesterdaysHydrateDatabase) + " cups (Trend: "+trendHydrateDaily+" cups) ");
                }
            }
        }

        // Calories Daily Trend Calculate
        String yesterdaysCaloriesDatabse = db.getCaloriesGoalTrackerYesterday();
        String todaysCaloriesDatabase = db.getCaloriesGoalTrackerToday();
        TextView textViewCalorieDaily = findViewById(R.id.calorieGoalDailyTrendTxt);
        if(yesterdaysCaloriesDatabse=="null"){
            textViewCalorieDaily.setText("Data Unavaliable");
        }
        else{
            if(todaysCaloriesDatabase.equals("null")){
                textViewCalorieDaily.setText((yesterdaysCaloriesDatabse) + " cups");
            }
            else {
                int todaysCaloriesInt = Integer.parseInt(todaysCaloriesDatabase);
                int yesterdaysCaloriesInt = Integer.parseInt(yesterdaysCaloriesDatabse);
                int trendCaloriesDaily = todaysCaloriesInt - yesterdaysCaloriesInt;
                if(trendCaloriesDaily>0){
                    textViewCalorieDaily.setText((yesterdaysCaloriesDatabse) + " cals (Trend: +"+trendCaloriesDaily+" cals) ");
                }
                else{
                    textViewCalorieDaily.setText((yesterdaysCaloriesDatabse) + " cals (Trend: "+trendCaloriesDaily+" cals) ");
                }
            }
        }

        // Steps Daily Trend Calculate
        String yesterdaysStepsDatabase = db.getStepsGoalTrackerYesterday();
        String todayStepDatabase = db.getStepsGoalTrackerToday();
        TextView textViewStepDaily = findViewById(R.id.stepGoalDailyTrendTxt);
        if (yesterdaysStepsDatabase=="null"){
            textViewStepDaily.setText("Data Unavaliable");
        }
        else{
            if(todayStepDatabase.equals("null")){
                textViewStepDaily.setText((yesterdaysStepsDatabase) + " cups");
            }
            else {
                int todaysStepInt = Integer.parseInt(todayStepDatabase);
                int yesterdaysStepInt = Integer.parseInt(yesterdaysStepsDatabase);
                int trendStepDaily = todaysStepInt - yesterdaysStepInt;
                if(trendStepDaily>0){
                    textViewStepDaily.setText((yesterdaysStepsDatabase) + " steps (Trend: +"+trendStepDaily+" steps) ");
                }
                else{
                    textViewStepDaily.setText((yesterdaysStepsDatabase) + " cups (Trend: "+trendStepDaily+" cups) ");
                }
            }
        }

        // Sleep Daily Trend Calculation
        String yesterdaysSleepDatabase = db.getSleepGoalTrackerYesterday();
        String todaysSleepDatabase = db.getSleepGoalTrackerToday();
        TextView textViewSleepDaily = findViewById(R.id.sleepGoalDailyTrendTxt);
        if(yesterdaysSleepDatabase=="null"){
            textViewSleepDaily.setText("Data Unavaliable");
        }
        else {
            if(todaysSleepDatabase.equals("null")){
                textViewSleepDaily.setText((yesterdaysSleepDatabase) + " cups");
            }
            else {
                int todaysSleepInt = Integer.parseInt(todaysSleepDatabase);
                int yesterdaysSleepInt = Integer.parseInt(yesterdaysSleepDatabase);
                int trendSleepDaily = todaysSleepInt - yesterdaysSleepInt;
                if(trendSleepDaily>0){
                    textViewSleepDaily.setText((yesterdaysSleepDatabase) + " cups (Trend: +"+trendSleepDaily+" cups) ");
                }
                else{
                    textViewSleepDaily.setText((yesterdaysSleepDatabase) + " cups (Trend: "+trendSleepDaily+" cups) ");
                }
            }
        }

        Calendar lastWeeksCalendar = Calendar.getInstance();
        lastWeeksCalendar.add(Calendar.DATE,-7);
        String lastWeeksDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(lastWeeksCalendar.getTime());
        TextView textViewLastWeek = findViewById(R.id.lastWeeksDateTxt);
        textViewLastWeek.setText(lastWeeksDate);

        // Goal Tracking Weekly Fill in
        String weeklyWeight = db.weightGoalTrackerWeek();
        TextView textViewWeightWeekly = findViewById(R.id.weightGoalWeeklyTrendTxt);
        if(weeklyWeight=="null"){
            textViewWeightWeekly.setText("Data Unavaliable");
        }
        else {
            if(todaysHydrate.equals("null")){
                textViewWeightDaily.setText((yesterdaysWeighDatabase) + " lbs");
            }
            else {
                int todaysWeightInt = Integer.parseInt(todaysWeightDatabse);
                int weeklyWeightInt = Integer.parseInt(weeklyWeight);
                int trendWeeklyWeight = todaysWeightInt - weeklyWeightInt;
                if(trendWeeklyWeight>0){
                    textViewWeightDaily.setText((yesterdaysWeighDatabase) + " lbs (Trend: +"+trendWeeklyWeight+" lbs) ");
                }
                else{
                    textViewWeightDaily.setText((yesterdaysWeighDatabase) + " lbs (Trend: "+trendWeeklyWeight+" lbs) ");
                }
            }
        }

        String weeklyHydrate = db.getHydrateGoalTrackerWeekly();
        TextView textViewHydrateWeekly = findViewById(R.id.hydrateGoalWeeklyTrendTxt);
        if(weeklyHydrate=="null"){
            textViewHydrateWeekly.setText("Data Unavaliable");
        }
        else {
            if(todaysHydrate.equals("null")){
                textViewHydrateWeekly.setText((weeklyHydrate) + " cups");
            }
            else {
                int todaysHydrateInt = Integer.parseInt(todaysHydrate);
                int weeklyHydrateInt  = Integer.parseInt(weeklyHydrate);
                int trendHydrateWeekly = todaysHydrateInt - weeklyHydrateInt;
                if(trendHydrateWeekly>0){
                    textViewHydrateWeekly.setText((weeklyHydrate) + " cups (Trend: +"+trendHydrateWeekly+" cups) ");
                }
                else{
                    textViewHydrateWeekly.setText((weeklyHydrate) + " cups (Trend: "+trendHydrateWeekly+" cups) ");
                }
            }
        }

        String weeklySleep = db.getSleepGoalTrackerWeekly();
        TextView textViewSleepWeekly = findViewById(R.id.sleepGoalWeeklyTrendTxt);
        if(weeklyWeight=="null"){
            textViewSleepWeekly.setText("Data Unavaliable");
        }
        else {
            if(todaysSleepDatabase.equals("null")){
                textViewSleepWeekly.setText((weeklySleep) + " hours");
            }
            else {
                int todaysSleepInt = Integer.parseInt(todaysSleepDatabase);
                int weeklySleepInt = Integer.parseInt(weeklySleep);
                int trendSleepWeekly = todaysSleepInt - weeklySleepInt;
                if(trendSleepWeekly>0){
                    textViewSleepWeekly.setText((weeklySleep) + " hours (Trend: +"+trendSleepWeekly+" hours) ");
                }
                else{
                    textViewSleepWeekly.setText((weeklySleep) + " hours (Trend: "+trendSleepWeekly+" hours) ");
                }
            }
        }

        String weeklySteps = db.getStepsGoalTrackerWeekly();
        TextView textViewStepsWeekly = findViewById(R.id.stepGoalWeeklyTrendTxt);
        if(weeklyWeight=="null"){
            textViewStepsWeekly.setText("Data Unavaliable");
        }
        else {
            if(todayStepDatabase.equals("null")){
                textViewStepsWeekly.setText((weeklySteps) + " steps");
            }
            else {
                int todaysStepInt = Integer.parseInt(todayStepDatabase);
                int weeklyStepsInt = Integer.parseInt(weeklySteps);
                int trendStepWeekly = todaysStepInt - weeklyStepsInt;
                if(trendStepWeekly>0){
                    textViewStepsWeekly.setText((yesterdaysStepsDatabase) + " steps (Trend: +"+trendStepWeekly+" steps) ");
                }
                else{
                    textViewStepsWeekly.setText((yesterdaysStepsDatabase) + " steps (Trend: "+trendStepWeekly+" steps) ");
                }
            }
        }

        String weeklyCalories = db.getCaloriesGoalTrackerWeekly();
        TextView textViewCaloriesWeekly = findViewById(R.id.calorieGoalWeeklyTrendTxt);
        if(weeklyWeight=="null"){
            textViewCaloriesWeekly.setText("Data Unavaliable");
        }
        else {
            if(todaysCaloriesDatabase.equals("null")){
                textViewCaloriesWeekly.setText((weeklyCalories) + " calories");
            }
            else {
                int todaysCaloriesInt = Integer.parseInt(todaysCaloriesDatabase);
                int weeklyCaloriesInt = Integer.parseInt(weeklyCalories);
                int trendCaloriesWeekly = todaysCaloriesInt - weeklyCaloriesInt;
                if(trendCaloriesWeekly>0){
                    textViewCaloriesWeekly.setText((yesterdaysCaloriesDatabse) + " calories (Trend: +"+trendCaloriesWeekly+" calories) ");
                }
                else{
                    textViewCaloriesWeekly.setText((yesterdaysCaloriesDatabse) + " calories (Trend: "+trendCaloriesWeekly+" calories) ");
                }
            }
        }

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GoalTracker.this, HomePage.class) ;
                startActivity(i);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((c1.isChecked()&&c2.isChecked())||(c1.isChecked()&&c3.isChecked())||(c1.isChecked()&&c4.isChecked())||(c1.isChecked()&&c5.isChecked())||
                        (c2.isChecked()&&c3.isChecked())||(c2.isChecked()&&c4.isChecked())||(c2.isChecked()&&c5.isChecked())||
                        (c3.isChecked()&&c4.isChecked())||(c3.isChecked()&&c5.isChecked())||(c4.isChecked()&&c5.isChecked())){
                    Toast.makeText(getApplicationContext(), "please only select one goal for input", Toast.LENGTH_LONG).show();

                }
                else if (c1.isChecked() == true) {
                    String weightTracker = e1.getText().toString();
                    int weightGoalTrackingInt = 0;
                    weightGoalTrackingInt = Integer.parseInt(weightTracker);
                    Boolean weightGoalProgress = db.weightGoalProgress(weightGoalTrackingInt ,currentDate);
                    if (weightGoalProgress == true) {
                        c1.toggle();
                        e1.setText("");
                        Toast.makeText(getApplicationContext(), "Weight entered success: " + weightGoalTrackingInt, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Weight entered failed", Toast.LENGTH_LONG).show();
                    }
                }
                else if (c2.isChecked()==true){
                    String hydrateTracker = e1.getText().toString();
                    int hydrateGoalTrackingInt = 0;
                    hydrateGoalTrackingInt = Integer.parseInt(hydrateTracker);
                    Boolean hydrateGoalProgress = db.hydrateGoalProgress(hydrateGoalTrackingInt, currentDate);
                    if(hydrateGoalProgress==true) {
                        c2.toggle();
                        e1.setText("");
                        Toast.makeText(getApplicationContext(), "Hydrate entered success: " + hydrateGoalTrackingInt, Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Hydrate entered failed", Toast.LENGTH_LONG).show();

                    }
                }
                else if (c3.isChecked()==true){
                    String sleepTracker = e1.getText().toString();
                    int sleepTrackingInt = 0;
                    sleepTrackingInt = Integer.parseInt(sleepTracker);
                    Boolean sleepGoalProgress = db.sleepGoalProgess(sleepTrackingInt, currentDate);
                    if(sleepGoalProgress==true){
                        c3.toggle();
                        e1.setText("");
                        Toast.makeText(getApplicationContext(), "Sleep entered success: " + sleepTrackingInt, Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Sleep entered failed", Toast.LENGTH_LONG).show();
                    }
                }

                else if (c4.isChecked()==true){
                    String stepTracker = e1.getText().toString();
                    int stepTrackingInt = 0;
                    stepTrackingInt = Integer.parseInt(stepTracker);
                    Boolean stepGoalProgress = db.stepGoalProgress(stepTrackingInt, currentDate);
                    if(stepGoalProgress==true){
                        c4.toggle();
                        e1.setText("");
                        Toast.makeText(getApplicationContext(), "Steps entered success: " + stepTrackingInt, Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Steps entered failed", Toast.LENGTH_LONG).show();
                    }
                }

                else if (c5.isChecked()==true){
                    String calorieTracker = e1.getText().toString();
                    int calorieTrackingInt = 0;
                    calorieTrackingInt = Integer.parseInt(calorieTracker);
                    Boolean calorieGoalPress = db.caloriesGoalProgress(calorieTrackingInt, currentDate);
                    if(calorieGoalPress==true){
                        c5.toggle();
                        e1.setText("");
                        Toast.makeText(getApplicationContext(), "Calories entered success: " + calorieTrackingInt, Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Calories entered failed", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Goal Not Selected ", Toast.LENGTH_LONG).show();
                }


            }
            });

    }
}
