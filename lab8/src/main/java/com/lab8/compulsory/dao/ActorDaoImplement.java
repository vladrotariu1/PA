package com.lab8.compulsory.dao;

import com.lab8.compulsory.models.Actor;
import com.lab8.compulsory.util.DatabaseConfiguration;

import java.sql.*;

public class ActorDaoImplement implements ActorDao{

    Connection conn = DatabaseConfiguration.getConnection();

    @Override
    public int addActor(Actor actor) throws SQLException {
        String query = "INSERT INTO actors VALUES(DEFAULT , ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, actor.getName());

        return stmt.executeUpdate();
    }

    @Override
    public Actor getActor(int id) throws SQLException {
        String query = "SELECT * FROM actors WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setInt(1, id);

        Actor actor = new Actor();
        ResultSet resultSet = stmt.executeQuery();
        boolean check = false;

        while (resultSet.next()) {
            check = true;
            actor.setId(resultSet.getInt("id"));
            actor.setName(resultSet.getString("name"));
        }

        return check ? actor : null;
    }
}
