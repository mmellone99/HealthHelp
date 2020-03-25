package com.example.healthhelp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthhelp.Adapters.MyAdapter;
import com.example.healthhelp.Model.Information;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class HomePage extends AppCompatActivity {
    RegistrationDatabase db;
    Button b1,b2,b3,b4,b5;
    ListView l1;
    ArrayList<Information> arrayList;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Calendar calender = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calender.getTime());
        TextView textViewDate= findViewById(R.id.textViewDate);
        textViewDate.setText(currentDate);

        db = new RegistrationDatabase(this);

        b1=(Button)findViewById(R.id.btnLogout);
        b2=(Button)findViewById(R.id.btnProfilePage);
        b3=(Button)findViewById(R.id.btnEditGoals);
        b4=(Button)findViewById(R.id.btnActivityTrackingPage);
        b5=(Button)findViewById(R.id.btnGoalTracker);


        arrayList = new ArrayList<>();

        l1 = (ListView)findViewById(R.id.listView);

        loadDataInListView();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(HomePage.this, Login.class) ;
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(HomePage.this, ProfilePage.class) ;
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(HomePage.this, NewUserGoals.class) ;
                startActivity(i);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(HomePage.this, ActivityTracker.class) ;
                startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(HomePage.this, GoalTracker.class) ;
                startActivity(i);
            }
        });
    }

    private void loadDataInListView() {

        arrayList = db.getAllData();
        myAdapter = new MyAdapter(this,arrayList);
        l1.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

}
