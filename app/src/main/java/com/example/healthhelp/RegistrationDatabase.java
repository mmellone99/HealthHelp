package com.example.healthhelp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.healthhelp.Model.Information;

import java.util.ArrayList;

public class RegistrationDatabase extends SQLiteOpenHelper {
    public RegistrationDatabase(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key , password text)");
        db.execSQL("Create table information(email text primary key, name text, age int, height int, weight int, gender text)");
        db.execSQL("Create table goalTargets (email text primary key, weightTarget int, water int, steps int, calories int, sleep int)");
        db.execSQL("Create table goalTracking (email text primary key, weightTracker int, waterTracker int, stepsTracker int, caloriesTracker int, sleepTracker int)");
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

    public boolean weightGoalProgress (int weightTracker){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("weightTracker", weightTracker);
        long ins = db.insert("goalTracking",null,contentValues);
        if(ins==-1)
            return false;
        else
            return true;
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
