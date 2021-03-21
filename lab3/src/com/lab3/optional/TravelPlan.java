package com.lab3.optional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelPlan {

    private City city;
    private Location start;
    private Location finish;



    // Constructors
    public TravelPlan(City city, int start, int finish) {
        this.city = city;
        this.start = city.getLocationOfIndex(start);
        this.finish = city.getLocationOfIndex(finish);
    }


    // Apply Djikstra search algorithm to find the shortest way from start to finish
    public int findPath()
    {
        List<Integer> costLocation = new ArrayList<>();
        Map<Location , Boolean> mark = new HashMap<>();
        List<Location> locations = city.getLocations();
        int locationsNumber = city.locationsNumber();

        int indexOfStart = city.getLocations().indexOf(start);
        int indexOfFinish = city.getLocations().indexOf(finish);


        for (int i = 0; i < locationsNumber; i++)
            costLocation.add(start.costToIndex(i));


        mark.put(start , true);

        for (int i = 0; i < locationsNumber - 1; i++) {

            int minimumCost = (int)(1e9 + 10);
            int index = 0;

            for (int node = 0; node < locationsNumber; node++) {
                if (mark.get(locations.get(node)) == null && costLocation.get(node) <= minimumCost) {
                    minimumCost = costLocation.get(node);
                    index = node;
                }
            }

            mark.put(locations.get(index) , true);

            for(int node = 0 ; node < locationsNumber ; node ++) {
                if (mark.get(locations.get(node)) == null) {
                    if (costLocation.get(node) > costLocation.get(index) + locations.get(index).costToIndex(node)) {
                        costLocation.set(node, costLocation.get(index) + locations.get(index).costToIndex(node));
                    }
                }
            }
        }

        return costLocation.get(locations.indexOf(finish));
    }

}
