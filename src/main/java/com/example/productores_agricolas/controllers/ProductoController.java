package com.example.productores_agricolas.controllers;

import com.example.productores_agricolas.dto.CreateProductoRequest;
import com.example.productores_agricolas.models.Producto;
import com.example.productores_agricolas.services.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> obtenerTodos() {
        return ResponseEntity.ok(productoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Long id) {
        Producto p = productoService.obtenerPorId(id);
        if (p == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody CreateProductoRequest request) {
        return ResponseEntity.status(201).body(productoService.crear(request));
    }
}