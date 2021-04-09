package com.lab7.compulsory;

import java.util.Random;

public class Token {
    private int position1, position2, value;
    public Token(int position1, int position2) {
        this.position1 = position1;
        this.position2 = position2;
        Random randomValue = new Random();
        this.value = randomValue.nextInt(100) + 1;
    }

    public int getPosition1() {
        return position1;
    }

    public void setPosition1(int position1) {
        this.position1 = position1;
    }

    public int getPosition2() {
        return position2;
    }

    public void setPosition2(int position2) {
        this.position2 = position2;
    }

    public int getValue() {
        return value;
    }
}
