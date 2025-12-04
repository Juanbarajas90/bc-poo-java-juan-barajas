public class Residencial extends Propiedad {
    private int numeroHabitaciones;
    private boolean tieneParqueadero;

    // --- CONSTRUCTOR ---
    public Residencial(String codigo, String direccion, double precioBase, int areaM2,
                       int numeroHabitaciones, boolean tieneParqueadero) {
        super(codigo, direccion, precioBase, areaM2);

        if (numeroHabitaciones <= 0) {
            throw new IllegalArgumentException("Una propiedad residencial debe tener al menos 1 habitación.");
        }
        this.numeroHabitaciones = numeroHabitaciones;
        this.tieneParqueadero = tieneParqueadero;
    }

    // --- MÉTODOS SOBRESCRITOS (@Override - Semana 05) ---

    @Override
    public String obtenerDescripcion() {
        String parqueadero = this.tieneParqueadero ? "con parqueadero" : "sin parqueadero";
        return "Residencial: " + this.codigo + " (" + this.numeroHabitaciones + " hab., " + parqueadero + ")";
    }

    @Override
    public double calcularComisionAgencia(double porcentajeBase) {
        // Sobrescribe: las residenciales tienen un descuento del 1% en la comisión
        double comisionBase = super.calcularComisionAgencia(porcentajeBase);
        double descuento = this.precioBase * 0.01;
        return comisionBase - descuento;
    }

    // --- MÉTODOS SOBRESCRITOS (@Override - Semana 04) ---

    @Override
    public double calcularImpuestos(double tasaBase) {
        // Unidades residenciales tienen un descuento del 10% en impuestos.
        double impuestoBase = super.calcularImpuestos(tasaBase);
        double descuento = impuestoBase * 0.10;

        return impuestoBase - descuento;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("TIPO: Propiedad Residencial");
        super.mostrarInfo();
        String parqueadero = this.tieneParqueadero ? "Sí" : "No";
        System.out.println("Detalles: " + this.numeroHabitaciones + " habitaciones | Parqueadero: " + parqueadero);
    }

    // --- GETTERS y SETTERS ESPECÍFICOS ---
    public int getNumeroHabitaciones() { return numeroHabitaciones; }
    public void setNumeroHabitaciones(int numeroHabitaciones) { this.numeroHabitaciones = numeroHabitaciones; }
}