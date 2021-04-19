package com.lab8.tasks;

import com.lab8.bonus.ConnectionPool;
import com.lab8.compulsory.models.Actor;
import com.lab8.compulsory.util.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task2 implements Runnable{

    @Override
    public void run(){
        Connection conn = null;
        conn = DatabaseConfiguration.getConnection();


        String query = "SELECT * FROM actors WHERE id=?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            stmt.setInt(1, 1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Actor actor = new Actor();
        ResultSet resultSet = null;
        try {
            resultSet = stmt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        boolean check = false;

        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            check = true;
            try {
                actor.setId(resultSet.getInt("id"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                actor.setName(resultSet.getString("name"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        System.out.println(actor);
    }
}
