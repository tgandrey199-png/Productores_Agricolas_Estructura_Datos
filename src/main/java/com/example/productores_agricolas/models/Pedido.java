package com.example.productores_agricolas.models;

import java.time.LocalDate;

public class Pedido {
    private Long id;
    private Long idComprador;
    private LocalDate fechaPedido;
    private LocalDate fechaEntregaSolicitada;
    private String direccionEntrega;
    private Double importeTotal;
    private String estado;
    private String observaciones;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdComprador() { return idComprador; }
    public void setIdComprador(Long idComprador) { this.idComprador = idComprador; }

    public LocalDate getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(LocalDate fechaPedido) { this.fechaPedido = fechaPedido; }

    public LocalDate getFechaEntregaSolicitada() { return fechaEntregaSolicitada; }
    public void setFechaEntregaSolicitada(LocalDate fechaEntregaSolicitada) { this.fechaEntregaSolicitada = fechaEntregaSolicitada; }

    public String getDireccionEntrega() { return direccionEntrega; }
    public void setDireccionEntrega(String direccionEntrega) { this.direccionEntrega = direccionEntrega; }

    public Double getImporteTotal() { return importeTotal; }
    public void setImporteTotal(Double importeTotal) { this.importeTotal = importeTotal; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}