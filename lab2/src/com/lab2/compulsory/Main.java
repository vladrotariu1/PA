package com.lab2.compulsory;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        int sourceNumber = 3;
        int destinationNumber = 3;

        // Create suppliers and demanders data structures and add objects
        Vector<Source> suppliers = new Vector<>(sourceNumber);
        Vector<Destination> demanders = new Vector<>(destinationNumber);

        suppliers.add(new Source("Nike", 1, 10));
        suppliers.add(new Source("Amazon", 0, 35));
        suppliers.add(new Source("E-Mag"    , 0, 25));

        demanders.add(new Destination("BuzzSneakers", 20));
        demanders.add(new Destination("SneakerStudio", 25));
        demanders.add(new Destination("Sizeer", 25));

        // Create the problem object and fill in the cost matrix
        Problem p = new Problem(sourceNumber, destinationNumber, suppliers, demanders);
        p.setCost(0, 0, 2);
        p.setCost(0, 1, 3);
        p.setCost(0, 2, 1);
        p.setCost(1, 0, 5);
        p.setCost(1, 1, 4);
        p.setCost(1, 2, 8);
        p.setCost(2, 0, 5);
        p.setCost(2, 1, 6);
        p.setCost(2, 2, 8);

        // Print the cost matrix
        System.out.println(p);

    }
}
