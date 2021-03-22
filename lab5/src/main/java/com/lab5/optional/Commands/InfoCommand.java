package com.lab5.optional.Commands;

import com.lab5.compulsory.Catalog;
import com.lab5.exceptions.CatalogNotLoadedException;
import com.lab5.exceptions.InvalidParametersNumberException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InfoCommand extends Command{

    public InfoCommand(String command) throws InvalidParametersNumberException {
        super(command);
        if(getParametersNumber() != 1)
            throw new InvalidParametersNumberException("Invalid number of parameters.");
    }

    public static String getMetaData(String path) throws IOException, TikaException, SAXException {

        File file = new File(path);
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        FileInputStream inputStream = new FileInputStream(file);
        ParseContext context = new ParseContext();

        parser.parse(inputStream, handler, metadata, context);

        String[] metadataNames = metadata.names();
        StringBuilder result = new StringBuilder();

        for(String name : metadataNames) {
            result.append(name).append(": ").append(metadata.get(name));
        }

        return String.valueOf(result);
    }

    public String execute(Catalog catalog) throws CatalogNotLoadedException, TikaException, IOException, SAXException {
        if (catalog == null)
            throw new CatalogNotLoadedException("First load the catalog");

        int itemIndex = Integer.parseInt(getCommand().get(1));
        return getMetaData(catalog.getItemList().get(itemIndex).getPath());
    }
}
