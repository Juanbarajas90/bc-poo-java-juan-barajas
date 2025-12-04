import java.util.ArrayList;

public class Portafolio {
    // Atributos privados del portafolio
    private String nombreAgencia;
    // ArrayList para manejar múltiples objetos Propiedad
    private ArrayList<Propiedad> listaPropiedades;
    // ArrayList para manejar múltiples objetos AsesorComercial
    private ArrayList<AsesorComercial> listaAsesores;

    public Portafolio(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
        this.listaPropiedades = new ArrayList<>();
        this.listaAsesores = new ArrayList<>();
    }

    // Metodo para agregar Propiedades a la colección (ArrayList)
    public void registrarPropiedad(Propiedad propiedad) {
        listaPropiedades.add(propiedad);
        System.out.println("[GESTOR]: Propiedad " + propiedad.getCodigo() + " registrada en el portafolio.");
    }

    // Metodo para agregar Asesores a la colección (ArrayList)
    public void contratarAsesor(AsesorComercial asesor) {
        listaAsesores.add(asesor);
        System.out.println("[GESTOR]: Asesor " + asesor.getNombre() + " contratado.");
    }

    // Metodo de negocio que recorre el ArrayList y muestra solo los disponibles
    public void mostrarPropiedadesDisponibles() {
        System.out.println("\n=== PROPIEDADES DISPONIBLES EN EL PORTAFOLIO ===");
        int disponibles = 0;
        // Se usa un for-each para recorrer la coleccion (ArrayList)
        for (Propiedad p : listaPropiedades) {
            // Se usa el isEstaDisponible() de la clase Propiedad
            if (p.isEstaDisponible()) {
                p.mostrarInformacion();
                disponibles++;
            }
        }
        System.out.println("--- Total: " + disponibles + " propiedades disponibles. ---");
    }

    // Metodo que retorna el tamaño de la colección (demuestra el metodo size())
    public int getCantidadAsesores() {
        return listaAsesores.size();
    }

    // --- Getters ---
    public String getNombreAgencia() {
        return nombreAgencia;
    }

    // --- Setters ---
    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }
    // Nota: No se añaden Setters para los ArrayLists, ya que se gestionan con los métodos registrar/contratar.
}