package com.lab2.compulsory;

import java.util.Arrays;
import java.util.Vector;

public class Problem {

    // Class members

    int sourceNumber;
    int destinationNumber;
    int[][] cost;
    Vector<Source> suppliers;
    Vector<Destination> demanders;


    // Class methods

    /*
    * Constructor
    * */
    public Problem(int sourceNumber, int destinationNumber, Vector<Source> suppliers, Vector<Destination> demanders) {
        this.sourceNumber = sourceNumber;
        this.destinationNumber = destinationNumber;
        this.cost = new int[sourceNumber][destinationNumber];
        this.suppliers = suppliers;
        this.demanders = demanders;
    }

    /*
    * Getters
    * */
    public int getSourceNumber() {
        return sourceNumber;
    }

    public int getDestinationNumber() {
        return destinationNumber;
    }

    public int[][] getCostMatrix() {
        return cost;
    }

    /*
    * Setters
    * */
    public void setSourceNumber(int sourceNumber) {
        this.sourceNumber = sourceNumber;
    }

    public void setDestinationNumber(int destinationNumber) {
        this.destinationNumber = destinationNumber;
    }

    public void setCost(int i, int j, int cost) {
        this.cost[i][j] = cost;
    }

    @Override
    public String toString() {
        String matrixDisplay = "";

        for (int i = 0; i < sourceNumber; i++) {
            for (int j = 0; j < destinationNumber; j++) {
                matrixDisplay += cost[i][j] + " ";
            }
            matrixDisplay += "\n";
        }

        return matrixDisplay;
    }
}
