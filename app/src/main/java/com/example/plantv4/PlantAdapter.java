package com.example.plantv4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PlantAdapter extends ArrayAdapter<Plant> {

    //private Context mContext;
    public PlantAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Plant> objects) {
        super(context, resource, objects);
        // mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_listview, parent, false);
        }

        ImageView ivPlant = convertView.findViewById(R.id.ivPlant);
        ivPlant.setImageResource(getItem(position).getImagePlant());

        TextView tvName = convertView.findViewById(R.id.tvName);
        tvName.setText( getItem(position).getName());

        TextView tvWater = convertView.findViewById(R.id.tvWater);
        tvWater.setText(getItem(position).getWater());

        TextView tvLight = convertView.findViewById(R.id.tvLight);
        tvLight.setText(getItem(position).getLight());

        TextView tvTemperature = convertView.findViewById(R.id.tvTemperature);
        tvTemperature.setText(getItem(position).getTemperature());

        /*Button btnAddPlant = convertView.findViewById(R.id.btnAddPlant);
        btnAddPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/


        return convertView;

        //return super.getView(position, convertView, parent);
    }


}
