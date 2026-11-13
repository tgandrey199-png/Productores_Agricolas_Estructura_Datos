package com.example.productores_agricolas.structures;

import java.util.ArrayList;
import java.util.List;

public class MiListaLigada<T> {
    // Nodo interno
    private class Nodo {
        T dato;
        Nodo siguiente;
        Nodo(T dato) { this.dato = dato; this.siguiente = null; }
    }

    private Nodo cabeza;
    private int tamanio;

    public MiListaLigada() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    public void agregar(T dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamanio++;
    }

    // Método obligatorio para Spring Boot
    public List<T> toList() {
        List<T> lista = new ArrayList<>();
        Nodo actual = cabeza;
        while (actual != null) {
            lista.add(actual.dato);
            actual = actual.siguiente;
        }
        return lista;
    }

    public int getTamanio() { return tamanio; }
}
