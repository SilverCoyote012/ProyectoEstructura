package com.silver.main.sesion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.silver.main.conexionDB;
import com.silver.main.app;
import com.silver.main.utils;

public class register {
    public static void registrar() {
        System.out.println("====================================================================");
        System.out.println("Registro de usuario");
        System.out.println("====================================================================");
        Scanner sc = new Scanner(System.in);
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("Contraseña: ");
        String password = sc.nextLine();
        System.out.print("Rol (Doctor/Recepcionista): ");
        String rol = sc.nextLine();
        while (true) {
            // Hacer la primera letra mayuscula
            rol = rol.substring(0, 1).toUpperCase() + rol.substring(1).toLowerCase();
            if (rol.equals("Doctor") || rol.equals("Recepcionista")) {
                break;
            } else {
                System.out.println("Rol no valido, intente de nuevo");
            }
        }
        System.out.println("====================================================================");

        String sql = "INSERT INTO usuarios (correo, password, rol) VALUES (?, ?, ?)";

        try (Connection conexion = conexionDB.getConnection();
            PreparedStatement pst = conexion.prepareStatement(sql)) {
            pst.setString(1, correo);
            pst.setString(2, password);
            pst.setString(3, rol);
            pst.executeUpdate();
            System.out.println("Usuario registrado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Volver al menu principal
            utils.limpiarConsola();
            app.main(null);
        }
    }
}
