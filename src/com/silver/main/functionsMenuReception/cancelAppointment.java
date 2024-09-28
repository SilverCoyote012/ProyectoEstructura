package com.silver.main.functionsMenuReception;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;

import com.silver.main.conexionDB;
import com.silver.main.menu.menuReception;
import com.silver.main.utils;

public class cancelAppointment {
    public static void cancelarCita() {
        System.out.println("====================================================================");
        System.out.println("Cancelar cita");
        System.out.println("====================================================================");
        
        // Buscar la cita en base al nombre del paciente
        System.out.print("Nombre del paciente: ");
        Scanner sc = new Scanner(System.in);
        String nombrePaciente = sc.nextLine();

        String sql = "SELECT * FROM citas WHERE nombre_paciente = ?";

        try (Connection conexion = conexionDB.getConnection();
             PreparedStatement pst = conexion.prepareStatement(sql)) {
            pst.setString(1, nombrePaciente);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                // Buscar si la cita tiene algún reporte médico asociado
                int idCita = rs.getInt("id_cita");
                String sqlReporte = "SELECT * FROM reporte WHERE id_cita = ?";

                try (PreparedStatement pstReporte = conexion.prepareStatement(sqlReporte)) {
                    pstReporte.setInt(1, idCita);
                    ResultSet rsReporte = pstReporte.executeQuery();
                    if (rsReporte.next()) {
                        System.out.println("El paciente no tiene citas sin reporte médico asociado");
                    } else {
                        // Buscar el doctor asociado a la cita
                        int idDoctor = rs.getInt("id_doctor");
                        String sqlDoctor = "SELECT * FROM doctores WHERE id_doctor = ?";
                        try (PreparedStatement pstDoctor = conexion.prepareStatement(sqlDoctor)) {
                            pstDoctor.setInt(1, idDoctor);
                            ResultSet rsDoctor = pstDoctor.executeQuery();
                            if (rsDoctor.next()) {
                                String nombreDoctor = rsDoctor.getString("nombre");
                                String apellidoDoctor = rsDoctor.getString("apellido");
                                
                                // Mostrar todas las citas relacionadas al paciente
                                try (PreparedStatement pstCitas = conexion.prepareStatement(sql)) {
                                    pstCitas.setString(1, nombrePaciente);
                                    ResultSet rsCitas = pstCitas.executeQuery();

                                    // Crear una lista de citas relacionadas al paciente
                                    ArrayList<Integer> idCitasPacientes = new ArrayList<>();

                                    System.out.println("Citas relacionadas al paciente:");
                                    while (rsCitas.next()) {
                                        System.out.println("ID Cita: " + rsCitas.getInt("id_cita"));
                                        // Agregar el id de la cita a la lista
                                        idCitasPacientes.add(rsCitas.getInt("id_cita"));
                                        System.out.println("Nombre del paciente: " + rsCitas.getString("nombre_paciente"));
                                        System.out.println("Fecha de registro: " + rsCitas.getString("fecha"));
                                        System.out.println("Hora de registro: " + rsCitas.getString("hora"));
                                        System.out.println("Doctor: " + nombreDoctor + " " + apellidoDoctor);
                                        System.out.println("====================================================================");
                                    }

                                    // Seleccionar la cita a cancelar
                                    System.out.print("ID de la cita a cancelar: ");
                                    int idCitaCancelar = sc.nextInt();
                                    sc.nextLine();  // Consumir el salto de línea

                                    if (idCitasPacientes.contains(idCitaCancelar)) {
                                        String sqlEliminarCita = "DELETE FROM citas WHERE id_cita = ?";
                                        try (PreparedStatement pstEliminarCita = conexion.prepareStatement(sqlEliminarCita)) {
                                            pstEliminarCita.setInt(1, idCitaCancelar);
                                            int filasAfectadas = pstEliminarCita.executeUpdate();
                                            if (filasAfectadas > 0) {
                                                System.out.println("Cita cancelada con éxito");
                                            } else {
                                                System.out.println("No se pudo cancelar la cita, verifica el ID.");
                                            }
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        }
                                    } else {
                                        System.out.println("ID de cita no válido o no pertenece al paciente");
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                System.out.println("Doctor no encontrado");
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Cita no encontrada");
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
