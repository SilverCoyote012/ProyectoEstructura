package com.silver.main;

import java.util.Scanner;

import com.silver.main.sesion.login;
import com.silver.main.sesion.register;

public class app {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("====================================================================");
        System.out.println("Bienvenido Sistema de Citas Medicas de Farmacias Similares");
        System.out.println("====================================================================");
        System.out.println("1.- Iniciar sesion");
        System.out.println("2.- Registrarse");
        System.out.println("3.- Salir");
        System.out.println("====================================================================");
        System.out.print("Opcion: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                // Llamada a la clase login
                login.iniciarSesion();
                break;
            case 2:
                // Llamada a la clase register
                register.registrar();
                break;
            case 3:
                System.out.println("Gracias por usar el sistema de control de inventario de Farmacias Similares");
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }
}
