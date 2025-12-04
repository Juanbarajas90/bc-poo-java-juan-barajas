public class Cliente {
    // Atributos privados del cliente
    private String identificacion;
    private String nombre;
    private String telefono;
    private String tipoCliente; // (Ej: Comprador, Arrendador, Propietario)

    // Constructor completo
    public Cliente(String identificacion, String nombre, String telefono, String tipoCliente) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipoCliente = tipoCliente;
    }

    // Metodo de negocio: El cliente solicita informacion
    public void solicitarInformacion(String codigoPropiedad) {
        System.out.println("Cliente " + this.nombre + " solicita detalles de la propiedad " + codigoPropiedad);
    }

    // --- Getters ---
    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    // --- Setters ---
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
