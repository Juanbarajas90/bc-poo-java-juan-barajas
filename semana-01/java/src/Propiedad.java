public class Propiedad {
    // Atributos (Informacion de la propiedad)
    private String codigo;        // Identificador único.
    private String direccion;     // La ubicación del inmueble.
    private double precioBase;    // El valor de venta o arriendo inicial.
    private int areaM2;           // El tamaño en metros cuadrados.
    private boolean estaDisponible; // True si está lista para negociar.

    // Constructor que inicializa los atributos
    public Propiedad(String codigo, String direccion, double precioBase, int areaM2) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.precioBase = precioBase;
        this.areaM2 = areaM2;
        this.estaDisponible = true; // Por defecto, se considera disponible al registrarla.
    }

    // Meotodo para mostrar informacion
    public void mostrarInformacion() {
        System.out.println("DETALLES DE LA PROPIEDAD: " + this.codigo );
        System.out.println("Ubicación: " + this.direccion + " (" + this.areaM2 + " m²)");
        System.out.println("Precio Base: $" + this.precioBase);
        String estado = this.estaDisponible ? "DISPONIBLE" : "NO DISPONIBLE (VENDIDA/ARRENDADA)";
        System.out.println("Estado actual: " + estado);
    }

    // Metodo para calcular el precio final
    public double calcularPrecioFinal(double porcentajeIncremento) {
        // Se multiplica el precio base por (1 + el porcentaje)
        return this.precioBase * (1 + porcentajeIncremento);
    }

    // Metodo para acceder al codigo de la propiedad
    public String getCodigo() {
        return this.codigo;
    }

    // Metodo para cambiar el estado de la propiedad
    public void setDisponible(boolean nuevoEstado) {
        if (this.estaDisponible != nuevoEstado) {
            System.out.println("Estado de la propiedad " + this.codigo + " actualizado.");
            this.estaDisponible = nuevoEstado;
        }
    }
}