package abstractas;

// Clase Abstracta para Propiedades (Ejercicio 1)
public abstract class Propiedad {
    // Atributos protegidos (visibles para subclases)
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

    // --- MÉTODO ABSTRACTO 1: Costo Adicional (Implementación variable) ---
    public abstract double calcularCostoAdicional();

    // --- MÉTODO ABSTRACTO 2: Descripción Detallada (Implementación variable) ---
    public abstract String obtenerDescripcionDetallada();

    // --- MÉTODO CONCRETO 1: Comportamiento Común ---
    public double calcularPrecioVentaFinal() {
        // Fórmula común: Precio base + Costo adicional + 5% de comisión
        return this.precioBase + calcularCostoAdicional() + (this.precioBase * 0.05);
    }

    // --- MÉTODO CONCRETO 2: Comportamiento Común (Mostrar Info Base) ---
    public void mostrarInfoBase() {
        System.out.println("ID: " + this.codigo + " | Dirección: " + this.direccion);
        System.out.println("Área: " + this.areaM2 + " m² | Disponible: " + (this.estaDisponible ? "Sí" : "No"));
        System.out.printf("Precio Base: $%.2f%n", this.precioBase);
    }

    // --- GETTERS y SETTERS (Solo los esenciales por brevedad) ---
    public String getCodigo() { return codigo; }
    public double getPrecioBase() { return precioBase; }
}