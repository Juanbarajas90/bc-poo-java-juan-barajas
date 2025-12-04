public class AsesorComercial {
    // Atributos privados del Asesor Comercial
    private String identificacion;    // ID de empleado o cedula.
    private String nombre;            // Nombre completo del asesor.
    private String contacto;          // Teléfono o correo.
    private int propiedadesVendidas;  // Contador de transacciones exitosas.

    // constructor que inicializa los atributos del Asesor Comercial
    public AsesorComercial(String identificacion, String nombre, String contacto) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.contacto = contacto;
        this.propiedadesVendidas = 0; // Inicialmente no tiene ventas.
    }

    // Metodo para mostrar los datos del Asesor Comercial
    public void mostrarDatos() {
        System.out.println("\n--- ASESOR COMERCIAL: " + this.nombre + " ---");
        System.out.println("ID: " + this.identificacion);
        System.out.println("Contacto: " + this.contacto);
        System.out.println("Ventas Acumuladas: " + this.propiedadesVendidas);
    }

    // Metodo que registra la venta exitosa)
    public void registrarVentaExitosa() {
        this.propiedadesVendidas++;
        System.out.println("¡Venta registrada para " + this.nombre + "!");
    }

    // Metodo para calcular el bono
    public double calcularBonoPorVenta(double valorBonoFijo) {
        // Calcula el bono total multiplicando las ventas por el bono fijo.
        return this.propiedadesVendidas * valorBonoFijo;
    }

    // Getter para obtener nombre
    public String getNombre() {
        return this.nombre;
    }

    // Getter para obtener el valor de las propiedades vendidas
    public int getPropiedadesVendidas() {
        return this.propiedadesVendidas;
    }
}