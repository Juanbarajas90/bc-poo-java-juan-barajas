package com.bienesraices.modelo;

// Clase Abstracta para Propiedades
public abstract class Propiedad {
    // Atributos protegidos
    protected String codigo;
    protected String direccion;
    protected double precioBase;
    protected int areaM2;
    protected boolean estaDisponible;

    // --- CONSTRUCTOR ---
    public Propiedad(String codigo, String direccion, double precioBase, int areaM2) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.precioBase = precioBase;
        this.areaM2 = areaM2;
        this.estaDisponible = true;
    }

    // --- MÉTODOS ABSTRACTOS ---
    public abstract double calcularCostoAdicional();
    public abstract String obtenerDescripcionDetallada();

    // --- MÉTODOS CONCRETOS ---
    public double calcularPrecioVentaFinal() {
        // Fórmula común: Precio base + Costo adicional + 5% de comisión
        return this.precioBase + calcularCostoAdicional() + (this.precioBase * 0.05);
    }

    public void mostrarInfoBase() {
        System.out.println("ID: " + this.codigo + " | Dirección: " + this.direccion);
        System.out.println("Área: " + this.areaM2 + " m² | Disponible: " + (this.estaDisponible ? "Sí" : "No"));
        System.out.printf("Precio Base: $%.2f%n", this.precioBase);
    }

    // --- GETTERS y SETTERS ---
    public String getCodigo() { return codigo; }
    public double getPrecioBase() { return precioBase; }

    // Nuevo setter con validación (Ejercicio 2)
    public void setPrecioBase(double precioBase) {
        if (precioBase <= 0) {
            throw new IllegalArgumentException("El precio base debe ser mayor a cero.");
        }
        this.precioBase = precioBase;
    }

    // Nuevo setter con validación (Ejercicio 2)
    public void setAreaM2(int areaM2) {
        if (areaM2 <= 0) {
            throw new IllegalArgumentException("El área en m2 debe ser mayor a cero.");
        }
        this.areaM2 = areaM2;
    }
}