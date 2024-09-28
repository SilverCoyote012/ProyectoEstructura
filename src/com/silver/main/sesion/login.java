package com.silver.main.sesion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.silver.main.conexionDB;
import com.silver.main.menu.menuDoctor;
import com.silver.main.menu.menuReception;
import com.silver.main.utils;

public class login {
    // Método para iniciar sesión
    public static void iniciarSesion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("====================================================================");
        System.out.println("Iniciar Sesion");
        System.out.println("====================================================================");
        System.out.print("Usuario: ");
        String correo = sc.nextLine();
        System.out.print("Contraseña: ");
        String password = sc.nextLine();
        System.out.println("====================================================================");

        String sql = "SELECT * FROM usuarios WHERE correo = ? AND password = ?";
        
        try (Connection conexion = conexionDB.getConnection();
            PreparedStatement pst = conexion.prepareStatement(sql)) {
            pst.setString(1, correo);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Guardar la informacion del usuario en la sesion
                sesion.iniciarSesion(correo, rs.getString("rol"));

                // Mostrar el menu correspondiente al rol del usuario
                switch (rs.getString("rol")) {
                    case "Doctor":
                        // Llamada a la clase menuDoctor
                        utils.limpiarConsola();
                        menuDoctor.menu();
                        break;
                    case "Recepcionista":
                        // Llamada a la clase menuReception
                        utils.limpiarConsola();
                        menuReception.menu();
                        break;
                    default:
                        System.out.println("Rol no valido");
                        break;
                }


            } else {
                System.out.println("Usuario o contraseña incorrectos");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
