package com.example.healthhelp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.healthhelp.Model.InformationWeight;
import com.example.healthhelp.R;

import java.util.ArrayList;
import java.util.Date;

public class MyWeightAdapter extends BaseAdapter {

    Context context;
    ArrayList<InformationWeight> arrayList;

    public MyWeightAdapter(Context context,ArrayList<InformationWeight> arrayList)
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
        convertView = inflater.inflate(R.layout.myweightlistview,null);
        TextView t1_exerciseWeightName=(TextView)convertView.findViewById(R.id.weightExerciseName_txt);
        TextView t2_weightType=(TextView)convertView.findViewById(R.id.weightType_txt);
        TextView t3_weightLifted=(TextView)convertView.findViewById(R.id.weightLifted_txt);
        TextView t4_numberSets=(TextView)convertView.findViewById(R.id.numberSets_txt);
        TextView t5_numberReps=(TextView)convertView.findViewById(R.id.numberReps_txt);

        InformationWeight information = arrayList.get(position);

        t1_exerciseWeightName.setText(information.getExerciseWeightName());
        t2_weightType.setText(information.getWeightType());
        t3_weightLifted.setText(String.valueOf(information.getWeightLifted())+" lbs");
        t4_numberSets.setText(String.valueOf(information.getNumberSets())+" sets");
        t5_numberReps.setText(String.valueOf(information.getNumberReps())+" reps");

        return convertView;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }
}
