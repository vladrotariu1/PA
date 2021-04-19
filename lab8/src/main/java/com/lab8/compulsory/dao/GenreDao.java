package com.lab8.compulsory.dao;

import com.lab8.compulsory.models.Genre;

import java.sql.SQLException;

public interface GenreDao {
    int addGenre(Genre genre)
            throws SQLException;
    void deleteGenre(int id)
            throws SQLException;
    Genre  getGenre(int id)
            throws SQLException;
}
