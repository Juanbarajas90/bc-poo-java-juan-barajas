import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nSEMANA 05: POLIMORFISMO EN ACCIÓN");


        final double TASA_COMISION_BASE = 0.05;

        // --- 1. PREPARACIÓN DE OBJETOS (Polimorfismo) ---

        // Instancias de Subclases
        Propiedad p1 = new Residencial("APTO-101", "Cl 100 # 20-55", 350000000.0, 95, 3, true);
        Propiedad p2 = new Comercial("LOCAL-05", "Cra 15 # 80-12", 780000000.0, 220, "Local Comercial", false);
        Propiedad p3 = new Residencial("CASA-03", "Av 68 # 50-30", 500000000.0, 150, 4, false);

        // Portafolio (Clase Gestora)
        Portafolio agencia = new Portafolio("Bienes Raíces Plus S.A.S");
        agencia.registrarPropiedad(p1);
        agencia.registrarPropiedad(p2);
        agencia.registrarPropiedad(p3);

        // --- 2. DEMOSTRACIÓN DE POLIMORFISMO DINÁMICO (EJERCICIO 2 y 3) ---

        // El metodo procesarComisionesPortafolio llama a calcularComisionAgencia() de forma polimórfica
        agencia.procesarComisionesPortafolio(TASA_COMISION_BASE);

        // --- 3. DEMOSTRACIÓN DE ARRAY POLIMÓRFICO (EJERCICIO 4) ---

        System.out.println("\n=== DEMOSTRACIÓN DE DYNAMIC BINDING EN BUCLE ===");

        // Array Polimórfico: ArrayList<Propiedad>
        ArrayList<Propiedad> lista = agencia.getListaPropiedades();

        for (Propiedad p : lista) {
            // Se llama al metodo sobrescrito específico de la subclase
            System.out.println("Clase real: " + p.getClass().getSimpleName());
            System.out.println("Descripción: " + p.obtenerDescripcion()); // Polimorfismo
            System.out.printf("Impuesto Final (4%% Tasa Base): $%.2f%n", p.calcularImpuestos(0.04)); // Polimorfismo (Semana 04)
            System.out.println("---");
        }

        // --- 4. DEMOSTRACIÓN DE SOBRECARGA (EJERCICIO 1) ---

        System.out.println("\n=== DEMOSTRACIÓN DE SOBRECARGA DE MÉTODOS ===");

        // Sobrecarga 1: Búsqueda por Código
        Propiedad propEncontrada = agencia.buscarPropiedad("APTO-101");
        System.out.println("Búsqueda por Código (APTO-101): " +
                (propEncontrada != null ? propEncontrada.obtenerDescripcion() : "No encontrada"));

        // Sobrecarga 2: Búsqueda por Rango de Precio (300M a 550M)
        ArrayList<Propiedad> rangoPrecio = agencia.buscarPropiedad(300000000.0, 550000000.0);
        System.out.println("Búsqueda por Rango (300M-550M): Encontradas " + rangoPrecio.size() + " propiedades.");

        // Sobrecarga 3: Búsqueda por Área Mínima (100 m²)
        ArrayList<Propiedad> areaGrande = agencia.buscarPropiedad(100);
        System.out.println("Búsqueda por Área Mínima (100 m²): Encontradas " + areaGrande.size() + " propiedades.");

        System.out.println("=============================================");
    }
}