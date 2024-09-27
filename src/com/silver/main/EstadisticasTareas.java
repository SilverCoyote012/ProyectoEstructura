/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.silver.main;

/**
 *
 * @author nicol
 */
import java.util.List;

public class EstadisticasTareas {
    // Método para calcular el tiempo total estimado para completar todas las tareas
    public static int calcularTiempoTotal(List<Tarea> tareas) {
        return calcularTiempoRecursivo(tareas, 0);
    }

    // Método recursivo para calcular el tiempo total
    private static int calcularTiempoRecursivo(List<Tarea> tareas, int indice) {
        if (indice == tareas.size()) {
            return 0;
        }
        // Suponiendo que cada tarea tiene un método getDuracion() que devuelve el tiempo estimado en horas
        return tareas.get(indice).getDuracion() + calcularTiempoRecursivo(tareas, indice + 1);
    }
}
