public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("     🏢 SEMANA 03: ENCAPSULACIÓN Y VALIDACIONES   ");
        System.out.println("=================================================");

        // --- 1. PRUEBA DE SOBRECARGA DE CONSTRUCTORES ---

        // Propiedad: Constructor Básico (sin área)
        Propiedad p1 = new Propiedad("APTO-302", "Calle 10 # 5-55", 280000000.0);

        // Asesor: Constructor Básico (solo ID y Nombre)
        AsesorComercial a1 = new AsesorComercial("ID-005", "Daniela Vargas");

        // Cliente: Constructor Básico (solo Nombre y Teléfono)
        Cliente c1 = new Cliente("Sofía Pérez", "315-7778888");

        // Contrato: Constructor Básico (solo valor y propiedad)
        Contrato con1 = new Contrato("CON-001", "Venta", 300000000.0, p1);

        // Portafolio: Constructor Básico (inicializa listas vacías)
        Portafolio bienesRaices = new Portafolio("Bienes Raíces Plus S.A.S");

        System.out.println("\n--- OBJETOS CREADOS CON CONSTRUCTORES SOBRECARGADOS ---");
        p1.mostrarInformacion();
        con1.generarResumen();

        // --- 2. DEMOSTRACIÓN DE ASIGNACIONES VÁLIDAS ---

        System.out.println("\n--- DEMOSTRACIÓN DE ASIGNACIONES VÁLIDAS ---");

        // Asignación de relaciones válidas al Contrato
        con1.setCliente(c1);
        con1.setAsesor(a1);
        con1.setValorAcordado(350000000.0);
        System.out.println("Relaciones y valor de Contrato actualizados exitosamente.");

        // Asignación válida a Propiedad
        p1.setPrecioBase(300000000.0);
        System.out.println("Precio de p1 actualizado a: $" + p1.getPrecioBase());

        // Registro en el Portafolio (Funcionalidad)
        bienesRaices.contratarAsesor(a1);
        bienesRaices.registrarPropiedad(p1);
        bienesRaices.mostrarPropiedadesDisponibles();

        //DEMOSTRACIÓN DE FALLO DE VALIDACIÓN (DESCOMENTAR PARA PROBAR)
        // Al ejecutar cualquiera de las siguientes líneas, el programa lanzará una
        // "IllegalArgumentException" y se detendrá, demostrando la encapsulación.

        /*
        System.out.println("\n--- PRUEBA DE VALIDACIÓN FALLIDA (EXPECTED EXCEPTION) ---");

        // FALLO 1: Precio debe ser positivo (Propiedad.java)
        p1.setPrecioBase(-10.0);

        // FALLO 2: Tipo de Cliente inválido (Cliente.java)
        c1.setTipoCliente("InversorLoco");

        // FALLO 3: Valor de Contrato muy bajo (Contrato.java)
        con1.setValorAcordado(500.0);
        */

        System.out.println("\n=================================================");
    }
}