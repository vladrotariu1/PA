package com.lab5.compulsory;

import com.lab5.exceptions.InvalidCatalogException;
import com.lab5.exceptions.InvalidImageFileException;
import com.lab5.exceptions.InvalidMp3FileException;

import java.io.IOException;
import java.util.ArrayList;

import static com.lab5.compulsory.CatalogUtil.load;
import static com.lab5.compulsory.CatalogUtil.save;

public class Main {
    public static void main(String[] args){

        Catalog catalog = new Catalog("D:/PA/lab5/savings/catalog.ser");
        ArrayList<Item> items = new ArrayList<>(10);

        try {
            items.add(new Image("D:/Downloads/devteamphoto.jpg"));
            items.add(new Image("D:/Downloads/sigla-guvern.png"));
            items.add(new Song("D:/Downloads/umbluLangaAiMei.mp3"));
        } catch (InvalidMp3FileException | InvalidImageFileException e) {
            e.printStackTrace();
        }

        catalog.setItemList(items);

        try {
            save(catalog);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Catalog loadedCatalog = null;

        try {
            loadedCatalog = load("D:/PA/lab5/savings/catalog.ser");
        } catch (InvalidCatalogException e) {
            e.printStackTrace();
        }

        catalog.play(loadedCatalog.getItemList().get(0).getId());
        catalog.play(loadedCatalog.getItemList().get(2).getId());
    }
}
