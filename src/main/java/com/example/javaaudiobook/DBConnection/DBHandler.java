package com.example.javaaudiobook.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler extends Configs{


    Connection dbconnection;

    public Connection getconnection() throws ClassNotFoundException {
        String connectionString = "jdbc:mysql://localhost:3306/audiobook?autoReconnect=true&useSSL=false";



        try {
            dbconnection = DriverManager.getConnection(connectionString,"root","12345");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return dbconnection;
    }

}
