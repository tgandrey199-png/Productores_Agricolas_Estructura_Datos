package com.example.productores_agricolas.services;

import com.example.productores_agricolas.dto.CreatePedidoRequest;
import com.example.productores_agricolas.models.Pedido;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class PedidoService {

    // USAMOS UNA COLA (QUEUE) COMO DICE LA RÚBRICA
    private final Queue<Pedido> pedidos = new LinkedList<>();
    private Long nextId = 1L;

    public PedidoService() {
        crearInterno(1L, 500.0, "Av. Reforma 123");
        crearInterno(2L, 1200.50, "Calle Hidalgo 456");
        crearInterno(3L, 350.0, "Col. Centro 789");
    }

    private void crearInterno(Long idComprador, Double total, String direccion) {
        Pedido p = new Pedido();
        p.setId(nextId++);
        p.setIdComprador(idComprador);
        p.setFechaPedido(LocalDate.now());
        p.setFechaEntregaSolicitada(LocalDate.now().plusDays(3));
        p.setDireccionEntrega(direccion);
        p.setImporteTotal(total);
        p.setEstado("PENDIENTE");
        p.setObservaciones("Pedido de prueba");
        pedidos.add(p); // Agregamos a la cola
    }

    public List<Pedido> obtenerTodos() {
        // Convertimos la cola a Lista para que Spring Boot lo regrese como JSON
        return new ArrayList<>(pedidos);
    }

    public Pedido obtenerPorId(Long id) {
        // Buscamos en la cola
        return pedidos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Pedido crear(CreatePedidoRequest req) {
        Pedido p = new Pedido();
        p.setId(nextId++);
        p.setIdComprador(req.getIdComprador());
        p.setFechaPedido(LocalDate.now());
        p.setFechaEntregaSolicitada(req.getFechaEntregaSolicitada());
        p.setDireccionEntrega(req.getDireccionEntrega());
        p.setImporteTotal(req.getImporteTotal());
        p.setEstado("PENDIENTE");
        p.setObservaciones(req.getObservaciones());

        pedidos.add(p); // Agregamos a la cola
        return p;
    }
}