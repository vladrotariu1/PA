package com.lab5.compulsory;

import java.io.Serializable;
import java.util.*;

public abstract class Item implements Serializable {

    private UUID id;
    private String path;
    private Date date;

    public Item(String path) {
        id = UUID.randomUUID();
        this.path = path;
    }

    public UUID getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public Date getDate() {
        return date;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return path;
    }
}
