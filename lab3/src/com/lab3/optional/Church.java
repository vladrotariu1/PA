package com.lab3.optional;

import java.time.LocalTime;

public class Church extends Location implements Visitable, Classifiable {

    private LocalTime openingHour;
    private LocalTime closingHour;
    private String religion;
    private float rank;



    //Constructors
    public Church() {
        super();
    }

    public Church(String name) {
        super(name);
    }


    // Setters
    public void setOpeningHour(LocalTime openingHour) {
        this.openingHour = openingHour;
    }

    public void setClosingHour(LocalTime closingHour) {
        this.closingHour = closingHour;
    }

    public void setReligion(String religion) {
        this.religion = religion;
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

    public String getReligion() {
        return religion;
    }

    @Override
    public float getRank() {
        return rank;
    }
}
