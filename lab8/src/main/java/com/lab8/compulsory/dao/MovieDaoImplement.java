package com.lab8.compulsory.dao;

import com.lab8.compulsory.models.Movie;
import com.lab8.compulsory.util.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDaoImplement implements MovieDao{

    Connection conn = DatabaseConfiguration.getConnection();

    @Override
    public int addMovie(Movie movie) throws SQLException {
        String query = "INSERT INTO movies VALUES(DEFAULT, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setString(1, movie.getTitle());
        stmt.setDate(2,  movie.getReleaseDate());
        stmt.setFloat(3, movie.getDuration());
        stmt.setInt(4, movie.getScore());

        return stmt.executeUpdate();
    }

    @Override
    public void deleteMovie(int id) throws SQLException {
        String query = "DELETE from movies where ID =?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.executeUpdate();

    }

    @Override
    public Movie getMovie(int id) throws SQLException {

        String query = "SELECT * FROM movies where ID=?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);

        Movie movie = new Movie();
        ResultSet result = stmt.executeQuery();
        boolean check = false;

        while(result.next()){
            check = true;
            movie.setId(result.getInt("id"));
            movie.setTitle(result.getString("title"));
            movie.setReleaseDate(result.getDate("release_date"));
            movie.setDuration(result.getInt("duration"));
            movie.setScore(result.getInt("score"));
        }

        return check ? movie : null;
    }
}
