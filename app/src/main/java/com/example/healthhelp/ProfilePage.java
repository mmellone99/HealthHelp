package com.example.healthhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.healthhelp.Adapters.MyProfileAdapter;
import com.example.healthhelp.Model.Information;

import java.util.ArrayList;

public class ProfilePage extends AppCompatActivity {
    ListView l1;
    ArrayList<Information> arrayList;
    RegistrationDatabase db;
    MyProfileAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        db = new RegistrationDatabase(this);
        arrayList = new ArrayList<>();
        l1 = (ListView)findViewById(R.id.listViewProfile);
        loadDataInProfileListView();
    }

    private void loadDataInProfileListView() {
        arrayList = db.getAllData();
        myAdapter = new MyProfileAdapter(this,arrayList);
        l1.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

}
