public class Contrato {
    //Atributos de la clase Contrato
    private String numeroContrato;
    private String tipoTransaccion;
    private double valorAcordado;

    // Relaciones (Agregación)
    private Propiedad propiedad;
    private Cliente cliente;
    private AsesorComercial asesor;

    // --- CONSTRUCTORES (Mínimo 2) ---

    // Constructor 1: Completo (Agregación de objetos y validación de valor)
    public Contrato(String numeroContrato, String tipoTransaccion, double valorAcordado,
                    Propiedad propiedad, Cliente cliente, AsesorComercial asesor) {
        setNumeroContrato(numeroContrato);
        setTipoTransaccion(tipoTransaccion);
        setValorAcordado(valorAcordado);
        setPropiedad(propiedad); // Usa Setter para validar que no sea null
        setCliente(cliente);     // Usa Setter para validar que no sea null
        setAsesor(asesor);       // Usa Setter para validar que no sea null
    }

    // Constructor 2: Básico (Solo valor, propiedad y tipo. Asesores/Clientes pendientes)
    public Contrato(String numeroContrato, String tipoTransaccion, double valorAcordado, Propiedad propiedad) {
        // Llama al constructor completo con valores temporales o nulos para la agregación
        this(numeroContrato, tipoTransaccion, valorAcordado, propiedad, null, null);
        System.out.println("-> [Contrato]: Creado contrato pendiente de asignación de Cliente/Asesor.");
    }

    // --- MÉTODOS DE NEGOCIO Y UTILITARIOS ---

    public double calcularComisionAgencia(double porcentaje) {
        return this.valorAcordado * porcentaje;
    }

    public void generarResumen() {
        System.out.println("\n--- CONTRATO No. " + this.numeroContrato + " (" + this.tipoTransaccion + ") ---");
        // Se debe verificar si los objetos agregados son null antes de usarlos
        String propInfo = (propiedad != null) ? propiedad.getCodigo() + " en " + propiedad.getDireccion() : "Propiedad NO ASIGNADA";
        String clienteInfo = (cliente != null) ? cliente.getNombre() : "Cliente NO ASIGNADO";

        System.out.println("Propiedad: " + propInfo);
        System.out.println("Cliente: " + clienteInfo);
        System.out.println("Asesor: " + (asesor != null ? asesor.getNombre() : "NO ASIGNADO"));
        System.out.println("Valor Total Acordado: $" + this.valorAcordado);
    }

    // --- GETTERS (Se mantienen todos) ---
    public String getNumeroContrato() { return numeroContrato; }
    public String getTipoTransaccion() { return tipoTransaccion; }
    public double getValorAcordado() { return valorAcordado; }
    public Propiedad getPropiedad() { return propiedad; }
    public Cliente getCliente() { return cliente; }
    public AsesorComercial getAsesor() { return asesor; }

    // --- SETTERS CON VALIDACIÓN ---

    public void setNumeroContrato(String numeroContrato) {
        if (numeroContrato == null || numeroContrato.length() < 5) {
            throw new IllegalArgumentException("Número de contrato inválido (mínimo 5 caracteres).");
        }
        this.numeroContrato = numeroContrato;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        String tipo = tipoTransaccion.toLowerCase();
        if (!tipo.equals("venta") && !tipo.equals("arriendo")) {
            throw new IllegalArgumentException("Tipo de transacción debe ser 'Venta' o 'Arriendo'.");
        }
        this.tipoTransaccion = tipoTransaccion;
    }

    public void setValorAcordado(double valorAcordado) {
        if (valorAcordado <= 100000.0) { // Valor mínimo de transacción
            throw new IllegalArgumentException("El valor acordado debe ser superior a $100.000.");
        }
        this.valorAcordado = valorAcordado;
    }

    // Setters para AGREGACIÓN (Validan que el objeto no sea nulo)
    public void setPropiedad(Propiedad propiedad) {
        if (propiedad == null) {
            throw new IllegalArgumentException("El contrato debe estar asociado a una Propiedad válida.");
        }
        this.propiedad = propiedad;
    }

    public void setCliente(Cliente cliente) {
        // Permitimos que sea null inicialmente, pero si se asigna, debe ser válido
        this.cliente = cliente;
    }

    public void setAsesor(AsesorComercial asesor) {
        this.asesor = asesor;
    }
}