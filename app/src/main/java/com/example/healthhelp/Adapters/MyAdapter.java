package com.example.healthhelp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.healthhelp.Model.InformationGoals;
import com.example.healthhelp.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<InformationGoals> arrayList;

    public MyAdapter(Context context,ArrayList<InformationGoals> arrayList)
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
        convertView = inflater.inflate(R.layout.mycustomlistview,null);
        TextView t1_weightTarget=(TextView)convertView.findViewById(R.id.weightTarget_txt);
        TextView t2_water=(TextView)convertView.findViewById(R.id.water_txt);
        TextView t3_steps=(TextView)convertView.findViewById(R.id.steps_txt);
        TextView t4_calories=(TextView)convertView.findViewById(R.id.calories_txt);
        TextView t5_sleep=(TextView)convertView.findViewById(R.id.sleep_txt);




        InformationGoals information = arrayList.get(position);


        t1_weightTarget.setText("Weight Goal: "+String.valueOf(information.getWeightTarget())+" lbs");
        t2_water.setText("Hydration Goal: "+String.valueOf(information.getWater())+" cups");
        t3_steps.setText("Steps Goal: "+String.valueOf(information.getSteps())+" steps");
        t4_calories.setText("Calorie Goal: "+String.valueOf(information.getCalories())+" cals");
        t5_sleep.setText("Sleep Goal: "+String.valueOf(information.getSleep())+" hrs");


        return convertView;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }
}

