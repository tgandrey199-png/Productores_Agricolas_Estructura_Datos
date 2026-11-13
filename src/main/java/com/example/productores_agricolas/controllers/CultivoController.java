package com.example.productores_agricolas.controllers;

import com.example.productores_agricolas.dto.CreateCultivoRequest;
import com.example.productores_agricolas.models.Cultivo;
import com.example.productores_agricolas.services.CultivoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cultivos")
public class CultivoController {

    private final CultivoService cultivoService;

    public CultivoController(CultivoService cultivoService) {
        this.cultivoService = cultivoService;
    }

    @GetMapping
    public ResponseEntity<List<Cultivo>> obtenerTodos() {
        return ResponseEntity.ok(cultivoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cultivo> obtenerPorId(@PathVariable Long id) {
        Cultivo c = cultivoService.obtenerPorId(id);
        if (c == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(c);
    }

    @PostMapping
    public ResponseEntity<Cultivo> crear(@RequestBody CreateCultivoRequest request) {
        return ResponseEntity.status(201).body(cultivoService.crear(request));
    }
}