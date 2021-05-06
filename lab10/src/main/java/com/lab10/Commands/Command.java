package com.lab10.Commands;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Command implements Serializable {
    private String command;
    private ArrayList<String> arguments;

    public Command(String command) {
        ArrayList<String> splittedCommand = new ArrayList<>(Arrays.asList(command.split(" ")));
        this.command = splittedCommand.remove(0);
        this.arguments = splittedCommand;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public ArrayList<String> getArguments() {
        return arguments;
    }

    public void setArguments(ArrayList<String> arguments) {
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        return "Command{" +
                "command='" + command + '\'' +
                ", arguments=" + arguments +
                '}';
    }
}
