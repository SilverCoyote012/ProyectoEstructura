package com.silver.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/PROYECTO__";
    private static final String USER = "root";
    private static final String PASSWORD = "Nicooa.6652/";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

