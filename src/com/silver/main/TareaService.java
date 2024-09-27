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

public class TareaService {
    private PriorityQueue<Tarea> colaDePrioridades;
    private HashMap<Integer, Tarea> tareas;

    public TareaService() {
        this.colaDePrioridades = new PriorityQueue<>();
        this.tareas = new HashMap<>();
    }

    public void agregarTarea(Tarea tarea) {
        colaDePrioridades.add(tarea);
        tareas.put(tarea.getId(), tarea);
        System.out.println("Tarea agregada: " + tarea.getNombre());
    }

    public Tarea obtenerSiguienteTarea() {
        Tarea tarea = colaDePrioridades.poll();
        if (tarea != null) {
            tareas.remove(tarea.getId());
        }
        return tarea;
    }

    public Tarea obtenerTareaPorId(int id) {
        return tareas.get(id);
    }

    public List<Tarea> obtenerTodasLasTareas() {
        return new ArrayList<>(tareas.values());
    }

    public void actualizarTarea(int id, Tarea nuevaTarea) {
        if (tareas.containsKey(id)) {
            Tarea tareaExistente = tareas.get(id);
            colaDePrioridades.remove(tareaExistente);
            nuevaTarea.setId(id); // Mantener el mismo ID
            colaDePrioridades.add(nuevaTarea);
            tareas.put(id, nuevaTarea);
            System.out.println("Tarea actualizada: " + nuevaTarea.getNombre());
        } else {
            System.out.println("Tarea no encontrada con ID: " + id);
        }
    }

    public void eliminarTarea(int id) {
        Tarea tarea = tareas.remove(id);
        if (tarea != null) {
            colaDePrioridades.remove(tarea);
            System.out.println("Tarea eliminada con ID: " + id);
        } else {
            System.out.println("Tarea no encontrada con ID: " + id);
        }
    }
}