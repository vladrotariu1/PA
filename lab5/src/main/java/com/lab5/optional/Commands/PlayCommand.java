package com.lab5.optional.Commands;

import com.lab5.compulsory.Catalog;
import com.lab5.exceptions.CatalogNotLoadedException;
import com.lab5.exceptions.InvalidParametersNumberException;

public class PlayCommand extends Command {

    public PlayCommand(String command) throws InvalidParametersNumberException {
        super(command);
        if(getParametersNumber() != 1)
            throw new InvalidParametersNumberException("Invalid number of parameters.");
    }

    public String execute(Catalog catalog) throws CatalogNotLoadedException {
        if (catalog == null)
            throw new CatalogNotLoadedException("First load the catalog");

        int itemIndex = Integer.parseInt(getCommand().get(1));
        catalog.play(catalog.getItemList().get(itemIndex).getId());
        return "Item successfully played";
    }
}
