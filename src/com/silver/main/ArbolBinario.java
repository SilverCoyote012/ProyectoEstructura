/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.silver.main;

/**
 *
 * @author nicol
 */
public class ArbolBinario {
    private Nodo raiz;

    public void agregarEmpleado(Empleado empleado) {
        raiz = agregarRecursivo(raiz, empleado);
    }

    private Nodo agregarRecursivo(Nodo actual, Empleado empleado) {
        if (actual == null) {
            return new Nodo(empleado);
        }

        if (empleado.getDepartamento().compareTo(actual.empleado.getDepartamento()) < 0) {
            actual.izquierda = agregarRecursivo(actual.izquierda, empleado);
        } else if (empleado.getDepartamento().compareTo(actual.empleado.getDepartamento()) > 0) {
            actual.derecha = agregarRecursivo(actual.derecha, empleado);
        }

        return actual;
    }

    public Empleado buscarEmpleado(String departamento) {
        return buscarRecursivo(raiz, departamento);
    }

    private Empleado buscarRecursivo(Nodo actual, String departamento) {
        if (actual == null) {
            return null;
        }

        if (departamento.equals(actual.empleado.getDepartamento())) {
            return actual.empleado;
        }

        return departamento.compareTo(actual.empleado.getDepartamento()) < 0
                ? buscarRecursivo(actual.izquierda, departamento)
                : buscarRecursivo(actual.derecha, departamento);
    }
}
