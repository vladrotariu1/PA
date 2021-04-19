package com.lab8.compulsory;

import com.lab8.compulsory.dao.*;
import com.lab8.compulsory.models.Actor;
import com.lab8.compulsory.models.Director;
import com.lab8.compulsory.models.Genre;
import com.lab8.compulsory.models.Movie;

import java.sql.Date;
import java.sql.SQLException;

public class Tests {
    public static void MovieAndGenreInsertTest() throws SQLException {

        /* Add genre to DB */
        Genre genre = new Genre();
        GenreDaoImplement genreTable = new GenreDaoImplement();

        genre.setName("Action");
        genreTable.addGenre(genre);

        /* Add movie to DB */
        Movie movie = new Movie();
        MovieDaoImplement movieTable = new MovieDaoImplement();
        Date time = Date.valueOf("2018-09-01");

        movie.setTitle("Film1");
        movie.setScore(30);
        movie.setDuration(5);
        movie.setReleaseDate(time);
        movieTable.addMovie(movie);
    }

    public static void ActorAndDirectorInsertTest() throws SQLException {

        /* Add genre to DB */
        Actor actor = new Actor();
        ActorDaoImplement actorTable = new ActorDaoImplement();

        actor.setName("Brad Pitt");
        actorTable.addActor(actor);

        /* Add movie to DB */
        Director director = new Director();
        DirectorDaoImplement directorTable = new DirectorDaoImplement();

        director.setName("Quentin Tarantino");
        directorTable.addDirector(director);
    }

    public static void MovieSelectTest() throws SQLException {
        MovieDaoImplement movieTable = new MovieDaoImplement();
        Movie movie = movieTable.getMovie(3);
        System.out.println(movie);
    }

    public static void GenreSelectTest() throws SQLException {
        GenreDaoImplement genreTable = new GenreDaoImplement();
        Genre genre = genreTable.getGenre(5);
        System.out.println(genre);
    }

    public static void ActorSelectTest() throws SQLException {
        ActorDaoImplement actorTable = new ActorDaoImplement();
        Actor actor = actorTable.getActor(1);
        System.out.println(actor);
    }

    public static void DirectorSelectTest() throws SQLException {
        DirectorDaoImplement directorTable = new DirectorDaoImplement();
        Director director = directorTable.getDirector(1);
        System.out.println(director);
    }
}
