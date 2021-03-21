package com.lab5.optional;

import com.lab5.compulsory.Catalog;
import com.lab5.exceptions.CatalogNotLoadedException;
import com.lab5.exceptions.InvalidParametersNumberException;

public class ListCommand extends Command{

    public ListCommand(String command) throws InvalidParametersNumberException {
        super(command);
        if(getParametersNumber() != 0)
            throw new InvalidParametersNumberException("Invalid number of parameters.");
    }

    public String execute(Catalog catalog) throws CatalogNotLoadedException {
        if (catalog == null)
            throw new CatalogNotLoadedException("First load the catalog");

        return catalog.list();
    }
}
