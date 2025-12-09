package com.bienesraices.modelo;

// Clase Concreta 1 (Implementa Múltiples Interfaces)
public class Residencial extends Propiedad implements Vendible, Mantenible {
    private int numeroHabitaciones;
    private boolean tieneGaraje;

    // Constructor de Subclase
    public Residencial(String codigo, String direccion, double precioBase, int areaM2,
                       int numeroHabitaciones, boolean tieneGaraje) {
        super(codigo, direccion, precioBase, areaM2);
        this.numeroHabitaciones = numeroHabitaciones;
        this.tieneGaraje = tieneGaraje;
    }

    // --- IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS DE PROPIEDAD ---

    @Override
    public double calcularCostoAdicional() {
        return this.precioBase * (0.001 * numeroHabitaciones);
    }

    @Override
    public String obtenerDescripcionDetallada() {
        return String.format("Residencial | %d Hab | Garaje: %s",
                this.numeroHabitaciones, this.tieneGaraje ? "Sí" : "No");
    }

    // --- IMPLEMENTACIÓN DE INTERFACE VENDIBLE ---

    @Override
    public boolean verificarElegibilidadVenta() {
        return this.numeroHabitaciones >= 2 && this.estaDisponible;
    }

    @Override
    public String generarReporteTransaccion(double precioFinal) {
        return String.format("REPORTE VENTA RESIDENCIAL: Código %s. Precio Final: $%.2f",
                this.codigo, precioFinal);
    }

    @Override
    public double calcularComisionAsesor(double porcentaje) {
        double comisionBase = this.precioBase * porcentaje;
        return this.tieneGaraje ? comisionBase * 1.10 : comisionBase;
    }

    // --- IMPLEMENTACIÓN DE INTERFACE MANTENIBLE ---

    @Override
    public int obtenerFrecuenciaInspeccionDias() {
        return 90;
    }

    @Override
    public void realizarMantenimiento(String tarea) {
        System.out.printf("[MANTENIMIENTO %s]: Tarea '%s' realizada.%n", this.codigo, tarea);
    }
}