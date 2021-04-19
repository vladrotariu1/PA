package com.lab8.compulsory.dao;

import com.lab8.compulsory.models.Genre;
import com.lab8.compulsory.util.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreDaoImplement implements GenreDao{

    Connection conn = DatabaseConfiguration.getConnection();

    @Override
    public int addGenre(Genre genre) throws SQLException {
        String query = "INSERT INTO genres VALUES(DEFAULT, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, genre.getName());

        return stmt.executeUpdate();
    }

    @Override
    public void deleteGenre(int id) throws SQLException {
        String query = "DELETE from genres where ID =?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    @Override
    public Genre getGenre(int id) throws SQLException {
        String query = "SELECT * FROM genres where ID=?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);

        Genre genre = new Genre();
        ResultSet result = stmt.executeQuery();
        boolean check = false;

        while(result.next()){
            check = true;
            genre.setId(result.getInt("id"));
            genre.setName(result.getString("name"));
        }

        return check ? genre : null;
    }
}
