package com.lab5.optional;

import com.lab5.compulsory.Catalog;
import com.lab5.exceptions.*;
import com.lab5.optional.Commands.*;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.Scanner;

public class Shell {

    private final static String shellSign = "~$";
    private final static Scanner in = new Scanner(System.in);
    private static Catalog catalog = null;

    private static String enterShellCommand() {
        return in.nextLine();
    }

    private static String getCommandResult(String shellCommand) {
        Command command;

        switch(shellCommand.split(" ")[0]) {

            case "load":

                try {
                    command = new LoadCommand(shellCommand);
                    catalog = ((LoadCommand) command).execute();
                    return "Catalog successfully loaded";
                } catch (InvalidParametersNumberException e) {
                    return e.toString();
                }

            case "save":

                try {
                    command = new SaveCommand(shellCommand);
                    return ((SaveCommand) command).execute(catalog);
                } catch (InvalidParametersNumberException | CatalogNotLoadedException e) {
                    return e.toString();
                }

            case "play":

                try {
                    command = new PlayCommand(shellCommand);
                    return ((PlayCommand) command).execute(catalog);
                } catch (InvalidParametersNumberException | CatalogNotLoadedException e) {
                    return e.toString();
                }

            case "add":

                try {
                    command = new AddCommand(shellCommand);
                    catalog = ((AddCommand) command).execute(catalog);
                    return "Successfully added new item";
                } catch (InvalidParametersNumberException | CatalogNotLoadedException | InvalidMp3FileException | InvalidImageFileException e) {
                    return e.toString();
                }

            case "list":

                try {
                    command = new ListCommand(shellCommand);
                    return ((ListCommand) command).execute(catalog);
                } catch (InvalidParametersNumberException | CatalogNotLoadedException e) {
                    return e.toString();
                }

            case "info":

                try {
                    command = new InfoCommand(shellCommand);
                    return ((InfoCommand) command).execute(catalog);
                } catch (InvalidParametersNumberException | CatalogNotLoadedException | TikaException | IOException | SAXException e) {
                    return e.toString();
                }

            default:
                return "Unrecognised command";
        }
    }

    public static void shell() {
        System.out.print(shellSign);
        String command = enterShellCommand();
        String commandResult = getCommandResult(command);
        System.out.println(commandResult);
    }
}
