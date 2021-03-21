package com.lab4.compulsory;


public class School implements Comparable<School>{

    private String name;
    private int capacity;

    public School(String name) {
        this.name = name;
        this.capacity = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(School other) {
        return this.name.compareTo(other.name);
    }
}

