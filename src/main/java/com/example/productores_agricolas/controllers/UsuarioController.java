package com.example.productores_agricolas.controllers;

import com.example.productores_agricolas.dto.CreateUsuarioRequest;
import com.example.productores_agricolas.models.Usuario;
import com.example.productores_agricolas.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Inyección de dependencias por constructor
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerTodos() {
        return ResponseEntity.ok(usuarioService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable Long id) {
        Usuario u = usuarioService.obtenerPorId(id);
        if (u == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(u);
    }

    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody CreateUsuarioRequest request) {
        return ResponseEntity.status(201).body(usuarioService.crear(request));
    }
}