package com.lab5.compulsory;

import com.lab5.exceptions.InvalidCatalogException;
import java.io.*;

public class CatalogUtil {

    // Save catalog to external file
    public static void save(Catalog catalog) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    // Loads a catalog from local hard drive
    public static Catalog load(String path) throws InvalidCatalogException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            return (Catalog) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
