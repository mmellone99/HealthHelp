package com.example.healthhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.healthhelp.Adapters.MyCardioAdapter;
import com.example.healthhelp.Adapters.MyWeightAdapter;
import com.example.healthhelp.Model.InformationCardio;
import com.example.healthhelp.Model.InformationWeight;


import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ActivityTracker extends AppCompatActivity {
    RegistrationDatabase db;
    public static EditText e1;
    EditText e2, e3, e4, e5,e6;
    Button b1, b2,b3;
    CheckBox c1, c2,c3,c4;
    ListView l1,l2;
    ArrayList<InformationCardio> arrayCardioList;
    ArrayList<InformationWeight> arrayWeightList;
    MyCardioAdapter myCardioAdapter;
    MyWeightAdapter myWeightAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);
        db = new RegistrationDatabase(this);
        e1 = (EditText) findViewById(R.id.txtCardioExercise);
        e2 = (EditText) findViewById(R.id.txtCardioDuration);
        e3 = (EditText) findViewById(R.id.txtWeightName);
        e4 = (EditText) findViewById(R.id.txtWeightLifted);
        e5 = (EditText) findViewById(R.id.txtNumSets);
        e6 = (EditText) findViewById(R.id.txtNumReps);
        b1 = (Button) findViewById(R.id.btnCardioExercise);
        b2 = (Button) findViewById(R.id.btnWeightExercise);
        b3 = (Button) findViewById(R.id.btnHomeActTrack);
        c1 = findViewById(R.id.checkBoxBarbell);
        c2 = findViewById(R.id.checkBoxDumbbell);
        c3 = findViewById(R.id.checkBoxBodyWeight);
        c4= findViewById(R.id.checkBoxMachine);

        arrayCardioList = new ArrayList<>();

        l1 = (ListView)findViewById(R.id.listViewCardio);
        l2 = (ListView)findViewById(R.id.listViewWeight);

        loadCardioDataInListView();

        loadWeightDataInListView();


        Calendar calender = Calendar.getInstance();
        final String currentDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(calender.getTime());

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                int s2 = 0;
                s2 = Integer.parseInt(e2.getText().toString());
                if (s1.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields Empty", Toast.LENGTH_SHORT).show();
                }
                else if(s2 == 0) {
                    Toast.makeText(getApplicationContext(), "Fields Empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean insertCardioActivity = db.insertCardioActivity(s1,s2,currentDate);
                    Toast.makeText(getApplicationContext(), "Cardio Entered", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s3 = e3.getText().toString();
                int s4 = 0;
                int s5=0;
                int s6=0;
                String weightType = null;
                s4 = Integer.parseInt(e4.getText().toString());
                s5 = Integer.parseInt(e5.getText().toString());
                s6 = Integer.parseInt(e6.getText().toString());
                if (s3.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields Empty", Toast.LENGTH_SHORT).show();
                }
                else if((c1.isChecked()&&c2.isChecked()) || (c1.isChecked())&&(c3.isChecked()) || (c2.isChecked()&&c3.isChecked()) || c1.isChecked()&&c4.isChecked() ||
                        c2.isChecked()&&c4.isChecked() || c3.isChecked()&&c4.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Only Select one type", Toast.LENGTH_SHORT).show();
                }
                else if(c1.isChecked()) {
                    weightType = "Barbell";
                    Boolean insertWeightActivity = db.insertWeightActivity(s3,weightType, s4,s5,s6,currentDate);
                    Toast.makeText(getApplicationContext(), "Weight Activity Entered", Toast.LENGTH_SHORT).show();
                }
                else if(c2.isChecked()) {
                    weightType = "Dumbbell";
                    s4 = s4*2;
                    Boolean insertWeightActivity = db.insertWeightActivity(s3,weightType, s4,s5,s6,currentDate);
                    Toast.makeText(getApplicationContext(), "Weight Activity Entered", Toast.LENGTH_SHORT).show();
                }
                else if(c3.isChecked()) {
                    weightType = "Body Weight";
                    Boolean insertWeightActivity = db.insertWeightActivity(s3,weightType, s4,s5,s6,currentDate);
                    Toast.makeText(getApplicationContext(), "Weight Activity Entered", Toast.LENGTH_SHORT).show();
                }
                else if(c4.isChecked()) {
                    weightType = "Machine";
                    Boolean insertWeightActivity = db.insertWeightActivity(s3,weightType, s4,s5,s6,currentDate);
                    Toast.makeText(getApplicationContext(), "Weight Activity Entered", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityTracker.this, HomePage.class) ;
                startActivity(i);
            }
        });

    }

    private void loadWeightDataInListView() {

        arrayWeightList = db.getAllWeightData();
        myWeightAdapter = new MyWeightAdapter(this,arrayWeightList);
        l2.setAdapter(myWeightAdapter);
        myWeightAdapter.notifyDataSetChanged();
    }

    private void loadCardioDataInListView() {

        arrayCardioList = db.getAllCardioData();
        myCardioAdapter = new MyCardioAdapter(this,arrayCardioList);
        l1.setAdapter(myCardioAdapter);
        myCardioAdapter.notifyDataSetChanged();
    }

    /*private void loadWeightDataInListView() {

        arrayWeightList = db.getAllWeightData();
        myWeightAdapter = new MyWeightAdapter(this,arrayWeightList);
        l2.setAdapter(myWeightAdapter);
        myWeightAdapter.notifyDataSetChanged();
    }*/
}

