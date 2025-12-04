public class Cliente {
    //Atributos de la clase cliente
    private String identificacion;
    private String nombre;
    private String telefono;
    private String tipoCliente; // Valores válidos: Comprador, Arrendador, Propietario, Pendiente

    // --- CONSTRUCTOR SOBRECARGADO 1 (Completo) ---
    public Cliente(String identificacion, String nombre, String telefono, String tipoCliente) {
        setIdentificacion(identificacion);
        setNombre(nombre);
        setTelefono(telefono);
        setTipoCliente(tipoCliente);
    }

    // --- CONSTRUCTOR SOBRECARGADO 2 (Básico - Semana 03) ---
    public Cliente(String nombre, String telefono) {
        this("ID_PENDIENTE", nombre, telefono, "Pendiente");
    }

    // --- GETTERS ---
    public String getIdentificacion() { return identificacion; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getTipoCliente() { return tipoCliente; }

    // --- SETTERS CON VALIDACIÓN ---
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.length() < 7 || telefono.length() > 15) {
            throw new IllegalArgumentException("El teléfono debe tener entre 7 y 15 dígitos.");
        }
        this.telefono = telefono;
    }

    public void setTipoCliente(String tipoCliente) {
        String tipo = tipoCliente.toLowerCase();
        if (tipo.equals("comprador") || tipo.equals("arrendador") || tipo.equals("propietario") || tipo.equals("pendiente")) {
            this.tipoCliente = tipoCliente;
        } else {
            throw new IllegalArgumentException("Tipo de cliente inválido. Debe ser: Comprador, Arrendador, Propietario o Pendiente.");
        }
    }
}