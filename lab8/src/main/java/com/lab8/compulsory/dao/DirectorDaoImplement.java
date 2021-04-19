package com.lab8.compulsory.dao;

import com.lab8.compulsory.models.Director;
import com.lab8.compulsory.util.DatabaseConfiguration;

import java.sql.*;

public class DirectorDaoImplement implements DirectorDao{
    Connection conn = DatabaseConfiguration.getConnection();

    @Override
    public int addDirector(Director director) throws SQLException {
        String query = "INSERT INTO directors VALUES(DEFAULT, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, director.getName());

        return stmt.executeUpdate();
    }

    @Override
    public Director getDirector(int id) throws SQLException {
        String query = "SELECT * FROM directors WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setInt(1, id);

        Director director = new Director();
        ResultSet resultSet = stmt.executeQuery();
        boolean check = false;

        while (resultSet.next()) {
            check = true;
            director.setId(resultSet.getInt("id"));
            director.setName(resultSet.getString("name"));
        }

        return check ? director : null;
    }
}
