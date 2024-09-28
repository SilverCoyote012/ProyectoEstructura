package com.silver.main;

import java.util.Scanner;

import com.silver.main.sesion.login;
import com.silver.main.sesion.register;

public class app {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("====================================================================");
        System.out.println("Bienvenido Sistema de Urgencias del Hospital");
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
                utils.limpiarConsola();
                login.iniciarSesion();
                break;
            case 2:
                // Llamada a la clase register
                utils.limpiarConsola();
                register.registrar();
                break;
            case 3:
                utils.limpiarConsola();
                System.out.println("Gracias por usar el sistema de control de citas de urgencias del Hospital");
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }
}