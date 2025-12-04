/**
 * Clase Comercial (Semana 04): SUBCLASE 2
 * Hereda de Propiedad.
 */
public class Comercial extends Propiedad {
    // Atributo específico de la subclase
    private String usoPrincipal; // (Ej: Local, Oficina, Bodega)
    private boolean aptoParaAlimentos;

    // --- CONSTRUCTOR ---
    public Comercial(String codigo, String direccion, double precioBase, int areaM2,
                     String usoPrincipal, boolean aptoParaAlimentos) {
        // Uso de super() para llamar al constructor del padre
        super(codigo, direccion, precioBase, areaM2);

        if (usoPrincipal == null || usoPrincipal.isEmpty()) {
            throw new IllegalArgumentException("Debe especificar el uso principal del inmueble comercial.");
        }
        this.usoPrincipal = usoPrincipal;
        this.aptoParaAlimentos = aptoParaAlimentos;
    }

    // --- METODO SOBRESCRITO (Override) ---
    @Override
    public double calcularImpuestos(double tasaBase) {
        // Unidades comerciales tienen un recargo del 50% en la tasa base.
        double impuestoBase = super.calcularImpuestos(tasaBase);
        double recargo = impuestoBase * 0.50;

        return impuestoBase + recargo;
    }

    // --- METODO HEREDADO y EXTENDIDO ---
    @Override
    public void mostrarInfo() {
        System.out.println("TIPO: Propiedad Comercial (" + this.usoPrincipal + ")");
        super.mostrarInfo(); // Llama al método del padre
        String apto = this.aptoParaAlimentos ? "Sí" : "No";
        System.out.println("Detalles: Apto para Alimentos: " + apto);
    }

    // --- GETTERS y SETTERS ESPECÍFICOS ---
    public String getUsoPrincipal() { return usoPrincipal; }
    public void setUsoPrincipal(String usoPrincipal) { this.usoPrincipal = usoPrincipal; }
}