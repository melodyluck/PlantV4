package com.example.plantv4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MyPlantActivity extends AppCompatActivity {
    static ArrayList<Plant> plantHave = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_plant);

        ListView lvPlant = findViewById(R.id.lvPlant);
        SearchView svPlant = findViewById(R.id.svPlant);
        Plant rubberPlant = new Plant(R.mipmap.ic_rubber_plant_list,
                                    "Name:Rubber Plant",
                                    "Water:Once a Week",
                                    "Light:Medium Light",
                                    "Temperature:15-20");

        Plant fiddleFig = new Plant(R.mipmap.ic_fiddle_fig_list,
                                    "Name:Fiddle Fig",
                                    "Water:Every two Weeks",
                                    "Light:Bright Light",
                                    "Temperature:17-22");
        Plant pothos = new Plant(R.mipmap.ic_pothos_foreground,
                                    "Name:Pothos",
                                    "Water:Once a Week",
                                    "Light:Low Light",
                                    "Temperature:20-25");

        ArrayList<Plant> plantList = new ArrayList<>();
        plantList.add(rubberPlant);
        plantList.add(fiddleFig);
        plantList.add(pothos);

        PlantAdapter adapter = new PlantAdapter(this, R.layout.custom_listview, plantList);
        lvPlant.setAdapter(adapter);

        lvPlant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                plantHave.add(plantList.get(i));
                PlantFragment.adapter.notifyDataSetChanged();

                Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_LONG).show();
            }
        });

        //SearchView svPlant = findViewById(R.id.svPlant);
        svPlant.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Plant> result = new ArrayList<>();
                for(int i = 0; i < plantList.size(); i++){
                    if(plantList.get(i).getName().toUpperCase().contains(newText.toUpperCase())
                        ||plantList.get(i).getWater().toUpperCase().contains(newText.toUpperCase())
                        || plantList.get(i).getLight().toUpperCase().contains(newText.toUpperCase())
                        ||plantList.get(i).getTemperature().toUpperCase().contains(newText.toUpperCase())){
                        result.add(plantList.get(i));
                    }
                }

                PlantAdapter adapter = new PlantAdapter(MyPlantActivity.this, R.layout.custom_listview, result);
                lvPlant.setAdapter(adapter);
                //((PlantAdapter) lvPlant.getAdapter()).update(result);

                return false;
            }
        });

    }


}