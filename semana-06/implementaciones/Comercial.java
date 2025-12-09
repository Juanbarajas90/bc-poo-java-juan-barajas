package implementaciones;

import abstractas.Propiedad;
import interfaces.Vendible;

// Clase Concreta 2 (Implementa 1 Interface)
public class Comercial extends Propiedad implements Vendible {
    private String usoPrincipal;
    private int numeroPisos;

    // Constructor de Subclase (llama a super())
    public Comercial(String codigo, String direccion, double precioBase, int areaM2,
                     String usoPrincipal, int numeroPisos) {
        super(codigo, direccion, precioBase, areaM2);
        this.usoPrincipal = usoPrincipal;
        this.numeroPisos = numeroPisos;
    }

    // --- IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS DE PROPIEDAD ---

    @Override
    public double calcularCostoAdicional() {
        // Costo adicional Comercial: 0.5% por piso
        return this.precioBase * (0.005 * numeroPisos);
    }

    @Override
    public String obtenerDescripcionDetallada() {
        return String.format("Comercial | Uso: %s | %d Pisos",
                this.usoPrincipal, this.numeroPisos);
    }

    // --- IMPLEMENTACIÓN DE INTERFACE VENDIBLE ---

    @Override
    public boolean verificarElegibilidadVenta() {
        // Una propiedad comercial es elegible si vale más de 500M.
        return this.precioBase > 500000000.0 && this.estaDisponible;
    }

    @Override
    public String generarReporteTransaccion(double precioFinal) {
        return String.format("REPORTE VENTA COMERCIAL: Código %s. Precio Final: $%.2f. Uso: %s",
                this.codigo, precioFinal, this.usoPrincipal);
    }

    @Override
    public double calcularComisionAsesor(double porcentaje) {
        // Comisión base con recargo del 5% por alto valor comercial.
        return (this.precioBase * porcentaje) * 1.05;
    }
}