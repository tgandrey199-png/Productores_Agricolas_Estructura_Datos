package com.example.productores_agricolas.models;

public class Producto {
    private Long id;
    private String nombreProducto;
    private String descripcion;
    private String unidadMedida;
    private String categoria;
    private String temporadaProduccion;
    private String estado;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public String getTemporadaProduccion() { return temporadaProduccion; }
    public void setTemporadaProduccion(String temporadaProduccion) { this.temporadaProduccion = temporadaProduccion; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}