package com.lab3.optional;

import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        City city = new City("Iasi");

        Hotel l1 = new Hotel("International");
        Museum l2 = new Museum("Bojdeuca");
        Museum l3 = new Museum("Muzeul Unirii");
        Church l4 = new Church("Trei Ierarhi");
        Church l5 = new Church("Mitropolia");
        Restaurant l6 = new Restaurant("Salsa");

        LocalTime t1 = LocalTime.of(10, 12, 10);
        LocalTime t2 = LocalTime.of(9, 12, 10);
        LocalTime t3 = LocalTime.of(11, 12, 10);
        LocalTime t4 = LocalTime.of(12, 12, 10);
        LocalTime t5 = LocalTime.of(9, 12, 10);

        l2.setOpeningHour(t1);
        l3.setOpeningHour(t2);
        l4.setOpeningHour(t3);
        l5.setOpeningHour(t4);
        l6.setOpeningHour(t5);

        city.addLocation(l1);
        city.addLocation(l2);
        city.addLocation(l3);
        city.addLocation(l4);
        city.addLocation(l5);
        city.addLocation(l6);

        ArrayList<Location> list = city.visitableNotPayable();

        for (Location l : list) {
            System.out.println(l.getName());
        }

    }
}
