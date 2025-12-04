import java.util.ArrayList;

public class Portafolio {
    private String nombreAgencia;
    // ArrayList Polimórfico
    private ArrayList<Propiedad> listaPropiedades;
    // Usamos ArrayLists de las semanas anteriores
    private ArrayList<AsesorComercial> listaAsesores;

    // --- CONSTRUCTORES (Semana 03) ---
    public Portafolio(String nombreAgencia, ArrayList<Propiedad> listaPropiedades, ArrayList<AsesorComercial> listaAsesores) {
        setNombreAgencia(nombreAgencia);
        this.listaPropiedades = listaPropiedades != null ? listaPropiedades : new ArrayList<>();
        this.listaAsesores = listaAsesores != null ? listaAsesores : new ArrayList<>();
    }
    public Portafolio(String nombreAgencia) {
        this(nombreAgencia, null, null);
        System.out.println("-> [Portafolio]: Inicializado con listas vacías.");
    }

    // --- EJERCICIO 1: SOBRECARGA DE MÉTODOS (buscarPropiedad) ---

    // Sobrecarga 1: Buscar propiedad por Código (String)
    public Propiedad buscarPropiedad(String codigo) {
        for (Propiedad p : listaPropiedades) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    // Sobrecarga 2: Buscar propiedades por Rango de Precio (double, double)
    public ArrayList<Propiedad> buscarPropiedad(double precioMinimo, double precioMaximo) {
        ArrayList<Propiedad> resultado = new ArrayList<>();
        for (Propiedad p : listaPropiedades) {
            if (p.getPrecioBase() >= precioMinimo && p.getPrecioBase() <= precioMaximo) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    // Sobrecarga 3: Buscar propiedades por Área Mínima (int)
    public ArrayList<Propiedad> buscarPropiedad(int areaMinima) {
        ArrayList<Propiedad> resultado = new ArrayList<>();
        for (Propiedad p : listaPropiedades) {
            if (p.getAreaM2() >= areaMinima) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    // --- EJERCICIO 3: MÉTODOS POLIMÓRFICOS ---

    // Método polimórfico 1: Acepta la clase padre (Propiedad)
    public void procesarPropiedad(Propiedad propiedad, double tasaComision) {
        double comision = propiedad.calcularComisionAgencia(tasaComision); // Dynamic Binding
        System.out.println("Procesando: " + propiedad.obtenerDescripcion()); // Dynamic Binding
        System.out.printf("Comisión calculada: $%.2f%n", comision);
    }

    // Método polimórfico 2: Procesa todo el array
    public void procesarComisionesPortafolio(double tasaComision) {
        System.out.println("\n=== CÁLCULO DE COMISIONES DEL PORTAFOLIO (" + (tasaComision*100) + "%) ===");
        double totalComision = 0;
        for (Propiedad p : listaPropiedades) {
            this.procesarPropiedad(p, tasaComision);
            totalComision += p.calcularComisionAgencia(tasaComision);
        }
        System.out.printf("TOTAL COMISIONES ESTIMADAS: $%.2f%n", totalComision);
        System.out.println("-----------------------------------------------------");
    }

    // --- MÉTODOS DE NEGOCIO Y UTILITARIOS (Semana 03) ---

    public void registrarPropiedad(Propiedad propiedad) {
        if (propiedad == null || !propiedad.isEstaDisponible()) {
            System.err.println("[GESTOR]: Error al registrar. La propiedad es nula o no está disponible.");
            return;
        }
        listaPropiedades.add(propiedad);
        System.out.println("[GESTOR]: Propiedad " + propiedad.getCodigo() + " registrada en el portafolio.");
    }

    // ... (Métodos como contratarAsesor, mostrarPropiedadesDisponibles, etc. omitidos por extensión)

    // --- GETTERS (Semana 03) ---
    public String getNombreAgencia() { return nombreAgencia; }
    public ArrayList<Propiedad> getListaPropiedades() { return listaPropiedades; }

    // --- SETTERS CON VALIDACIÓN (Semana 03) ---
    public void setNombreAgencia(String nombreAgencia) {
        if (nombreAgencia == null || nombreAgencia.length() < 3) {
            throw new IllegalArgumentException("El nombre de la agencia debe tener al menos 3 caracteres.");
        }
        this.nombreAgencia = nombreAgencia;
    }
}
