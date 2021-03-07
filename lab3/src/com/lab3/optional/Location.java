package com.lab3.optional;

import java.util.HashMap;

public abstract class Location implements Comparable<Location> {

    private String name;
    private String description;
    private float[] coordinates;
    private HashMap<Integer, Integer> map;



    // Constructors
    public Location() {
        map = new HashMap<>(10);
        coordinates = new float[2];
    }

    public Location(String name) {
        map = new HashMap<>(10);
        coordinates = new float[2];
        this.name = name;
    }


    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMap(HashMap<Integer, Integer> map) {
        this.map = map;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCoordinates(float[] coordinates) {
        this.coordinates = coordinates;
    }

    public void setCoordinates(float latitude, float longitude) {
        this.coordinates[0] = latitude;
        this.coordinates[1] = longitude;
    }


    // Getters
    public String getName() {
        return name;
    }

    public HashMap<Integer, Integer> getMap() {
        return map;
    }

    public String getDescription() {
        return description;
    }

    public float[] getCoordinates() {
        return coordinates;
    }


    // Add element to map
    public void addPath(int destination, int cost) {
        map.put(destination, cost);
    }


    @Override
    public int compareTo(Location other) {
        if (other instanceof Visitable && this instanceof Visitable) {
            return ((Visitable) this).getOpeningHour().compareTo(((Visitable) other).getOpeningHour());
        } else {
            throw new ClassCastException ("Uncomparable objects!");
        }
    }
}
