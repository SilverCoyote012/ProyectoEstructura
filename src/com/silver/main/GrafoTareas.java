/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.silver.main;

/**
 *
 * @author nicol
 */
import java.util.*;

public class GrafoTareas {
    private Map<Tarea, List<Tarea>> grafo;

    public GrafoTareas() {
        this.grafo = new HashMap<>();
    }

    public void agregarTarea(Tarea tarea) {
        grafo.putIfAbsent(tarea, new ArrayList<>());
    }

    public void agregarDependencia(Tarea tarea, Tarea dependencia) {
        grafo.get(tarea).add(dependencia);
    }

    public List<Tarea> obtenerDependencias(Tarea tarea) {
        return grafo.get(tarea);
    }

    public void mostrarGrafo() {
        for (Map.Entry<Tarea, List<Tarea>> entry : grafo.entrySet()) {
            System.out.println("Tarea: " + entry.getKey().getNombre() + " -> Dependencias: " + entry.getValue());
        }
    }
}
