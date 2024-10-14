package com.ejemplo.model;

import java.util.Date;

public class Cosecha {
    private int id;
    private Date fechaCosecha;
    private String tipoFruta;
    private double cantidadKg;

    // Constructor vacío
    public Cosecha() {}

    // Constructor con parámetros
    public Cosecha(int id, Date fechaCosecha, String tipoFruta, double cantidadKg) {
        this.id = id;
        this.fechaCosecha = fechaCosecha;
        this.tipoFruta = tipoFruta;
        this.cantidadKg = cantidadKg;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaCosecha() {
        return fechaCosecha;
    }

    public void setFechaCosecha(Date fechaCosecha) {
        this.fechaCosecha = fechaCosecha;
    }

    public String getTipoFruta() {
        return tipoFruta;
    }

    public void setTipoFruta(String tipoFruta) {
        this.tipoFruta = tipoFruta;
    }

    public double getCantidadKg() {
        return cantidadKg;
    }

    public void setCantidadKg(double cantidadKg) {
        this.cantidadKg = cantidadKg;
    }
}
