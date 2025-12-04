public class Comercial extends Propiedad {
    private String usoPrincipal;
    private boolean aptoParaAlimentos;

    // --- CONSTRUCTOR ---
    public Comercial(String codigo, String direccion, double precioBase, int areaM2,
                     String usoPrincipal, boolean aptoParaAlimentos) {
        super(codigo, direccion, precioBase, areaM2);

        if (usoPrincipal == null || usoPrincipal.isEmpty()) {
            throw new IllegalArgumentException("Debe especificar el uso principal del inmueble comercial.");
        }
        this.usoPrincipal = usoPrincipal;
        this.aptoParaAlimentos = aptoParaAlimentos;
    }

    // --- MÉTODOS SOBRESCRITOS (@Override - Semana 05) ---

    @Override
    public String obtenerDescripcion() {
        return "Comercial: " + this.codigo + " | Uso: " + this.usoPrincipal;
    }

    @Override
    public double calcularComisionAgencia(double porcentajeBase) {
        // Sobrescribe: las comerciales tienen un recargo del 2% en la comisión
        double comisionBase = super.calcularComisionAgencia(porcentajeBase);
        double recargo = this.precioBase * 0.02;
        return comisionBase + recargo;
    }

    // --- MÉTODOS SOBRESCRITOS (@Override - Semana 04) ---

    @Override
    public double calcularImpuestos(double tasaBase) {
        // Unidades comerciales tienen un recargo del 50% en la tasa base.
        double impuestoBase = super.calcularImpuestos(tasaBase);
        double recargo = impuestoBase * 0.50;

        return impuestoBase + recargo;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("TIPO: Propiedad Comercial (" + this.usoPrincipal + ")");
        super.mostrarInfo();
        String apto = this.aptoParaAlimentos ? "Sí" : "No";
        System.out.println("Detalles: Apto para Alimentos: " + apto);
    }

    // --- GETTERS y SETTERS ESPECÍFICOS ---
    public String getUsoPrincipal() { return usoPrincipal; }
    public void setUsoPrincipal(String usoPrincipal) { this.usoPrincipal = usoPrincipal; }
}