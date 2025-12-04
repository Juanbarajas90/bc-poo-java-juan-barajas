public class Cliente {
    //Atributos de la clase Cliente
    private String identificacion;
    private String nombre;
    private String telefono;
    private String tipoCliente;

    // --- CONSTRUCTORES ---

    // Constructor 1: Completo
    public Cliente(String identificacion, String nombre, String telefono, String tipoCliente) {
        setIdentificacion(identificacion);
        setNombre(nombre);
        setTelefono(telefono);
        setTipoCliente(tipoCliente);
    }

    // Constructor 2: Básico (Solo Nombre y Teléfono - asigna ID y Tipo temporal)
    public Cliente(String nombre, String telefono) {
        this("ID_TEMP_" + telefono, nombre, telefono, "Pendiente");
        System.out.println("-> [Cliente]: Creado cliente sin ID ni Tipo definidos inicialmente.");
    }

    // --- MÉTODOS DE NEGOCIO ---

    public void solicitarInformacion(String codigoPropiedad) {
        System.out.println("Cliente " + this.nombre + " solicita detalles de la propiedad " + codigoPropiedad);
    }

    // --- GETTERS ---
    public String getIdentificacion() { return identificacion; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getTipoCliente() { return tipoCliente; }

    // --- SETTERS CON VALIDACIÓN ---

    public void setIdentificacion(String identificacion) {
        if (identificacion == null || identificacion.length() < 4) {
            throw new IllegalArgumentException("Identificación de cliente inválida.");
        }
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        // Validación simple de longitud (7-15)
        if (telefono == null || telefono.length() < 7 || telefono.length() > 15 || telefono.contains(" ")) {
            throw new IllegalArgumentException("Teléfono inválido. Use solo números y guiones (7-15 caracteres).");
        }
        this.telefono = telefono;
    }

    public void setTipoCliente(String tipoCliente) {
        String tipo = tipoCliente.toLowerCase();
        // Validación de rango válido (Solo estos 3 tipos son permitidos)
        if (!tipo.equals("comprador") && !tipo.equals("arrendador") && !tipo.equals("propietario") && !tipo.equals("pendiente")) {
            throw new IllegalArgumentException("Tipo de cliente inválido. Debe ser Comprador, Arrendador o Propietario.");
        }
        this.tipoCliente = tipoCliente;
    }
}