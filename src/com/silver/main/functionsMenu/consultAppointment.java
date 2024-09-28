package com.silver.main.functionsMenu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.silver.main.conexionDB;
import com.silver.main.menu.menuReception;
import com.silver.main.utils;

public class consultAppointment {
    public static void consultarCitas() {
        // Buscar las cita en base al nombre del paciente o del doctor
        System.out.println("====================================================================");
        System.out.println("Consultar citas");
        System.out.println("====================================================================");
        System.out.println("1.- Por nombre del paciente");
        System.out.println("2.- Por nombre del doctor");
        System.out.println("3.- Regresar");
        System.out.println("====================================================================");

        Scanner sc = new Scanner(System.in);
        System.out.print("Opcion: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                utils.limpiarConsola();
                System.out.print("Nombre del paciente: ");
                String nombrePaciente = sc.nextLine();
                buscarCitasPorPaciente(nombrePaciente);
                break;
            case 2:
                utils.limpiarConsola();
                System.out.print("Nombre del doctor: ");
                String nombreDoctor = sc.nextLine();
                System.out.print("Apellido del doctor: ");
                String apellidoDoctor = sc.nextLine();
                buscarCitasPorDoctor(nombreDoctor, apellidoDoctor);
                break;
            case 3:
                utils.limpiarConsola();
                menuReception.menu();
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

    private static void buscarCitasPorPaciente(String nombrePaciente) {
        String sql = "SELECT * FROM citas WHERE nombre_paciente = ?";
        try (Connection conexion = conexionDB.getConnection();
            PreparedStatement pst = conexion.prepareStatement(sql)) {
            pst.setString(1, nombrePaciente);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("Citas encontradas:");
                System.out.println("====================================================================");
                do {
                    // Buscar nombres de los doctores en la tabla doctores
                    String sqlDoctor = "SELECT * FROM doctores WHERE ID_Doctor = ?";
                    try (Connection conexionDoctor = conexionDB.getConnection();
                        PreparedStatement pstDoctor = conexionDoctor.prepareStatement(sqlDoctor)) {
                        pstDoctor.setString(1, rs.getString("ID_Doctor"));
                        ResultSet rsDoctor = pstDoctor.executeQuery();
                        if (rsDoctor.next()) {
                            System.out.println("ID de la cita: " + rs.getInt("ID_Cita"));
                            System.out.println("Nombre del paciente: " + rs.getString("nombre_paciente"));
                            System.out.println("Nombre del doctor: " + rsDoctor.getString("nombre"));
                            System.out.println("Fecha: " + rs.getString("fecha"));
                            System.out.println("Hora: " + rs.getString("hora"));
                            System.out.println("====================================================================");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } while (rs.next());
            } else {
                System.out.println("No se encontraron citas para el paciente " + nombrePaciente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Presiona una tecla para continuar...");
            new Scanner(System.in).nextLine();
            utils.limpiarConsola();
            menuReception.menu();
        }
    }

    private static void buscarCitasPorDoctor(String nombreDoctor, String apellidoDoctor) {
        String sql = "SELECT * FROM doctores WHERE nombre LIKE ? AND apellido LIKE ?";
        try (Connection conexion = conexionDB.getConnection();
            PreparedStatement pst = conexion.prepareStatement(sql)) {
            pst.setString(1, nombreDoctor);
            pst.setString(2, apellidoDoctor);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Buscar las citas del doctor
                String sqlCitas = "SELECT * FROM citas WHERE ID_Doctor = ?";
                try (Connection conexionCitas = conexionDB.getConnection();
                    PreparedStatement pstCitas = conexionCitas.prepareStatement(sqlCitas)) {
                    pstCitas.setString(1, rs.getString("ID_Doctor"));
                    ResultSet rsCitas = pstCitas.executeQuery();

                    if (rsCitas.next()) {
                        System.out.println("Citas encontradas:");
                        System.out.println("====================================================================");
                        do {
                            System.out.println("Nombre del paciente: " + rsCitas.getString("nombre_paciente"));
                            System.out.println("Nombre del doctor: " + rs.getString("nombre") + " " + rs.getString("apellido"));
                            System.out.println("Fecha: " + rsCitas.getString("fecha"));
                            System.out.println("Hora: " + rsCitas.getString("hora"));
                            System.out.println("====================================================================");
                        } while (rsCitas.next());
                    } else {
                        System.out.println("No se encontraron citas para el doctor " + nombreDoctor);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("No se encontro el doctor " + nombreDoctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Presiona una tecla para continuar...");
            new Scanner(System.in).nextLine();
            utils.limpiarConsola();
            menuReception.menu();
        }
    }
}
