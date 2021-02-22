package com.lab2.compulsory;

public class Destination {

    // Class members

    private String name;
    private int demand;


    // Class methods

    public Destination(String name, int demand) {
        this.name = name;
        this.demand = demand;
    }

    /*
    * Getters
    * */
    public String getName() {
        return name;
    }

    public int getDemand() {
        return demand;
    }

    /*
    * Setters
    * */
    public void setName(String name) {
        this.name = name;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                '}';
    }
}
