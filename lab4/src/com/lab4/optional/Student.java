package com.lab4.optional;

import java.util.Comparator;


public class Student implements Comparator<Student> {

    private String name;
    private float score;
    private School assigned;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, float score) {
        this.name = name;
        this.score = score;
    }

    public School getAssigned() {
        return assigned;
    }

    public void setAssigned(School assigned) {
        this.assigned = assigned;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

