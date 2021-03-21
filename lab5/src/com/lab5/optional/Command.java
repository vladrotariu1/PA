package com.lab5.optional;

import com.lab5.compulsory.Catalog;
import com.lab5.exceptions.CatalogNotLoadedException;
import com.lab5.exceptions.InvalidCatalogException;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Command {

    private ArrayList<String> command;

    public Command(String command) {
        this.command = new ArrayList<String>(Arrays.asList(command.split(" ")));
    }

    protected ArrayList<String> getCommand() {
        return command;
    }

    protected int getParametersNumber() {
        return command.size() - 1;
    }
}
