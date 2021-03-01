package com.lab3.compulsory;

import java.util.ArrayList;

public class City {

    /* Class members */

    private String name;
    private ArrayList<Location> locations;


    /* Class methods */

    // Constructors
    public City() {
        locations = new ArrayList<>(10);
    }

    public City(String name) {
        locations = new ArrayList<>(10);
        this.name = name;
    }


    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }


    // Getters
    public String getName() {
        return name;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }


    // Add new location in array list
    public void addLocation(Location location) {
        locations.add(location);
    }


    // Get the number of locations in the city
    public int locationsNumber() {
        return locations.size();
    }


    // Add path from location 'a' to location 'b'
    public void addPath(int locA, int locB, int cost) {
        Location updatedLocation = locations.get(locA);
        updatedLocation.addPath(locB, cost);
        locations.set(locA, updatedLocation);
    }
}
