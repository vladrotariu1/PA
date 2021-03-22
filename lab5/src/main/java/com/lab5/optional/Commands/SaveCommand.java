package com.lab5.optional.Commands;

import com.lab5.compulsory.Catalog;
import com.lab5.exceptions.CatalogNotLoadedException;
import com.lab5.exceptions.InvalidParametersNumberException;
import java.io.IOException;
import static com.lab5.compulsory.CatalogUtil.save;

public class SaveCommand extends Command {

    public SaveCommand(String command) throws InvalidParametersNumberException {
        super(command);
        if(getParametersNumber() != 0)
            throw new InvalidParametersNumberException("Invalid number of parameters.");
    }

    public String execute(Catalog catalog) throws CatalogNotLoadedException {
        if (catalog == null)
            throw new CatalogNotLoadedException("First load the catalog");

        try {
            save(catalog);
            return "Catalog successfully saved";
        } catch (IOException e) {
            return e.toString();
        }
    }
}
