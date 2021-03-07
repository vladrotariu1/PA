package com.lab3.compulsory;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        City city = new City("Iasi");

        city.addLocation(new Hotel("International"));
        city.addLocation(new Museum("Bojdeuca"));
        city.addLocation(new Museum("Muzeul Unirii"));
        city.addLocation(new Church("Trei Ierarhi"));
        city.addLocation(new Church("Mitropolia"));
        city.addLocation(new Restaurant("Salsa"));

        city.addPath(0, 1, 10);
        city.addPath(0, 2, 50);
        city.addPath(1, 2, 20);
        city.addPath(1, 3, 20);
        city.addPath(1, 4, 10);
        city.addPath(2, 3, 20);
        city.addPath(3, 4, 30);
        city.addPath(3, 5, 10);
        city.addPath(4, 5, 20);

        city.showPaths();
    }
}
