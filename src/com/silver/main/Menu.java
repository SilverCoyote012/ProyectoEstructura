/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.silver.main;

/**
 *
 * @author nicol
 */
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Menu {
    private TareaService tareaService;

    public Menu(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    public void mostrarMenu() {
        System.out.println("1. Agregar Tarea");
        System.out.println("2. Ver Tareas");
        System.out.println("3. Actualizar Tarea");
        System.out.println("4. Eliminar Tarea");
        System.out.println("5. Calcular Tiempo Total de Tareas");
        System.out.println("6. Salir");
    }

    public void procesarOpcion(int opcion, Scanner scanner) {
        switch (opcion) {
            case 1:
                agregarTarea(scanner);
                break;
            case 2:
                verTareas();
                break;
            case 3:
                actualizarTarea(scanner);
                break;
            case 4:
                eliminarTarea(scanner);
                break;
            case 5:
                calcularTiempoTotal();
                break;
            case 6:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }

    private void agregarTarea(Scanner scanner) {
        try {
            System.out.print("Ingrese el nombre de la tarea: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la prioridad de la tarea: ");
            int prioridad = scanner.nextInt();
            scanner.nextLine(); // Consume el salto de línea
            System.out.print("Ingrese la fecha de entrega (yyyy-MM-dd): ");
            String fechaEntregaStr = scanner.nextLine();
            Date fechaEntrega = new SimpleDateFormat("yyyy-MM-dd").parse(fechaEntregaStr);
            System.out.print("Ingrese la duración estimada de la tarea (en horas): ");
            int duracion = scanner.nextInt();
            scanner.nextLine(); // Consume el salto de línea

            Tarea tarea = new Tarea(nombre, prioridad, fechaEntrega, duracion);
            tareaService.agregarTarea(tarea);
        } catch (Exception e) {
            System.out.println("Error al agregar tarea: " + e.getMessage());
        }
    }

    private void verTareas() {
        for (Tarea tarea : tareaService.obtenerTodasLasTareas()) {
            System.out.println(tarea);
        }
    }

    private void actualizarTarea(Scanner scanner) {
        try {
            System.out.print("Ingrese el ID de la tarea a actualizar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume el salto de línea
            System.out.print("Ingrese el nuevo nombre de la tarea: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la nueva prioridad de la tarea: ");
            int prioridad = scanner.nextInt();
            scanner.nextLine(); // Consume el salto de línea
            System.out.print("Ingrese la nueva fecha de entrega (yyyy-MM-dd): ");
            String fechaEntregaStr = scanner.nextLine();
            Date fechaEntrega = new SimpleDateFormat("yyyy-MM-dd").parse(fechaEntregaStr);
            System.out.print("Ingrese la nueva duración estimada de la tarea (en horas): ");
            int duracion = scanner.nextInt();
            scanner.nextLine(); // Consume el salto de línea

            Tarea nuevaTarea = new Tarea(id, nombre, prioridad, fechaEntrega, duracion);
            tareaService.actualizarTarea(id, nuevaTarea);
        } catch (Exception e) {
            System.out.println("Error al actualizar tarea: " + e.getMessage());
        }
    }

    private void eliminarTarea(Scanner scanner) {
        System.out.print("Ingrese el ID de la tarea a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume el salto de línea
        tareaService.eliminarTarea(id);
    }

    private void calcularTiempoTotal() {
        List<Tarea> tareas = tareaService.obtenerTodasLasTareas();
        int tiempoTotal = EstadisticasTareas.calcularTiempoTotal(tareas);
        System.out.println("El tiempo total estimado para completar todas las tareas es: " + tiempoTotal + " horas");
    }
}
