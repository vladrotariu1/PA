package com.lab3.optional;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        City city = new City("Iasi");

        // Define 6 test locations
        Hotel l1 = new Hotel("International");
        Museum l2 = new Museum("Bojdeuca");
        Museum l3 = new Museum("Muzeul Unirii");
        Church l4 = new Church("Trei Ierarhi");
        Church l5 = new Church("Mitropolia");
        Restaurant l6 = new Restaurant("Salsa");


        // Define 5 LocalTime objects because only 5 of the locations are visitable
        LocalTime t1 = LocalTime.of(10, 12, 10);
        LocalTime t2 = LocalTime.of(9, 12, 10);
        LocalTime t3 = LocalTime.of(11, 12, 10);
        LocalTime t4 = LocalTime.of(12, 12, 10);
        LocalTime t5 = LocalTime.of(9, 12, 10);


        // Set the opening hour for each visitable Location
        l2.setOpeningHour(t1);
        l3.setOpeningHour(t2);
        l4.setOpeningHour(t3);
        l5.setOpeningHour(t4);
        l6.setOpeningHour(t5);


        // Add these locations to the City object
        city.addLocation(l1);
        city.addLocation(l2);
        city.addLocation(l3);
        city.addLocation(l4);
        city.addLocation(l5);
        city.addLocation(l6);


        // Add paths for the locations
        city.addPath(0, 1, 10);
        city.addPath(0, 2, 50);
        city.addPath(1, 2, 20);
        city.addPath(1, 3, 20);
        city.addPath(1, 4, 10);
        city.addPath(2, 3, 20);
        city.addPath(3, 4, 30);
        city.addPath(3, 5, 10);
        city.addPath(4, 5, 20);


        // Get the visitable and not payable Locations sorted by opening hour
        ArrayList<Location> list = city.visitableNotPayable();

        for (Location l : list) {
            System.out.println(l.getName());
        }


        // Create a travel plan and get the minimum time of the city tour
        TravelPlan tp = new TravelPlan(city, 1, 2);
        System.out.println(tp.findPath());
    }
}
