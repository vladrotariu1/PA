package com.lab5.optional.Commands;

import com.lab5.compulsory.Catalog;
import com.lab5.exceptions.InvalidCatalogException;
import com.lab5.exceptions.InvalidParametersNumberException;

import static com.lab5.compulsory.CatalogUtil.load;

public class LoadCommand extends Command {

    public LoadCommand(String command) throws InvalidParametersNumberException {
        super(command);
        if(getParametersNumber() != 1)
            throw new InvalidParametersNumberException("Invalid number of parameters.");
    }

    public Catalog execute() {
        try {
            return load(getCommand().get(1));
        } catch (InvalidCatalogException e) {
            e.printStackTrace();
        }
        return null;
    }

}
