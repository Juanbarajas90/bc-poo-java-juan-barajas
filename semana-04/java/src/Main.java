public class Main {
    public static void main(String[] args) {
        System.out.println("SEMANA 04: HERENCIA Y POLIMORFISMO");

        // La tasa de impuesto base es 2%
        final double TASA_IMPUESTO_BASE = 0.02;

        // --- ARREGLO POLIMÓRFICO ---
        // El array se declara de tipo Propiedad (Clase Padre)
        Propiedad[] portafolio = new Propiedad[3];

        // Se instancian objetos de las clases hijas en el array del padre
        portafolio[0] = new Residencial("APTO-101", "Cl 100 # 20-55", 350000000.0, 95, 3, true);
        portafolio[1] = new Comercial("LOCAL-05", "Cra 15 # 80-12", 780000000.0, 220, "Local Comercial", false);
        portafolio[2] = new Residencial("CASA-03", "Av 68 # 50-30", 500000000.0, 150, 4, false);

        System.out.println("\n--- CÁLCULO POLIMÓRFICO DE IMPUESTOS (Tasa Base: 2%) ---");

        // El bucle trata a todos los objetos como 'Propiedad'
        for (Propiedad p : portafolio) {
            // Llama al mEtodo mostrarInfo() correcto (el sobrescrito en la hija)
            p.mostrarInfo();

            // Llama al mEtodo calcularImpuestos() correcto (el sobrescrito en la hija)
            double impuestoFinal = p.calcularImpuestos(TASA_IMPUESTO_BASE);

            System.out.printf("Impuesto Base (2%%): $%.2f%n", (p.getPrecioBase() * TASA_IMPUESTO_BASE));
            System.out.printf("Impuesto Final Aplicado: $%.2f%n", impuestoFinal);
            System.out.println("---------------------------------------------");
        }

        System.out.println("=============================================");
    }
}