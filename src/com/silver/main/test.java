package com.silver.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
    public static void main(String[] args) {
        try (Connection connection = conexionDB.getConnection()) {
            Statement statement = connection.createStatement();
            System.err.println("Conexión exitosa");
            
        } catch (SQLException e) {
            e.printStackTrace(); // Mostrar error en consola
        }
    }
}
