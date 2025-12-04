import java.util.ArrayList;

public class Portafolio {
    //Atributos de la clase Portafolio
    private String nombreAgencia;
    private ArrayList<Propiedad> listaPropiedades;
    private ArrayList<AsesorComercial> listaAsesores;

    // --- CONSTRUCTORES (Mínimo 2) ---

    // Constructor 1: Completo
    public Portafolio(String nombreAgencia, ArrayList<Propiedad> listaPropiedades, ArrayList<AsesorComercial> listaAsesores) {
        setNombreAgencia(nombreAgencia);
        this.listaPropiedades = listaPropiedades != null ? listaPropiedades : new ArrayList<>();
        this.listaAsesores = listaAsesores != null ? listaAsesores : new ArrayList<>();
    }

    // Constructor 2: Básico (Inicializa las colecciones vacías)
    public Portafolio(String nombreAgencia) {
        // Llama al constructor completo, pasando null para que inicialice las listas vacías.
        this(nombreAgencia, null, null);
        System.out.println("-> [Portafolio]: Inicializado con listas vacías.");
    }

    // --- MÉTODOS DE NEGOCIO Y UTILITARIOS ---

    public void registrarPropiedad(Propiedad propiedad) {
        if (propiedad == null || !propiedad.isEstaDisponible()) {
            System.err.println("[GESTOR]: Error al registrar. La propiedad es nula o no está disponible.");
            return;
        }
        listaPropiedades.add(propiedad);
        System.out.println("[GESTOR]: Propiedad " + propiedad.getCodigo() + " registrada en el portafolio.");
    }

    public void contratarAsesor(AsesorComercial asesor) {
        if (asesor == null) {
            System.err.println("[GESTOR]: No se puede contratar un asesor nulo.");
            return;
        }
        listaAsesores.add(asesor);
        System.out.println("[GESTOR]: Asesor " + asesor.getNombre() + " contratado.");
    }

    public void mostrarPropiedadesDisponibles() {
        System.out.println("\n=== PROPIEDADES DISPONIBLES EN EL PORTAFOLIO ===");
        int disponibles = 0;
        for (Propiedad p : listaPropiedades) {
            if (p.isEstaDisponible()) {
                p.mostrarInformacion();
                disponibles++;
            }
        }
        System.out.println("--- Total: " + disponibles + " propiedades disponibles. ---");
    }

    // --- GETTERS ---
    public String getNombreAgencia() { return nombreAgencia; }
    public int getCantidadAsesores() { return listaAsesores.size(); }
    public ArrayList<Propiedad> getListaPropiedades() { return listaPropiedades; }

    // --- SETTERS CON VALIDACIÓN ---
    public void setNombreAgencia(String nombreAgencia) {
        if (nombreAgencia == null || nombreAgencia.length() < 3) {
            throw new IllegalArgumentException("El nombre de la agencia debe tener al menos 3 caracteres.");
        }
        this.nombreAgencia = nombreAgencia;
    }
    // Nota: Los Setters para los ArrayLists no se implementan ya que se gestionan con los métodos registrar/contratar.
}