package com.lab8.compulsory.models;

public class Actor {
    private int id;
    private String name;

    public Actor(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Actor() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
