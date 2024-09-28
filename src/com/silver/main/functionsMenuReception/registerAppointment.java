package com.silver.main.functionsMenuReception;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.silver.main.conexionDB;
import com.silver.main.menu.menuReception;
import com.silver.main.utils;

public class registerAppointment {
    public static void registrarCita() {
        try {
            System.out.println("====================================================================");
            System.out.println("Registro de Llegada de Paciente");
            System.out.println("====================================================================");

            Scanner sc = new Scanner(System.in);
            System.out.print("Nombre del paciente: ");
            String nombre = sc.nextLine();

            // Seleccionar el doctor de la lista de doctores aleatoriamente
            String sql = "SELECT * FROM doctores ORDER BY RAND() LIMIT 1";
            String doctor = "";
            try (Connection conexion = conexionDB.getConnection();
                PreparedStatement pst = conexion.prepareStatement(sql)) {
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    // Guardar el id del doctor
                    doctor = rs.getString("ID_Doctor");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Leer y validar fecha
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = null;

            while (true) {
                System.out.print("Fecha del dia (YYYY-MM-DD): ");
                String fechaInput = sc.nextLine();
                try {
                    fecha = dateFormat.parse(fechaInput);
                    break; // Salir del bucle si la fecha es válida
                } catch (ParseException e) {
                    System.out.println("Fecha no válida. Inténtalo de nuevo.");
                }
            }

            // Leer y validar hora
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            Date hora = null;

            while (true) {
                System.out.print("Hora de llegada (HH:MM): ");
                String horaInput = sc.nextLine();
                try {
                    hora = timeFormat.parse(horaInput);
                    break; // Salir del bucle si la hora es válida
                } catch (ParseException e) {
                    System.out.println("Hora no válida. Inténtalo de nuevo.");
                }
            }

            int prioridad = 0;
            while (true) {
                System.out.print("Prioridad del paciente (1-3): ");
                prioridad = sc.nextInt();
                sc.nextLine();
                if (prioridad >= 1 && prioridad <= 3) {
                    break;
                } else {
                    System.out.println("Prioridad no válida");
                }
            }

            // Insertar en la base de datos
            sql = "INSERT INTO citas (nombre_paciente, id_doctor, fecha, hora, prioridad) VALUES (?, ?, ?, ?, ?)";

            try (Connection conexion = conexionDB.getConnection();
                PreparedStatement pst = conexion.prepareStatement(sql)) {
                pst.setString(1, nombre);
                pst.setString(2, doctor);
                pst.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(fecha)); // Guardar como fecha
                pst.setString(4, new SimpleDateFormat("HH:mm").format(hora)); // Guardar como hora
                pst.setInt(5, prioridad);
                pst.executeUpdate();
                System.out.println("Cita registrada correctamente");

                // Regresar al menú de recepcionista
                utils.limpiarConsola();
                menuReception.menu();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
