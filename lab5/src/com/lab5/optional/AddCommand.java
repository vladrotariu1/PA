package com.lab5.optional;

import com.lab5.compulsory.Catalog;
import com.lab5.compulsory.Image;
import com.lab5.compulsory.Song;
import com.lab5.exceptions.CatalogNotLoadedException;
import com.lab5.exceptions.InvalidImageFileException;
import com.lab5.exceptions.InvalidMp3FileException;
import com.lab5.exceptions.InvalidParametersNumberException;

public class AddCommand extends Command{
    public AddCommand(String command) throws InvalidParametersNumberException {
        super(command);
        if(getParametersNumber() != 2)
            throw new InvalidParametersNumberException("Invalid number of parameters.");
    }

    public Catalog execute(Catalog catalog) throws CatalogNotLoadedException, InvalidMp3FileException, InvalidImageFileException {
        if (catalog == null)
            throw new CatalogNotLoadedException("First load the catalog");

        if (getCommand().get(1).toLowerCase().equals("song"))
            catalog.add(new Song(getCommand().get(2)));
        else if (getCommand().get(1).toLowerCase().equals("image"))
            catalog.add(new Image(getCommand().get(2)));
        return catalog;

    }
}
