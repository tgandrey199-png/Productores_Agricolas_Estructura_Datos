package com.example.productores_agricolas.services;

import com.example.productores_agricolas.dto.CreateProductoRequest;
import com.example.productores_agricolas.models.Producto;
import com.example.productores_agricolas.structures.MiListaLigada;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final MiListaLigada<Producto> productos = new MiListaLigada<>();
    private Long nextId = 1L;

    public ProductoService() {
        crearInterno("Manzana", "Manzana roja fresca", "Kg", "Frutas", "Otoño");
        crearInterno("Lechuga", "Lechuga orgánica", "Pieza", "Verduras", "Todo el año");
        crearInterno("Maíz", "Maíz blanco", "Kg", "Cereales", "Primavera");
    }

    private void crearInterno(String nombre, String desc, String unidad, String cat, String temporada) {
        Producto p = new Producto();
        p.setId(nextId++);
        p.setNombreProducto(nombre);
        p.setDescripcion(desc);
        p.setUnidadMedida(unidad);
        p.setCategoria(cat);
        p.setTemporadaProduccion(temporada);
        p.setEstado("DISPONIBLE");
        productos.agregar(p);
    }

    public List<Producto> obtenerTodos() {
        return productos.toList();
    }

    public Producto obtenerPorId(Long id) {
        return productos.toList().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Producto crear(CreateProductoRequest req) {
        Producto p = new Producto();
        p.setId(nextId++);
        p.setNombreProducto(req.getNombreProducto());
        p.setDescripcion(req.getDescripcion());
        p.setUnidadMedida(req.getUnidadMedida());
        p.setCategoria(req.getCategoria());
        p.setTemporadaProduccion(req.getTemporadaProduccion());
        p.setEstado("DISPONIBLE");

        productos.agregar(p);
        return p;
    }
}