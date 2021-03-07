package com.lab3.compulsory;

import java.time.LocalTime;
import java.util.HashMap;

public class Restaurant extends Location implements Payable, Classifiable, Visitable{

    private LocalTime openingHour;
    private LocalTime closingHour;
    private String specific;
    private HashMap<String, Integer> Menu;
    private float rank;



    //Constructors
    public Restaurant() {
        super();
    }

    public Restaurant(String name) {
        super(name);
    }


    // Setters
    public void setOpeningHour(LocalTime openingHour) {
        this.openingHour = openingHour;
    }

    public void setClosingHour(LocalTime closingHour) {
        this.closingHour = closingHour;
    }

    public void setSpecific(String specific) {
        this.specific = specific;
    }

    public void setMenu(HashMap<String, Integer> menu) {
        Menu = menu;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }


    // Getters
    @Override
    public LocalTime getOpeningHour() {
        return openingHour;
    }

    @Override
    public LocalTime getClosingHour() {
        return closingHour;
    }

    public String getSpecific() {
        return specific;
    }

    public HashMap<String, Integer> getMenu() {
        return Menu;
    }

    @Override
    public float getRank() {
        return rank;
    }

    // Get the median price(in $) that people pay for a meal at this restaurant
    @Override
    public float getPrice() {
        return 17.8f;
    }
}
