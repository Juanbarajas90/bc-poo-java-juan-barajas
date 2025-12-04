public class Contrato {
    // Atributos privados del Contrato
    private String numeroContrato;
    private String tipoTransaccion;
    private double valorAcordado;

    // Relaciones
    private Propiedad propiedad;
    private Cliente cliente;
    private AsesorComercial asesor;

    // Constructor que recibe objetos completos
    public Contrato(String numeroContrato, String tipoTransaccion, double valorAcordado,
                    Propiedad propiedad, Cliente cliente, AsesorComercial asesor) {
        this.numeroContrato = numeroContrato;
        this.tipoTransaccion = tipoTransaccion;
        this.valorAcordado = valorAcordado;
        this.propiedad = propiedad;
        this.cliente = cliente;
        this.asesor = asesor;
    }

    // Metodo de negocio: Calcula la comision que gana la agencia (retorna valor)
    public double calcularComisionAgencia(double porcentaje) {
        return this.valorAcordado * porcentaje;
    }

    // Metodo auxiliar para mostrar el resumen del contrato (void)
    public void generarResumen() {
        System.out.println("\n--- CONTRATO No. " + this.numeroContrato + " (" + this.tipoTransaccion + ") ---");
        // Usamos los Getters de los objetos contenidos
        System.out.println("Propiedad: " + propiedad.getCodigo() + " en " + propiedad.getDireccion());
        System.out.println("Cliente: " + cliente.getNombre() + " (" + cliente.getTipoCliente() + ")");
        System.out.println("Asesor a cargo: " + asesor.getNombre());
        System.out.println("Valor Total Acordado: $" + this.valorAcordado);
    }

    // --- Getters ---
    public String getNumeroContrato() {
        return numeroContrato;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public double getValorAcordado() {
        return valorAcordado;
    }

    // --- Setters ---
    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public void setValorAcordado(double valorAcordado) {
        this.valorAcordado = valorAcordado;
    }
}
