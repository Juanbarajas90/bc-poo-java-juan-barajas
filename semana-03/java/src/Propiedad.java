public class Propiedad {
    //Atributos de la clase Propiedad
    private String codigo;
    private String direccion;
    private double precioBase;
    private int areaM2;
    private boolean estaDisponible;

    // --- CONSTRUCTORES ---

    // Constructor 1: Completo 
    public Propiedad(String codigo, String direccion, double precioBase, int areaM2) {
        setCodigo(codigo);
        setDireccion(direccion);
        setPrecioBase(precioBase);
        setAreaM2(areaM2);
        this.estaDisponible = true;
    }

    // Constructor 2: Básico (Sin área - llama al completo con valor por defecto 40)
    public Propiedad(String codigo, String direccion, double precioBase) {
        this(codigo, direccion, precioBase, 40);
        System.out.println("-> [Propiedad]: Creada propiedad básica sin área especificada.");
    }

    // --- MÉTODOS DE NEGOCIO ---

    public void mostrarInformacion() {
        System.out.println("DETALLES DE LA PROPIEDAD: " + this.codigo );
        System.out.println("Ubicación: " + this.direccion + " (" + this.areaM2 + " m²)");
        System.out.println("Precio Base: $" + this.precioBase);
        String estado = this.estaDisponible ? "DISPONIBLE" : "NO DISPONIBLE (VENDIDA/ARRENDADA)";
        System.out.println("Estado actual: " + estado);
    }

    public double calcularPrecioFinal(double porcentajeIncremento) {
        return this.precioBase * (1 + porcentajeIncremento);
    }

    // --- GETTERS ---
    public String getCodigo() { return this.codigo; }
    public String getDireccion() { return this.direccion; }
    public double getPrecioBase() { return this.precioBase; }
    public int getAreaM2() { return this.areaM2; }
    public boolean isEstaDisponible() { return this.estaDisponible; }

    // --- SETTERS CON VALIDACIÓN ---

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty() || codigo.length() < 3) {
            throw new IllegalArgumentException("El código de la propiedad es inválido (mínimo 3 caracteres).");
        }
        this.codigo = codigo;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }
        this.direccion = direccion;
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase <= 0) {
            throw new IllegalArgumentException("El precio base debe ser un valor positivo.");
        }
        this.precioBase = precioBase;
    }

    public void setAreaM2(int areaM2) {
        if (areaM2 < 10) {
            throw new IllegalArgumentException("El área en m² debe ser de al menos 10.");
        }
        this.areaM2 = areaM2;
    }

    public void setDisponible(boolean nuevoEstado) {
        this.estaDisponible = nuevoEstado;
    }
}