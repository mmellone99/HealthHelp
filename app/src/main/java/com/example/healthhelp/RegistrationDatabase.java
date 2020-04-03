package com.example.healthhelp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.healthhelp.Model.Information;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class RegistrationDatabase extends SQLiteOpenHelper {
    public RegistrationDatabase(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key , password text)");
        db.execSQL("Create table information(email text primary key, name text, age int, height int, weight int, gender text)");
        db.execSQL("Create table goalTargets (email text primary key, weightTarget int, water int, steps int, calories int, sleep int)");
        db.execSQL("Create table goalTracking (email text primary key, weightTracker int, waterTracker int, stepsTracker int, caloriesTracker int, sleepTracker int, dateInserted text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists information");
        db.execSQL("drop table if exists goalTargets");
        db.execSQL("drop table if exists goalTracking");
    }
    public boolean insert(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password",password);
        long ins =db.insert("user", null, contentValues);
        if(ins == -1)
            return false;
        else
            return true;
    }

    public boolean insertInformation (String email, String name, int height, int weight, int age, String gender){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("name",name);
        contentValues.put("age",age);
        contentValues.put("height",height);
        contentValues.put("weight",weight);
        contentValues.put("gender",gender);
        long ins = db.insert("information",null,contentValues);
        if(ins==-1)
            return false;
        else
            return true;
    }

    public boolean insertTargetGoals (String email, int weight, int steps, int calories, int sleep, int water){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("weightTarget",weight);
        contentValues.put("steps",steps);
        contentValues.put("calories",calories);
        contentValues.put("water",water);
        contentValues.put("sleep",sleep);
        long ins = db.insert("goalTargets",null, contentValues);
        if(ins==-1)
            return false;
        else
            return true;
    }

    public boolean updateWeightTarget (String email, int weightTarget){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("weightTarget",weightTarget);
        long ins = db.update("goalTargets",contentValues,"email=?",new String[]{email});
        if(ins==-1)
            return false;
        else
            return true;
    }

    public boolean weightGoalProgress (int weightTracker, String dateInserted){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("dateInserted",dateInserted);
        contentValues.put("weightTracker", weightTracker);
        long ins = db.insert("goalTracking",null,contentValues);
        if(ins==-1)
            return false;
        else
            return true;
    }

    public String weightGoalTrackerYesterday(){
        SQLiteDatabase db = this.getReadableDatabase();
        Calendar yesterdaysCalender;
        String yesterdaysDate;
        yesterdaysCalender = Calendar.getInstance();
        yesterdaysCalender.add(Calendar.DATE,-1);
        yesterdaysDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(yesterdaysCalender.getTime());
        Cursor cursor = db.rawQuery("Select * from goalTracking WHERE dateInserted=? AND weightTracker IS NOT NULL",new String[]{yesterdaysDate});
        int yesterdaysWeight = 0;
        if(cursor.getCount()==0){
            return "null";
        }
        while(cursor.moveToNext()){
            yesterdaysWeight = cursor.getInt(1);
        }
        return (Integer.toString(yesterdaysWeight));
    }

    public String weightGoalTrackerWeek(){
        SQLiteDatabase db = this.getReadableDatabase();
        Calendar weeklyCalendar;
        String weeklyDate;
        weeklyCalendar = Calendar.getInstance();
        weeklyCalendar.add(Calendar.DATE,-7);
        weeklyDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(weeklyCalendar.getTime());
        Cursor cursor = db.rawQuery("Select * from goalTracking WHERE dateInserted=? AND weightTracker IS NOT NULL",new String[]{weeklyDate});
        int weeklyWeight = 0;
        if(cursor.getCount()==0){
            return "null";
        }
        while(cursor.moveToNext()){
            weeklyWeight = cursor.getInt(1);
        }
        return (Integer.toString(weeklyWeight));
    }

    public String getWeightGoalTrackerToday(){
        SQLiteDatabase db = this.getReadableDatabase();
        Calendar todaysCalendar;
        String todaysDate;
        todaysCalendar = Calendar.getInstance();
        todaysDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(todaysCalendar.getTime());
        Cursor cursor = db.rawQuery("Select * from goalTracking WHERE dateInserted=? AND weightTracker IS NOT NULL",new String[]{todaysDate});
        int todaysWeight = 0;
        if(cursor.getCount()==0){
            return "null";
        }
        else {
            while (cursor.moveToNext()) {
                todaysWeight = cursor.getInt(1);
            }
        }
        return Integer.toString(todaysWeight);
    }



    public String getHydrateGoalTrackerYesterday(){
        SQLiteDatabase db = this.getReadableDatabase();
        Calendar yesterdaysCalender;
        String yesterdaysDate;
        yesterdaysCalender = Calendar.getInstance();
        yesterdaysCalender.add(Calendar.DATE,-1);
        yesterdaysDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(yesterdaysCalender.getTime());
        Cursor cursor = db.rawQuery("Select * from goalTracking WHERE dateInserted=? AND waterTracker IS NOT NULL",new String[]{yesterdaysDate});
        int yesterdaysWater = 0;
        if(cursor.getCount()==0){
            return "null";
        }
        else {
            while (cursor.moveToNext()) {
                yesterdaysWater = cursor.getInt(2);
            }
        }
        return Integer.toString(yesterdaysWater);
    }

    public String getHydrateGoalTrackerToday(){
        SQLiteDatabase db = this.getReadableDatabase();
        Calendar todaysCalendar;
        String todaysDate;
        todaysCalendar = Calendar.getInstance();
        todaysDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(todaysCalendar.getTime());
        Cursor cursor = db.rawQuery("Select * from goalTracking WHERE dateInserted=? AND waterTracker IS NOT NULL",new String[]{todaysDate});
        int yesterdaysWater = 0;
        if(cursor.getCount()==0){
            return "null";
        }
        else {
            while (cursor.moveToNext()) {
                yesterdaysWater = cursor.getInt(2);
            }
        }
        return Integer.toString(yesterdaysWater);
    }


    public String getHydrateGoalTrackerWeekly(){
        SQLiteDatabase db = this.getReadableDatabase();
        Calendar weeklyCalendar;
        String weeklyDate;
        weeklyCalendar = Calendar.getInstance();
        weeklyCalendar.add(Calendar.DATE,-7);
        weeklyDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(weeklyCalendar.getTime());
        Cursor cursor = db.rawQuery("Select * from goalTracking WHERE dateInserted=? AND waterTracker IS NOT NULL",new String[]{weeklyDate});
        int weeklyWater = 0;
        if(cursor.getCount()==0){
            return "null";
        }
        else {
            while (cursor.moveToNext()) {
                weeklyWater = cursor.getInt(2);
            }
        }
        return Integer.toString(weeklyWater);
    }



    public boolean updateHydrateGoal (String email, int hydrateTarget){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("water",hydrateTarget);
        long ins = db.update("goalTargets",contentValues, "email=?",new String[]{email});
        if(ins == -1)
            return false;
        else
            return true;
    }
    public boolean hydrateGoalProgress(int hydrateTracker, String dateInserted){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("dateInserted",dateInserted);
        contentValues.put("waterTracker", hydrateTracker);
        long ins = db.insert("goalTracking",null,contentValues);
        if(ins==-1)
            return false;
        else
            return true;
    }


    public boolean updateSleepGoal (String email, int sleepTarget){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sleep",sleepTarget);
        long ins = db.update("goalTargets",contentValues,"email=?",new String[]{email});
        if(ins==-1)
            return false;
        else
            return true;
    }

    public boolean sleepGoalProgess(int sleepTracker, String dateInserted){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("dateInserted",dateInserted);
        contentValues.put("sleepTracker", sleepTracker);
        long ins = db.insert("goalTracking",null,contentValues);
        if(ins==-1)
            return false;
        else
            return true;
    }

    public String getSleepGoalTrackerYesterday(){
        SQLiteDatabase db = this.getReadableDatabase();
        Calendar yesterdaysCalendar;
        String yesterdaysDate;
        yesterdaysCalendar = Calendar.getInstance();
        yesterdaysCalendar.add(Calendar.DATE,-1);
        yesterdaysDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(yesterdaysCalendar.getTime());
        Cursor cursor = db.rawQuery("Select * from goalTracking WHERE dateInserted=? AND sleepTracker IS NOT NULL",new String[]{yesterdaysDate});
        int yesterdaysSleep = 0;
        if(cursor.getCount()==0){
            return "null";
        }
        else{
            while(cursor.moveToNext()){
                yesterdaysSleep = cursor.getInt(5);
            }

        }
        return Integer.toString(yesterdaysSleep);
    }

    public String getSleepGoalTrackerWeekly(){
        SQLiteDatabase db = this.getReadableDatabase();
        Calendar weeklyCalendar;
        String weeklyDate;
        weeklyCalendar = Calendar.getInstance();
        weeklyCalendar.add(Calendar.DATE,-7);
        weeklyDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(weeklyCalendar.getTime());
        Cursor cursor = db.rawQuery("Select * from goalTracking WHERE dateInserted=? AND sleepTracker IS NOT NULL",new String[]{weeklyDate});
        int weeklySleep = 0;
        if(cursor.getCount()==0){
            return "null";
        }
        else{
            while(cursor.moveToNext()){
                weeklySleep = cursor.getInt(5);
            }

        }
        return Integer.toString(weeklySleep);
    }

    public String getSleepGoalTrackerToday(){
        SQLiteDatabase db = this.getReadableDatabase();
        Calendar todaysCalendar;
        String todaysDate;
        todaysCalendar = Calendar.getInstance();
        todaysDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(todaysCalendar.getTime());
        Cursor cursor = db.rawQuery("Select * from goalTracking WHERE dateInserted=? AND sleepTracker IS NOT NULL",new String[]{todaysDate});
        int todaySleep = 0;
        if(cursor.getCount()==0){
            return "null";
        }
        else {
            while (cursor.moveToNext()) {
                todaySleep = cursor.getInt(5);
            }
        }
        return Integer.toString(todaySleep);
    }



    public boolean updateStepsGoal (String email, int stepsTarget){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("steps",stepsTarget);
        long ins = db.update("goalTargets",contentValues,"email=?",new String[]{email});
        if(ins == -1)
            return false;
        else
            return true;
    }

    public boolean stepGoalProgress (int stepTracker, String dateInserted){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("dateInserted",dateInserted);
        contentValues.put("stepsTracker", stepTracker);
        long ins = db.insert("goalTracking",null,contentValues);
        if(ins==-1)
            return false;
        else
            return true;
    }

    public String getStepsGoalTrackerYesterday(){
        SQLiteDatabase db = this.getReadableDatabase();
        Calendar yesterdaysCalendar;
        String yesterdaysDate;
        yesterdaysCalendar = Calendar.getInstance();
        yesterdaysCalendar.add(Calendar.DATE,-1);
        yesterdaysDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(yesterdaysCalendar.getTime());
        Cursor cursor = db.rawQuery("Select * from goalTracking WHERE dateInserted=? AND stepsTracker IS NOT NULL",new String[]{yesterdaysDate});
        int yesterdaysSteps = 0;
        if (cursor.getCount()==0){
            return "null";
        }
        else {
            while(cursor.moveToNext()){
                yesterdaysSteps = cursor.getInt(3);
            }
            return Integer.toString(yesterdaysSteps);
        }
    }

    public String getStepsGoalTrackerWeekly(){
        SQLiteDatabase db = this.getReadableDatabase();
        Calendar weeklyCalendar;
        String weeklyDate;
        weeklyCalendar = Calendar.getInstance();
        weeklyCalendar.add(Calendar.DATE,-7);
        weeklyDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(weeklyCalendar.getTime());
        Cursor cursor = db.rawQuery("Select * from goalTracking WHERE dateInserted=? AND stepsTracker IS NOT NULL",new String[]{weeklyDate});
        int weeklySteps = 0;
        if (cursor.getCount()==0){
            return "null";
        }
        else {
            while(cursor.moveToNext()){
                weeklySteps = cursor.getInt(3);
            }
            return Integer.toString(weeklySteps);
        }
    }

    public String getStepsGoalTrackerToday(){
        SQLiteDatabase db = this.getReadableDatabase();
        Calendar todaysCalendar;
        String todaysDate;
        todaysCalendar = Calendar.getInstance();
        todaysDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(todaysCalendar.getTime());
        Cursor cursor = db.rawQuery("Select * from goalTracking WHERE dateInserted=? AND stepsTracker IS NOT NULL",new String[]{todaysDate});
        int todaySteps = 0;
        if(cursor.getCount()==0){
            return "null";
        }
        else {
            while (cursor.moveToNext()) {
                todaySteps = cursor.getInt(3);
            }
        }
        return Integer.toString(todaySteps);
    }



    public boolean updateCaloriesGoal(String email, int caloriesTarget){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("calories", caloriesTarget);
        long ins = db.update("goalTargets", contentValues, "email=?",new String []{email});
        if(ins == -1)
            return false;
        else
            return true;
    }

    public boolean caloriesGoalProgress (int calorieTracker, String dateInserted){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("dateInserted",dateInserted);
        contentValues.put("caloriesTracker", calorieTracker);
        long ins = db.insert("goalTracking",null,contentValues);
        if(ins==-1)
            return false;
        else
            return true;

    }

    public String getCaloriesGoalTrackerYesterday(){
        SQLiteDatabase db = this.getReadableDatabase();
        Calendar yesterdaysCaloriesCalendar;
        String yesterdaysDate;
        yesterdaysCaloriesCalendar = Calendar.getInstance();
        yesterdaysCaloriesCalendar.add(Calendar.DATE,-1);
        yesterdaysDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(yesterdaysCaloriesCalendar.getTime());
        Cursor cursor = db.rawQuery("Select * from goalTracking WHERE dateInserted=? AND caloriesTracker IS NOT NULL",new String[]{yesterdaysDate});
        int yesterdaysCalories = 0;
        if(cursor.getCount()==0){
            return "null";
        }
        else {
            while(cursor.moveToNext()){
                yesterdaysCalories = cursor.getInt(4);
            }

        }
        return Integer.toString(yesterdaysCalories);
    }

    public String getCaloriesGoalTrackerToday(){
        SQLiteDatabase db = this.getReadableDatabase();
        Calendar todaysCalendar;
        String todaysDate;
        todaysCalendar = Calendar.getInstance();
        todaysDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(todaysCalendar.getTime());
        Cursor cursor = db.rawQuery("Select * from goalTracking WHERE dateInserted=? AND caloriesTracker IS NOT NULL",new String[]{todaysDate});
        int todayCalories = 0;
        if(cursor.getCount()==0){
            return "null";
        }
        else {
            while (cursor.moveToNext()) {
                todayCalories = cursor.getInt(3);
            }
        }
        return Integer.toString(todayCalories);
    }


    public String getCaloriesGoalTrackerWeekly(){
        SQLiteDatabase db = this.getReadableDatabase();
        Calendar weeklyCalendar;
        String weeklyDate;
        weeklyCalendar = Calendar.getInstance();
        weeklyCalendar.add(Calendar.DATE,-1);
        weeklyDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(weeklyCalendar.getTime());
        Cursor cursor = db.rawQuery("Select * from goalTracking WHERE dateInserted=? AND caloriesTracker IS NOT NULL",new String[]{weeklyDate});
        int weeklyCalories = 0;
        if(cursor.getCount()==0){
            return "null";
        }
        else {
            while(cursor.moveToNext()){
                weeklyCalories = cursor.getInt(4);
            }

        }
        return Integer.toString(weeklyCalories);
    }


    public Boolean checkemail(String email){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?", new String[]{email});
        if(cursor.getCount()>0)
            return false;
        else
            return true;
    }

    public Boolean emailpassword(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =db.rawQuery("select * from user where email=? and password=?", new String[]{email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public ArrayList<Information> getAllData(){
        ArrayList<Information> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from information", null);
        while(cursor.moveToNext())
        {
            String name = cursor.getString(1);
            int age = cursor.getInt(2);
            int height = cursor.getInt(3);
            int weight = cursor.getInt(4);
            Information information = new Information(age,height,weight,name);

            arrayList.add(information);
        }
        return arrayList;
    }


}
