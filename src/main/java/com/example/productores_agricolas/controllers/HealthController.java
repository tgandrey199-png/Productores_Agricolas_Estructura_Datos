package com.example.productores_agricolas.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    private final JdbcTemplate jdbcTemplate;

    // Inyectamos JdbcTemplate para hacer la consulta
    public HealthController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/db")
    public ResponseEntity<String> healthDb() {
        try {
            // Ejecutamos un SELECT 1 como pide la rúbrica
            Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            if (result != null && result == 1) {
                return ResponseEntity.ok("Conexión a la base de datos exitosa");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error de conexión: " + e.getMessage());
        }
        return ResponseEntity.status(500).body("Error desconocido");
    }
}