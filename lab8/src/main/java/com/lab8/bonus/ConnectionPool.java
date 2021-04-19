package com.lab8.bonus;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static final HikariDataSource ds = new HikariDataSource();

    static {
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/pa_lab8");
        ds.setUsername("root");
        ds.setPassword("catrelkj12");
        ds.setMaximumPoolSize(1000);
    }

    private ConnectionPool(){}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
