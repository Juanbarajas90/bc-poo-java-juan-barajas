public class Propiedad {
    // Atributos (Informacion de la propiedad)
    private String codigo;
    private String direccion;
    private double precioBase;
    private int areaM2;
    private boolean estaDisponible;

    // Constructor que inicializa los atributos
    public Propiedad(String codigo, String direccion, double precioBase, int areaM2) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.precioBase = precioBase;
        this.areaM2 = areaM2;
        this.estaDisponible = true;
    }

    // Metodo para mostrar informacion (void)
    public void mostrarInformacion() {
        System.out.println("DETALLES DE LA PROPIEDAD: " + this.codigo );
        System.out.println("Ubicación: " + this.direccion + " (" + this.areaM2 + " m²)");
        System.out.println("Precio Base: $" + this.precioBase);
        String estado = this.estaDisponible ? "DISPONIBLE" : "NO DISPONIBLE (VENDIDA/ARRENDADA)";
        System.out.println("Estado actual: " + estado);
    }

    // Metodo para calcular el precio final (retorna un valor)
    public double calcularPrecioFinal(double porcentajeIncremento) {
        return this.precioBase * (1 + porcentajeIncremento);
    }

    // --- Getters ---
    public String getCodigo() {
        return this.codigo;
    }

    public String getDireccion() { // Necesario para Contrato
        return this.direccion;
    }

    public double getPrecioBase() {
        return this.precioBase;
    }

    public int getAreaM2() {
        return this.areaM2;
    }

    public boolean isEstaDisponible() { // Necesario para Portafolio
        return this.estaDisponible;
    }

    // --- Setters ---
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public void setAreaM2(int areaM2) {
        this.areaM2 = areaM2;
    }

    public void setDisponible(boolean nuevoEstado) {
        if (this.estaDisponible != nuevoEstado) {
            System.out.println("Estado de la propiedad " + this.codigo + " actualizado.");
            this.estaDisponible = nuevoEstado;
        }
    }
}