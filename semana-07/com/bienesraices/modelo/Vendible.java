package com.bienesraices.modelo;

// Interface 1: Define la capacidad de ser vendido o liquidado
public interface Vendible {

    boolean verificarElegibilidadVenta();

    String generarReporteTransaccion(double precioFinal);

    double calcularComisionAsesor(double porcentaje);
}