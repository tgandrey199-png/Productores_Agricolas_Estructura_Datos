package com.example.productores_agricolas.dto;

import java.time.LocalDate;

public class CreateCultivoRequest {
    private String nombreCultivo;
    private LocalDate fechaSiembra;
    private LocalDate fechaCosechaEstimada;
    private Double superficieSembrada;
    private Long idParcela;

    // Getters y Setters
    public String getNombreCultivo() { return nombreCultivo; }
    public void setNombreCultivo(String nombreCultivo) { this.nombreCultivo = nombreCultivo; }
    public LocalDate getFechaSiembra() { return fechaSiembra; }
    public void setFechaSiembra(LocalDate fechaSiembra) { this.fechaSiembra = fechaSiembra; }
    public LocalDate getFechaCosechaEstimada() { return fechaCosechaEstimada; }
    public void setFechaCosechaEstimada(LocalDate fechaCosechaEstimada) { this.fechaCosechaEstimada = fechaCosechaEstimada; }
    public Double getSuperficieSembrada() { return superficieSembrada; }
    public void setSuperficieSembrada(Double superficieSembrada) { this.superficieSembrada = superficieSembrada; }
    public Long getIdParcela() { return idParcela; }
    public void setIdParcela(Long idParcela) { this.idParcela = idParcela; }
}