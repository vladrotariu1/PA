package com.lab8.compulsory.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {
    private static Connection con = null;

    static
    {
        String url = "jdbc:mysql://localhost:3306/pa_lab8";
        String user = "root";
        String pass = "catrelkj12";
        try {
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DatabaseConfiguration(){}

    public static Connection getConnection()
    {
        return con;
    }
}
