package com.example.productores_agricolas.models;

import java.time.LocalDate;

public class Cultivo {
    private Long id;
    private String nombreCultivo;
    private LocalDate fechaSiembra;
    private LocalDate fechaCosechaEstimada;
    private Double superficieSembrada;
    private String estado;
    private Long idParcela;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombreCultivo() { return nombreCultivo; }
    public void setNombreCultivo(String nombreCultivo) { this.nombreCultivo = nombreCultivo; }
    public LocalDate getFechaSiembra() { return fechaSiembra; }
    public void setFechaSiembra(LocalDate fechaSiembra) { this.fechaSiembra = fechaSiembra; }
    public LocalDate getFechaCosechaEstimada() { return fechaCosechaEstimada; }
    public void setFechaCosechaEstimada(LocalDate fechaCosechaEstimada) { this.fechaCosechaEstimada = fechaCosechaEstimada; }
    public Double getSuperficieSembrada() { return superficieSembrada; }
    public void setSuperficieSembrada(Double superficieSembrada) { this.superficieSembrada = superficieSembrada; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Long getIdParcela() { return idParcela; }
    public void setIdParcela(Long idParcela) { this.idParcela = idParcela; }
}