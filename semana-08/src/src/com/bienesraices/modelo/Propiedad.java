package com.bienesraices.modelo;

// Clase Abstracta para Propiedades
public abstract class Propiedad {
    protected String codigo;
    protected String direccion;
    protected double precioBase;
    protected int areaM2;
    public boolean estaDisponible; // Público solo para el Ejercicio 3.1 de S08

    public Propiedad(String codigo, String direccion, double precioBase, int areaM2) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.precioBase = precioBase;
        this.areaM2 = areaM2;
        this.estaDisponible = true;
    }

    public abstract double calcularCostoAdicional();
    public abstract String obtenerDescripcionDetallada();

    public double calcularPrecioVentaFinal() {
        return this.precioBase + calcularCostoAdicional() + (this.precioBase * 0.05);
    }

    public void mostrarInfoBase() {
        System.out.println("ID: " + this.codigo + " | Dirección: " + this.direccion);
        System.out.println("Área: " + this.areaM2 + " m² | Disponible: " + (this.estaDisponible ? "Sí" : "No"));
        System.out.printf("Precio Base: $%.2f%n", this.precioBase);
    }

    public String getCodigo() { return codigo; }
    public double getPrecioBase() { return precioBase; }

    // Validación de Semana 07
    public void setPrecioBase(double precioBase) {
        if (precioBase <= 0) {
            throw new IllegalArgumentException("El precio base debe ser mayor a cero.");
        }
        this.precioBase = precioBase;
    }

    // Validación de Semana 07
    public void setAreaM2(int areaM2) {
        if (areaM2 <= 0) {
            throw new IllegalArgumentException("El área en m2 debe ser mayor a cero.");
        }
        this.areaM2 = areaM2;
    }
}