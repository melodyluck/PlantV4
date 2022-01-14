package com.example.plantv4;

public class Plant {
    private int imagePlant;
    private String name, water, light, temperature;

    public Plant (int imagePlant, String name, String water, String light, String temperature){
        this.imagePlant = imagePlant;
        this.name = name;
        this.water = water;
        this.light = light;
        this.temperature = temperature;
    }

    public int getImagePlant(){
       return imagePlant;
    }

    public String getName(){
        return name;
    }

    public String getWater(){
        return water;
    }

    public String getLight(){
        return light;
    }

    public String getTemperature(){
        return temperature;
    }


}
