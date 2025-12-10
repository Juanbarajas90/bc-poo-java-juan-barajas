package com.bienesraices.modelo;

public interface Vendible {

    boolean verificarElegibilidadVenta();

    String generarReporteTransaccion(double precioFinal);

    double calcularComisionAsesor(double porcentaje);
}