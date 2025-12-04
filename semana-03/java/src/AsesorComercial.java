public class AsesorComercial {
    //Atributos de la clase Asesor Comericla
    private String identificacion;
    private String nombre;
    private String contacto;
    private int propiedadesVendidas;

    // --- CONSTRUCTORES ---

    // Constructor 1: Completo
    public AsesorComercial(String identificacion, String nombre, String contacto) {
        setIdentificacion(identificacion);
        setNombre(nombre);
        setContacto(contacto);
        this.propiedadesVendidas = 0;
    }

    // Constructor 2: Básico (Solo ID y Nombre - asigna contacto pendiente)
    public AsesorComercial(String identificacion, String nombre) {
        this(identificacion, nombre, "Contacto Pendiente");
        System.out.println("-> [Asesor]: Creado asesor con contacto pendiente.");
    }

    // Constructor 3: Mínimo (Solo ID - llama al anterior)
    public AsesorComercial(String identificacion) {
        this(identificacion, "Asesor Nuevo " + identificacion);
    }

    // --- MÉTODOS DE NEGOCIO ---

    public void mostrarDatos() {
        System.out.println("\n--- ASESOR COMERCIAL: " + this.nombre + " ---");
        System.out.println("ID: " + this.identificacion);
        System.out.println("Contacto: " + this.contacto);
        System.out.println("Ventas Acumuladas: " + this.propiedadesVendidas);
    }

    public void registrarVentaExitosa() {
        this.propiedadesVendidas++;
        System.out.println("¡Venta registrada para " + this.nombre + "!");
    }

    public double calcularBonoPorVenta(double valorBonoFijo) {
        return this.propiedadesVendidas * valorBonoFijo;
    }

    // --- GETTERS ---
    public String getIdentificacion() { return identificacion; }
    public String getNombre() { return nombre; }
    public String getContacto() { return contacto; }
    public int getPropiedadesVendidas() { return propiedadesVendidas; }

    // --- SETTERS CON VALIDACIÓN ---

    public void setIdentificacion(String identificacion) {
        if (identificacion == null || identificacion.length() < 5) {
            throw new IllegalArgumentException("Identificación debe tener al menos 5 caracteres.");
        }
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del asesor no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public void setContacto(String contacto) {
        if (contacto == null || contacto.trim().isEmpty()) {
            throw new IllegalArgumentException("El contacto del asesor no puede estar vacío.");
        }
        this.contacto = contacto;
    }

    public void setPropiedadesVendidas(int propiedadesVendidas) {
        if (propiedadesVendidas < 0) {
            throw new IllegalArgumentException("El contador de ventas no puede ser negativo.");
        }
        this.propiedadesVendidas = propiedadesVendidas;
    }
}