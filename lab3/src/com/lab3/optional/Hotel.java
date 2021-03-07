package com.lab3.optional;

public class Hotel extends Location implements Classifiable, Payable {

    private int roomPrice;
    private float rank;



    //Constructors
    public Hotel() {
        super();
    }

    public Hotel(String name) {
        super(name);
    }


    // Setters
    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }


    // Getters
    @Override
    public float getPrice() {
        return roomPrice;
    }

    @Override
    public float getRank() {
        return rank;
    }
}
