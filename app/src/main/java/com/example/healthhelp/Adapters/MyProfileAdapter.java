package com.example.healthhelp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.healthhelp.Model.Information;
import com.example.healthhelp.R;

import java.util.ArrayList;

public class MyProfileAdapter extends BaseAdapter {

    Context context;
    ArrayList<Information> arrayList;

    public MyProfileAdapter(Context context,ArrayList<Information> arrayList)
    {
        this.context = context;
        this.arrayList=arrayList;
    }
    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public Object getItem(int position){
        return arrayList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.myprofilelistview,null);
        TextView t1_name=(TextView)convertView.findViewById(R.id.name_txt_profile);
        TextView t2_age=(TextView)convertView.findViewById(R.id.age_txt);
        TextView t3_height=(TextView)convertView.findViewById(R.id.height_txt);
        TextView t4_weight=(TextView)convertView.findViewById(R.id.weight_txt);

        Information information = arrayList.get(position);

        t1_name.setText("Name: "+information.getName());
        t2_age.setText("Age: "+String.valueOf(information.getAge())+" years");
        int inchesTotal = information.getHeight();
        int feet = information.getHeight()/12;
        int inchesLeft = inchesTotal-(feet*12);
        t3_height.setText("Height: "+String.valueOf(information.getHeight())+" inches ("+String.valueOf(feet)+" feet "+inchesLeft+" inches)");
        t4_weight.setText("Weight: "+String.valueOf(information.getWeight())+" lbs");

        return convertView;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }
}
