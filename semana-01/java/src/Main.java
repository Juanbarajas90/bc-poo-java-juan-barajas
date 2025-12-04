public class Main {
    public static void main(String[] args) {

        System.out.println("PRUEBA INICIAL DEL DOMINIO: BIENES RAÍCES PLUS");


        // Creacion de los objetos de Propiedad que es la Clase Principal
        Propiedad p1 = new Propiedad("APTO-101", "Calle 100 # 20-55, Bogotá", 350000000.0, 95);
        Propiedad p2 = new Propiedad("CASA-05", "Carrera 15 # 80-12, Bogotá", 780000000.0, 220);

        // Creacion de los objetos de AsesorComercial que es la Clase Secundaria
        AsesorComercial a1 = new AsesorComercial("A-001", "Laura Montes", "310-1234567");
        AsesorComercial a2 = new AsesorComercial("A-002", "Carlos Ruiz", "320-9876543");


        System.out.println("\n 1. DEMOSTRACIÓN DE PROPIEDAD 'p1' ");

        // Objeto de propiedad llama al metodo para mostra informacion
        p1.mostrarInformacion();

        // Declaracion del porcentajeGasto para calcular el precio final y mostrarlo en consola
        double porcentajeGasto = 0.04; // 4% de valorización o gastos
        double precioFinal = p1.calcularPrecioFinal(porcentajeGasto);
        System.out.println("Cálculo: Precio con " + (porcentajeGasto * 100) + "% de gastos: $" + precioFinal);

        // Se muestra el metodo getter del codigo
        System.out.println("Getter: Código obtenido: " + p1.getCodigo());

        // Se cambia el estado de la propiedad
        System.out.println("\nSe realiza la transacción...");
        p1.setDisponible(false); // La propiedad ya no está disponible

        // muestra el cambio de estado
        p1.mostrarInformacion();


        System.out.println("\n--- 2. DEMOSTRACIÓN DE ASESOR 'a1' ---");

        // Llama al metodo de la clase Asesor Comercial para mostrar la informacion
        a1.mostrarDatos();

        // Llama a el metod para simular que se vendio 2 negocios
        System.out.println("\nAsesor a1 cierra 2 negocios.");
        a1.registrarVentaExitosa();
        a1.registrarVentaExitosa();

        // Llama al metodo que calcula el bono por la venta agregandole el valor de valor de bono figo
        double valorBonoFijo = 1500000.0;
        double bonoTotal = a1.calcularBonoPorVenta(valorBonoFijo);
        System.out.println("Cálculo: Bono total por " + a1.getPropiedadesVendidas() + " ventas: $" + bonoTotal);

        // Mostramos los datos del asesor de nuevo
        a1.mostrarDatos();


        System.out.println("\nLos objetos que faltaban");
        p2.mostrarInformacion();
        a2.mostrarDatos();
        System.out.println("=================================================");
    }
}