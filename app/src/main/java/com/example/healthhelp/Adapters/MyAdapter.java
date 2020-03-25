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

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<Information> arrayList;

    public MyAdapter(Context context,ArrayList<Information> arrayList)
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
            TextView t1_name=(TextView)convertView.findViewById(R.id.name_txt);
            TextView t2_age=(TextView)convertView.findViewById(R.id.age_txt);
            TextView t3_height=(TextView)convertView.findViewById(R.id.height_txt);
            TextView t4_weight=(TextView)convertView.findViewById(R.id.weight_txt);



            Information information = arrayList.get(position);


            t1_name.setText(information.getName());
            t2_age.setText(String.valueOf(information.getAge()));
            t3_height.setText(String.valueOf(information.getHeight()));
            t4_weight.setText(String.valueOf(information.getWeight()));

        return convertView;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }
}
