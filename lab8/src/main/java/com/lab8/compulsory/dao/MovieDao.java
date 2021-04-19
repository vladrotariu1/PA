package com.lab8.compulsory.dao;

import com.lab8.compulsory.models.Movie;

import java.sql.SQLException;

public interface MovieDao {
    int addMovie(Movie movie)
            throws SQLException;
    void deleteMovie(int id)
            throws SQLException;
    Movie  getMovie(int id)
            throws SQLException;
}
