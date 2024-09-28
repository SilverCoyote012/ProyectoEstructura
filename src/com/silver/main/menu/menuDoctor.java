package com.silver.main.menu;

import java.util.Scanner;

import com.silver.main.sesion.sesion;
import com.silver.main.utils;

public class menuDoctor {
    public static void menu() {
        System.out.println("====================================================================");
        System.out.println("Menu Doctor");
        System.out.println("====================================================================");
        System.out.println("1.- Revisar citas");
        System.out.println("2.- Atender cita");
        System.out.println("3.- Revisar reportes");
        System.out.println("4.- Salir");
        System.out.println("====================================================================");

        Scanner sc = new Scanner(System.in);
        System.out.print("Opcion: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                // Llamada a la clase consultAppointment
                utils.limpiarConsola();
                System.out.println("Consultar citas");
                break;
            case 2:
                // Llamada a la clase attendAppointment
                utils.limpiarConsola();
                System.out.println("Atender cita");
                break;
            case 3:
                // Llamada a la clase reviewReports
                utils.limpiarConsola();
                System.out.println("Revisar reportes");
                break;
            case 4:
                utils.limpiarConsola();
                System.out.println("Gracias por usar el sistema de control de citas de urgencias del Hospital");
                // Borrar la informacion del usuario
                sesion.cerrarSesion();
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }
}
