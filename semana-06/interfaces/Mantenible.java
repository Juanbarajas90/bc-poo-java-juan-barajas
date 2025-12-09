package interfaces;

// Interface 2: Define la capacidad de ser inspeccionado o mantenido
public interface Mantenible {

    // Define la frecuencia con la que se debe inspeccionar la propiedad
    int obtenerFrecuenciaInspeccionDias();

    // Ejecuta una acción de mantenimiento
    void realizarMantenimiento(String tarea);
}