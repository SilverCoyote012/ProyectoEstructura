package com.silver.main.menu;

import java.util.Scanner;

public class menuReception {
    public static void menu() {
        System.out.println("====================================================================");
        System.out.println("Menu Recepcionista");
        System.out.println("====================================================================");
        System.out.println("1.- Registrar cita");
        System.out.println("2.- Consultar citas");
        System.out.println("3.- Cancelar cita");
        System.out.println("4.- Salir");
        System.out.println("====================================================================");

        Scanner sc = new Scanner(System.in);
        System.out.print("Opcion: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                // Llamada a la clase registerAppointment
                break;
            case 2:
                // Llamada a la clase consultAppointment
                break;
            case 3:
                // Llamada a la clase cancelAppointment
                break;
            case 4:
                System.out.println("Gracias por usar el sistema de control de citas medicas de Farmacias Similares");
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }
}
