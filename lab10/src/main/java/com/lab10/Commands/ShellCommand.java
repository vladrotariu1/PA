package com.lab10.Commands;

import java.util.ArrayList;

public abstract class ShellCommand {
    private final ArrayList<String> parameters;

    public ShellCommand(ArrayList<String> parameters) {
        this.parameters = parameters;
    }

    public ArrayList<String> getParameters() {
        return parameters;
    }
}
