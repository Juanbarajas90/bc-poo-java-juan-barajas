package com.bienesraices.modelo;

public class Comercial extends Propiedad implements Vendible {
    private String usoPrincipal;
    private int numeroPisos;

    public Comercial(String codigo, String direccion, double precioBase, int areaM2,
                     String usoPrincipal, int numeroPisos) {
        super(codigo, direccion, precioBase, areaM2);
        this.usoPrincipal = usoPrincipal;
        this.numeroPisos = numeroPisos;
    }

    @Override
    public double calcularCostoAdicional() {
        return this.precioBase * (0.005 * numeroPisos);
    }

    @Override
    public String obtenerDescripcionDetallada() {
        return String.format("Comercial | Uso: %s | %d Pisos",
                this.usoPrincipal, this.numeroPisos);
    }

    // Implementación Vendible
    @Override
    public boolean verificarElegibilidadVenta() {
        return this.precioBase > 500000000.0 && this.estaDisponible;
    }
    @Override
    public String generarReporteTransaccion(double precioFinal) {
        return String.format("REPORTE VENTA COMERCIAL: Código %s. Precio Final: $%.2f. Uso: %s",
                this.codigo, precioFinal, this.usoPrincipal);
    }
    @Override
    public double calcularComisionAsesor(double porcentaje) {
        return (this.precioBase * porcentaje) * 1.05;
    }
}
