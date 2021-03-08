package com.lab3.compulsory;

import java.time.LocalTime;

public class Museum extends Location implements Visitable, Classifiable, Payable {

    private LocalTime openingHour;
    private LocalTime closingHour;
    private String type;
    private float entryFee;
    private float rank;



    //Constructors
    public Museum() {
        super();
    }

    public Museum(String name) {
        super(name);
    }


    // Setters
    public void setOpeningHour(LocalTime openingHour) {
        this.openingHour = openingHour;
    }

    public void setClosingHour(LocalTime closingHour) {
        this.closingHour = closingHour;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEntryFee(float entryFee) {
        this.entryFee = entryFee;
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

    public String getType() {
        return type;
    }

    @Override
    public float getPrice() {
        return entryFee;
    }

    @Override
    public float getRank() {
        return rank;
    }
}
