package com.lab8.compulsory;

import com.lab8.compulsory.util.DatabaseConfiguration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImportData {
    public static void impData(String csvFile) {
        Connection conn = null;

        try{
            conn = DatabaseConfiguration.getConnection();

            String query = "INSERT INTO imdb VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);

            BufferedReader lineRead = new BufferedReader(new FileReader(csvFile));
            String lineText;

            lineRead.readLine();

            while ((lineText = lineRead.readLine()) != null){

                String[] data = lineText.split(",");

                String imdbTitle = data[0];
                String imdb_ordering = data[1];
                String imdbName = data[2];

                stmt.setString(1, imdbTitle);
                stmt.setString(2, imdb_ordering);
                stmt.setString(3, imdbName);

                stmt.addBatch();
                stmt.executeBatch();
            }
            lineRead.close();
            stmt.executeBatch();
            conn.commit();
            conn.close();

        } catch (IOException ex) {
        } catch (SQLException ex) {
            ex.printStackTrace();

            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
