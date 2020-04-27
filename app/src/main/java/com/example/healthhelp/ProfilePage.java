package com.example.healthhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.healthhelp.Adapters.MyProfileAdapter;
import com.example.healthhelp.Model.Information;

import java.util.ArrayList;

public class ProfilePage extends AppCompatActivity {
    ListView l1;
    ArrayList<Information> arrayList;
    RegistrationDatabase db;
    MyProfileAdapter myAdapter;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        db = new RegistrationDatabase(this);
        arrayList = new ArrayList<>();
        b1 = (Button) findViewById(R.id.btnProfileHome);
        l1 = (ListView)findViewById(R.id.listViewProfile);
        loadDataInProfileListView();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfilePage.this, HomePage.class) ;
                startActivity(i);
            }
        });
    }

    private void loadDataInProfileListView() {
        arrayList = db.getAllData();
        myAdapter = new MyProfileAdapter(this,arrayList);
        l1.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

}
