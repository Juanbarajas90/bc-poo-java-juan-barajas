import abstractas.Propiedad;
import implementaciones.Comercial;
import implementaciones.Residencial;
import interfaces.Mantenible;
import interfaces.Vendible;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final double PORCENTAJE_ASESOR = 0.03; // 3% de comisión

        System.out.println("=== SISTEMA DE BIENES RAÍCES: ABSTRACCIÓN E INTERFACES ===\n");

        // 1. Demostrar polimorfismo con clase abstracta
        System.out.println("--- Sección 1: Polimorfismo con Clase Abstracta ---");

        // Array/List de tipo abstracto (Propiedad)
        ArrayList<Propiedad> lista = new ArrayList<>();
        lista.add(new Residencial("R-001", "Calle Falsa 123", 400000000.0, 100, 3, true));
        lista.add(new Comercial("C-005", "Av. Principal 456", 800000000.0, 300, "Oficinas", 5));

        for (Propiedad p : lista) {
            // Se invoca el método concreto (común) y este llama a los abstractos (@Override)
            p.mostrarInfoBase();
            System.out.println("Detalles: " + p.obtenerDescripcionDetallada());
            System.out.printf("Costo Adicional: $%.2f%n", p.calcularCostoAdicional());
            System.out.printf("Precio Venta Final: $%.2f%n", p.calcularPrecioVentaFinal());
            System.out.println("---------------------------------------------");
        }

        // 2. Demostrar uso de interfaces
        System.out.println("\n--- Sección 2: Uso de Interfaces (Contratos) ---");

        // Usar la referencia de tipo interface Vendible
        Vendible v1 = (Vendible) lista.get(0); // Residencial R-001
        Vendible v2 = (Vendible) lista.get(1); // Comercial C-005

        System.out.println("Propiedad R-001 es elegible: " + v1.verificarElegibilidadVenta());
        System.out.printf("Comisión Asesor R-001 (3%%): $%.2f%n", v1.calcularComisionAsesor(PORCENTAJE_ASESOR));

        System.out.println("Propiedad C-005 es elegible: " + v2.verificarElegibilidadVenta());
        System.out.printf("Comisión Asesor C-005 (3%%): $%.2f%n", v2.calcularComisionAsesor(PORCENTAJE_ASESOR));

        // 3. Demostrar múltiple implementación (solo Residencial implementa Mantenible)
        System.out.println("\n--- Sección 3: Múltiple Implementación y Tipos ---");

        Residencial r = (Residencial) lista.get(0); // Obtener el objeto Residencial

        // Usar como Vendible
        System.out.println(r.generarReporteTransaccion(r.calcularPrecioVentaFinal()));

        // Usar como Mantenible
        Mantenible m = r; // La misma instancia referenciada como Mantenible
        System.out.println("Frecuencia inspección: cada " + m.obtenerFrecuenciaInspeccionDias() + " días.");
        m.realizarMantenimiento("Inspección de tejado");

        // Intentar usar Mantenible en Comercial (Falla si no se hace casting y no implementa)
        // Mantenible m_fail = (Mantenible) lista.get(1); // Esto fallaría en runtime (ClassCastException) si Comercial no implementara Mantenible

        System.out.println("\n=== FIN ===");
    }
}