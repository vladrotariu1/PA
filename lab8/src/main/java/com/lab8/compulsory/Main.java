package com.lab8.compulsory;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.sql.*;

import static com.lab8.compulsory.Tests.*;

public class Main {

    public static void main(String[] args) throws SQLException, IOException, CsvException {
        //MovieAndGenreInsertTest();
        //ActorAndDirectorInsertTest();

        MovieSelectTest();
        ActorSelectTest();
        GenreSelectTest();
        DirectorSelectTest();

        ImportData.impData("src/main/resources/IMDb/IMDb title_principals.csv");
    }
}
