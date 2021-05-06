package com.lab9;

import com.lab9.entities.ChartsEntity;
import com.lab9.entityManager.ChartsEntityManager;
import com.lab9.entityManager.GenresEntityManager;

import java.sql.Timestamp;


public class Main {
    public static void main(String[] args) {
        ChartsEntity movie = new ChartsEntity();
        movie.setTitle("Superman");
        movie.setReleaseDate(Timestamp.valueOf("2013-02-22 15:20:30"));
        movie.setRating(4);

        ChartsEntityManager moviesEM = new ChartsEntityManager();
        moviesEM.create(movie);

        GenresEntityManager genresEntityManager = new GenresEntityManager();
        genresEntityManager.findById(1);
    }
}
