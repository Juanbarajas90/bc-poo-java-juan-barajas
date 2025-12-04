public class Main {
    public static void main(String[] args) {
        System.out.println("SEMANA 02: GESTIÓN DE INMUEBLES");

        // Clase Propiedades
        Propiedad p1 = new Propiedad("APTO-101", "Calle 100 # 20-55, Bogotá", 350000000.0, 95);
        Propiedad p2 = new Propiedad("CASA-05", "Carrera 15 # 80-12, Bogotá", 780000000.0, 220);

        // Clase Asesores
        AsesorComercial a1 = new AsesorComercial("A-001", "Laura Montes", "310-1234567");
        AsesorComercial a2 = new AsesorComercial("A-002", "Carlos Ruiz", "320-9876543");

        // Clase Clientes (Nueva Clase 1)
        Cliente c1 = new Cliente("C-123", "Felipe Gómez", "300-1111111", "Comprador");
        Cliente c2 = new Cliente("C-456", "Andrea Rojas", "300-2222222", "Arrendador");

        // --- 2. USO DE CLASE GESTORA (Portafolio) y ArrayList ---
        Portafolio bienesRaices = new Portafolio("Bienes Raíces Plus");

        // Agregar objetos a la colección (ArrayList)
        bienesRaices.contratarAsesor(a1);
        bienesRaices.contratarAsesor(a2);
        bienesRaices.registrarPropiedad(p1);
        bienesRaices.registrarPropiedad(p2);

        System.out.println("\nTotal de Asesores en el Portafolio: " + bienesRaices.getCantidadAsesores());

        // --- 3. CREACIÓN DE RELACIONES (Contrato) ---

        // Creamos el Contrato (Nueva Clase 2), estableciendo la relación de AGREGACIÓN entre los objetos
        Contrato contratoVenta1 = new Contrato("CON-001", "Venta", 364000000.0, p1, c1, a1);

        // Simulamos el proceso de cierre:
        System.out.println("\n--- SIMULACIÓN DE CIERRE DE VENTA CON CONTRATO ---");

        // 1. Cliente solicita información (Metodo de negocio de Cliente)
        c1.solicitarInformacion(p1.getCodigo());

        // 2. Se formaliza la venta (Métodos de Propiedad y Asesor)
        p1.setDisponible(false);
        a1.registrarVentaExitosa();

        // 3. Se genera el resumen del Contrato (Metodo de Contrato)
        contratoVenta1.generarResumen();

        // 4. Se calcula la comisión (Metodo de negocio de Contrato)
        double comision = contratoVenta1.calcularComisionAgencia(0.03);
        System.out.println("Cálculo: Comisión de la agencia por CON-001 (3%): $" + comision);

        // --- 4. PRUEBA DE GESTOR Y ESTADO FINAL ---

        // Muestra el ArrayList (Propiedades). Solo p2 debe estar disponible.
        bienesRaices.mostrarPropiedadesDisponibles();

        // Verifica el estado final del asesor
        a1.mostrarDatos();

        System.out.println("=================================================");
    }
}