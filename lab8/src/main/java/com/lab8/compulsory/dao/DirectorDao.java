package com.lab8.compulsory.dao;

import com.lab8.compulsory.models.Director;

import java.sql.SQLException;

public interface DirectorDao {
    int addDirector(Director director)
            throws SQLException;
    Director getDirector(int id)
            throws SQLException;
}
