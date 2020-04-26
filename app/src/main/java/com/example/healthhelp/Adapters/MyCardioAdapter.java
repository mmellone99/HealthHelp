package com.example.healthhelp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.healthhelp.Model.InformationCardio;
import com.example.healthhelp.R;

import java.util.ArrayList;
import java.util.Date;

public class MyCardioAdapter extends BaseAdapter {

    Context context;
    ArrayList<InformationCardio> arrayList;

    public MyCardioAdapter(Context context,ArrayList<InformationCardio> arrayList)
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
        convertView = inflater.inflate(R.layout.mycardiolistview,null);
        TextView t1_cardioExerciseName=(TextView)convertView.findViewById(R.id.cardioExerciseName_txt);
        TextView t2_cardioDuration=(TextView)convertView.findViewById(R.id.cardioDuration_txt);
        TextView t3_dateInserted=(TextView)convertView.findViewById(R.id.dateCardioCompleted_txt);

        InformationCardio information = arrayList.get(position);

        t1_cardioExerciseName.setText(information.getCardioExerciseName());
        t2_cardioDuration.setText(String.valueOf(information.getCardioDuration())+" mins");
        t3_dateInserted.setText(information.getDateCardioCompleted());



        return convertView;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }
}
