public class AsesorComercial {
    // Atributos privados del Asesor Comercial
    private String identificacion;
    private String nombre;
    private String contacto;
    private int propiedadesVendidas;

    // constructor que inicializa los atributos del Asesor Comercial
    public AsesorComercial(String identificacion, String nombre, String contacto) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.contacto = contacto;
        this.propiedadesVendidas = 0;
    }

    // Metodo para mostrar los datos del Asesor Comercial (void)
    public void mostrarDatos() {
        System.out.println("\n--- ASESOR COMERCIAL: " + this.nombre + " ---");
        System.out.println("ID: " + this.identificacion);
        System.out.println("Contacto: " + this.contacto);
        System.out.println("Ventas Acumuladas: " + this.propiedadesVendidas);
    }

    // Metodo que registra la venta exitosa (modifica el estado interno)
    public void registrarVentaExitosa() {
        this.propiedadesVendidas++;
        System.out.println("¡Venta registrada para " + this.nombre + "!");
    }

    // Metodo para calcular el bono (retorna un valor)
    public double calcularBonoPorVenta(double valorBonoFijo) {
        return this.propiedadesVendidas * valorBonoFijo;
    }

    // --- Getters ---
    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public int getPropiedadesVendidas() {
        return propiedadesVendidas;
    }

    // --- Setters ---
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setPropiedadesVendidas(int propiedadesVendidas) {
        this.propiedadesVendidas = propiedadesVendidas;
    }
}