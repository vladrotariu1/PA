package com.lab3.compulsory;

import java.time.LocalTime;

public class Church implements Visitable, Classifiable{

    /* Class members */
    private LocalTime openingHour;
    private LocalTime closingHour;
    private float rank;


    /* Class methods */

    public Church() {
        openingHour = calcOpeningHour();
        closingHour = calcClosingHour();
    }


    // Setters
    public void setOpeningHour(LocalTime openingHour) {
        this.openingHour = openingHour;
    }

    public void setClosingHour(LocalTime closingHour) {
        this.closingHour = closingHour;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }


    // Getters
    public LocalTime getOpeningHour() {
        return openingHour;
    }

    public LocalTime getClosingHour() {
        return closingHour;
    }

    public float getRank() {
        return rank;
    }


    @Override
    public LocalTime calcClosingHour() {
        return LocalTime.of(20, 30, 0);
    }

    @Override
    public LocalTime calcOpeningHour() {
        return LocalTime.of(10, 30, 0);
    }

    // Calculate the rank of this location
    @Override
    public float rank() {
        return 5f;
    }
}
