package com.example.productores_agricolas.dto;

import java.time.LocalDate;

public class CreatePedidoRequest {
    private Long idComprador;
    private LocalDate fechaEntregaSolicitada;
    private String direccionEntrega;
    private Double importeTotal;
    private String observaciones;

    // Getters y Setters
    public Long getIdComprador() { return idComprador; }
    public void setIdComprador(Long idComprador) { this.idComprador = idComprador; }

    public LocalDate getFechaEntregaSolicitada() { return fechaEntregaSolicitada; }
    public void setFechaEntregaSolicitada(LocalDate fechaEntregaSolicitada) { this.fechaEntregaSolicitada = fechaEntregaSolicitada; }

    public String getDireccionEntrega() { return direccionEntrega; }
    public void setDireccionEntrega(String direccionEntrega) { this.direccionEntrega = direccionEntrega; }

    public Double getImporteTotal() { return importeTotal; }
    public void setImporteTotal(Double importeTotal) { this.importeTotal = importeTotal; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}