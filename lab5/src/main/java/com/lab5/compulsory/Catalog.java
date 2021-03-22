package com.lab5.compulsory;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.awt.Desktop;

public class Catalog implements Serializable {

    private List<Item> itemList;
    private String path;

    public Catalog(String path) {
        this.path = path;
    }

    public Catalog(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    // Add new item to the catalog
    public void add(Item i) {
        this.itemList.add(i);
    }

    // Print the content of the catalog
    public String list() {
        StringBuilder s = new StringBuilder();
        for (Item item : itemList) {
            s.append(item.toString());
            s.append('\n');
        }
        return s.toString();
    }

    public Item findById(UUID id) {
        return itemList.stream()
                .filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }

    // Open file using the native operating system application
    public void play(UUID id) {
        String pathToItem = findById(id).getPath();
        try {
            Desktop.getDesktop().open(new File(pathToItem));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
