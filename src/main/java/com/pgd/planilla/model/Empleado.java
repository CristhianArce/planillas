package com.pgd.planilla.model;

import java.math.BigDecimal;

public class Empleado {
    private int id;
    private String nombre;
    private BigDecimal montoMensual;
    private boolean activo;

    public Empleado(int id, String nombre, BigDecimal montoMensual, boolean activo) {
        if (nombre.isBlank() || nombre.isEmpty()) throw new RuntimeException("Un empleado no puede tener un nombre vacío.");
        this.id = id;
        this.nombre = nombre;
        this.montoMensual = montoMensual;
        this.activo = activo;
    }

    public BigDecimal getMontoMensual() {
        return montoMensual;
    }

    public boolean isActivo() {
        return activo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", montoMensual=" + montoMensual +
                ", activo=" + activo +
                '}';
    }
}
