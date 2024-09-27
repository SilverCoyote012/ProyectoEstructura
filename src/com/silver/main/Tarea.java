/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.silver.main;

/**
 *
 * @author nicol
 */
import java.util.Date;

public class Tarea implements Comparable<Tarea> {
    private int id;
    private String nombre;
    private int prioridad;
    private Date fechaEntrega;
    private int duracion; // Duración en horas
    private static int contador = 0;

    public Tarea(String nombre, int prioridad, Date fechaEntrega, int duracion) {
        this.id = ++contador;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.fechaEntrega = fechaEntrega;
        this.duracion = duracion;
    }

    public Tarea(int id, String nombre, int prioridad, Date fechaEntrega, int duracion) {
        this.id = id;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.fechaEntrega = fechaEntrega;
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Tarea otraTarea) {
        if (this.prioridad != otraTarea.prioridad) {
            return Integer.compare(otraTarea.prioridad, this.prioridad);
        }
        return this.fechaEntrega.compareTo(otraTarea.fechaEntrega);
    }

    @Override
    public String toString() {
        return "Tarea{id=" + id + ", nombre='" + nombre + "', prioridad=" + prioridad + ", fechaEntrega=" + fechaEntrega + ", duracion=" + duracion + "}";
    }
}
