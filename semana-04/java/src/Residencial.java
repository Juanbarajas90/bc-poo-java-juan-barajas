public class Residencial extends Propiedad {
    // Atributo específico de la subclase
    private int numeroHabitaciones;
    private boolean tieneParqueadero;

    // --- CONSTRUCTOR ---
    public Residencial(String codigo, String direccion, double precioBase, int areaM2,
                       int numeroHabitaciones, boolean tieneParqueadero) {
        // Uso de super() para llamar al constructor del padre
        super(codigo, direccion, precioBase, areaM2);

        // Validación específica
        if (numeroHabitaciones <= 0) {
            throw new IllegalArgumentException("Una propiedad residencial debe tener al menos 1 habitación.");
        }
        this.numeroHabitaciones = numeroHabitaciones;
        this.tieneParqueadero = tieneParqueadero;
    }

    // --- MeTODO SOBRESCRITO (Override) ---
    @Override
    public double calcularImpuestos(double tasaBase) {
        // Unidades residenciales tienen un descuento del 10% en impuestos.
        double impuestoBase = super.calcularImpuestos(tasaBase);
        double descuento = impuestoBase * 0.10;

        return impuestoBase - descuento;
    }

    // --- MeTODO HEREDADO y EXTENDIDO ---
    @Override
    public void mostrarInfo() {
        System.out.println("TIPO: Propiedad Residencial");
        super.mostrarInfo(); // Llama al método del padre para mostrar datos base
        String parqueadero = this.tieneParqueadero ? "Sí" : "No";
        System.out.println("Detalles: " + this.numeroHabitaciones + " habitaciones | Parqueadero: " + parqueadero);
    }

    // --- GETTERS y SETTERS ESPECÍFICOS ---
    public int getNumeroHabitaciones() { return numeroHabitaciones; }
    public void setNumeroHabitaciones(int numeroHabitaciones) { this.numeroHabitaciones = numeroHabitaciones; }
}