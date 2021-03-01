package com.lab3.compulsory;

public class Hotel extends Location implements Classifiable, Payable {

    /* Class members */
    private float rank;
    private float roomPrice;


    /* Class methods */

    public Hotel() {
        rank = rank();
        roomPrice = price();
    }


    // Setters
    public void setRank(float rank) {
        this.rank = rank;
    }

    public void setRoomPrice(float roomPrice) {
        this.roomPrice = roomPrice;
    }


    // Getters
    public float getRank() {
        return rank;
    }

    public float getRoomPrice() {
        return roomPrice;
    }


    // Calculate price for hotel room
    @Override
    public float price() {
        return 100.50f;
    }


    // Calculate the rank of this location
    @Override
    public float rank() {
        return 5f;
    }
}
