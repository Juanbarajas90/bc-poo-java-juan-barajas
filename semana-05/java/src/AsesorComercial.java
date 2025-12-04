import java.util.ArrayList;

/**
 * Clase AsesorComercial: Gestiona la información del personal de ventas.
 */
public class AsesorComercial {
    // Atributos de la clase
    private String identificacion;
    private String nombre;
    private String contacto;
    private int propiedadesVendidas;
    // Agregación con Propiedad (aunque no se use directamente aquí, es parte del modelo)
    private ArrayList<Propiedad> historialVentas;

    // --- CONSTRUCTOR SOBRECARGADO 1 (Completo) ---
    public AsesorComercial(String identificacion, String nombre, String contacto) {
        setIdentificacion(identificacion);
        setNombre(nombre);
        setContacto(contacto);
        this.propiedadesVendidas = 0;
        this.historialVentas = new ArrayList<>();
    }

    // --- CONSTRUCTOR SOBRECARGADO 2 (Básico - Semana 03) ---
    public AsesorComercial(String identificacion, String nombre) {
        this(identificacion, nombre, "Contacto Pendiente");
    }

    // --- MÉTODOS DE NEGOCIO ---

    public void registrarVenta(Propiedad propiedadVendida) {
        if (propiedadVendida != null) {
            this.historialVentas.add(propiedadVendida);
            this.propiedadesVendidas++; // Usa el setter para la validación
        }
    }

    // --- GETTERS ---
    public String getIdentificacion() { return identificacion; }
    public String getNombre() { return nombre; }
    public String getContacto() { return contacto; }
    public int getPropiedadesVendidas() { return propiedadesVendidas; }
    public ArrayList<Propiedad> getHistorialVentas() { return historialVentas; }

    // --- SETTERS CON VALIDACIÓN ---
    public void setIdentificacion(String identificacion) {
        if (identificacion == null || identificacion.length() < 5) {
            throw new IllegalArgumentException("La identificación debe tener al menos 5 caracteres.");
        }
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setPropiedadesVendidas(int propiedadesVendidas) {
        if (propiedadesVendidas < 0) {
            throw new IllegalArgumentException("El número de propiedades vendidas no puede ser negativo.");
        }
        this.propiedadesVendidas = propiedadesVendidas;
    }
}