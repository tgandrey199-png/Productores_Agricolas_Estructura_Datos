package com.example.productores_agricolas.controllers;

import com.example.productores_agricolas.dto.CreatePedidoRequest;
import com.example.productores_agricolas.models.Pedido;
import com.example.productores_agricolas.services.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> obtenerTodos() {
        return ResponseEntity.ok(pedidoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obtenerPorId(@PathVariable Long id) {
        Pedido p = pedidoService.obtenerPorId(id);
        if (p == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }

    @PostMapping
    public ResponseEntity<Pedido> crear(@RequestBody CreatePedidoRequest request) {
        return ResponseEntity.status(201).body(pedidoService.crear(request));
    }
}