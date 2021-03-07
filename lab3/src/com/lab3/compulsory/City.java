package com.lab3.compulsory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class City {

    private String name;
    private ArrayList<Location> locations;



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


    // Print the paths
    public void showPaths() {
        for (int i = 0; i < locations.size(); i++) {

            Location location = locations.get(i);
            HashMap<Integer, Integer> map = location.getMap();

            for (HashMap.Entry entry : map.entrySet()) {
                System.out.println(i + " -> " + entry.getKey() + " cost : " + entry.getValue() + "\n");
            }
        }
    }
}
