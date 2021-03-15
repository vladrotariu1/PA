package com.lab5.compulsory;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<MultimediaItem> catalog = new ArrayList<>();

    public void add(MultimediaItem item) {
        catalog.add(item);
    }

    public List<MultimediaItem> list() {
        return catalog;
    }
}
