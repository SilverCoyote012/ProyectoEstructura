/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.silver.main;

/**
 *
 * @author nicol
 */
public class Empleado {
    private int id;
    private String nombre;
    private String departamento;
    private static int contador = 0;

    public Empleado(String nombre, String departamento) {
        this.id = ++contador;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return "Empleado{id=" + id + ", nombre='" + nombre + "', departamento='" + departamento + "'}";
    }
}


class Nodo {
    Empleado empleado;
    Nodo izquierda, derecha;

    public Nodo(Empleado empleado) {
        this.empleado = empleado;
        izquierda = derecha = null;
    }
}
