package com.lab5.bonus;

import com.lab5.compulsory.Catalog;
import com.lab5.compulsory.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private Catalog catalog;
    private HashMap<Item, Item> graph;

    public Graph(Catalog catalog) {
        this.catalog = catalog;
        graph = new HashMap<>(10);
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    // Checks if 2 objects have common attributes
    private boolean commonMembers(Item i1, Item i2) {
        if (i1.getClass() != i2.getClass())
            return false;

        HashMap<String, String> state1 = i1.getState();
        HashMap<String, String> state2 = i2.getState();

        for (HashMap.Entry<String, String> pair : state1.entrySet()) {
            if (state1.get(pair.getKey()).equals(state2.get(pair.getKey())))
                return true;
        }

        return false;
    }

    // Generates the graph that connects 2 items if they share common features
    public void generateGraph() {
        ArrayList<Item> items = (ArrayList<Item>) catalog.getItemList();
        for (Item item1 : items)
            for (Item item2 : items) {
                if (commonMembers(item1, item2) && !(item1 == item2))
                    graph.put(item1, item2);
            }
    }

    public ArrayList<Item> createPlaylist() {
        ArrayList<Item> items = (ArrayList<Item>) catalog.getItemList();
        ArrayList<Item> playlist = new ArrayList<>(10);

        for (Item item : items)
            if (!playlist.contains(item) && (!notInPlaylist(item) || playlist.isEmpty())) {
                playlist.add(item);
            }
        return playlist;
    }

    // Checks if item is a vertex of another graph vertex
    private boolean notInPlaylist(Item item) {
        for (HashMap.Entry<Item, Item> pair : graph.entrySet())
            if (pair.getValue().equals(item))
                return false;
        return true;
    }
}
