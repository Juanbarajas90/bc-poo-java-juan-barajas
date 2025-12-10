package com.bienesraices;

import com.bienesraices.modelo.Comercial;
import com.bienesraices.modelo.Propiedad;
import com.bienesraices.modelo.Residencial;
import com.bienesraices.servicio.GestorPropiedades;
import com.bienesraices.excepciones.PropiedadNoEncontradaException;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    private static GestorPropiedades gestor = new GestorPropiedades();
    // Ejercicio 4: Uso de Scanner para menú interactivo
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDatos();
        int opcion;

        do {
            try {
                mostrarMenu();
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                ejecutarOpcion(opcion);
            } catch (InputMismatchException e) {
                System.err.println("❌ Entrada inválida. Por favor, ingrese un número para la opción.");
                scanner.nextLine(); // Limpiar entrada errónea
                opcion = -1;
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void inicializarDatos() {
        try {
            // Caso 1: Operación exitosa (propiedades con precios variados para estadísticas)
            gestor.agregarPropiedad(new Residencial("R001", "Calle Falsa 123", 400000000.0, 100, 3, true));
            gestor.agregarPropiedad(new Residencial("R002", "Carrera 45 Sur", 250000000.0, 75, 2, false));
            gestor.agregarPropiedad(new Comercial("C005", "Av. Principal 456", 800000000.0, 300, "Oficinas", 5));
            gestor.agregarPropiedad(new Comercial("C006", "Centro Comercial", 150000000.0, 500, "Local", 2));
            System.out.println("✅ Datos de muestra cargados (" + gestor.cantidad() + " propiedades).");

            // Caso de error: Intento de duplicado (ejercicio 2)
            gestor.agregarPropiedad(new Residencial("R001", "Duplicado", 100.0, 1, 1, false));
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Error al cargar datos: " + e.getMessage());
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n=== GESTOR DE PROPIEDADES - SEMANA 08 ===");
        System.out.println("1. Listar todas las propiedades (ArrayList)");
        System.out.println("2. Buscar propiedad por código (HashMap O(1))");
        System.out.println("3. Eliminar propiedad por código");
        System.out.println("4. Filtrar por rango de precio final");
        System.out.println("5. Mostrar estadísticas del portafolio");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1: listarTodas(); break;
            case 2: buscarPorCodigo(); break;
            case 3: eliminarPorCodigo(); break;
            case 4: filtrarPorPrecio(); break;
            case 5: mostrarEstadisticas(); break;
            case 0: System.out.println("¡Gracias por usar el sistema!"); break;
            default: System.err.println("Opción no válida. Intente de nuevo.");
        }
    }

    private static void listarTodas() {
        System.out.println("\n--- LISTADO COMPLETO DE PROPIEDADES (" + gestor.cantidad() + " registros) ---");
        // Demuestra iteración de ArrayList con Generics
        for (Propiedad p : gestor.getHistorialPropiedades()) {
            System.out.printf("[%s] %s | Precio Final: $%.2f%n",
                    p.getCodigo(),
                    p.obtenerDescripcionDetallada(),
                    p.calcularPrecioVentaFinal());
        }
        if (gestor.cantidad() == 0) {
            System.out.println("El portafolio está vacío.");
        }
    }

    private static void buscarPorCodigo() {
        System.out.print("Ingrese el código de la propiedad a buscar: ");
        String codigo = scanner.nextLine();
        try {
            // Demuestra búsqueda O(1) con HashMap
            Propiedad p = gestor.buscarPorCodigo(codigo);
            System.out.println("\n✅ Propiedad Encontrada (Búsqueda O(1)):");
            p.mostrarInfoBase();
            System.out.printf("   Precio Venta Final: $%.2f%n", p.calcularPrecioVentaFinal());
        } catch (PropiedadNoEncontradaException e) {
            System.err.println("❌ ERROR: " + e.getMessage());
        }
    }

    private static void eliminarPorCodigo() {
        System.out.print("Ingrese el código de la propiedad a ELIMINAR: ");
        String codigo = scanner.nextLine();
        // Demuestra la eliminación de HashMap y sincronización con ArrayList
        Propiedad p = gestor.eliminarPropiedad(codigo);
        if (p != null) {
            System.out.printf("✅ Propiedad [%s] eliminada con éxito. %d restantes.%n", codigo, gestor.cantidad());
        } else {
            System.err.println("❌ ERROR: No se encontró la propiedad con código " + codigo + " para eliminar.");
        }
    }

    private static void filtrarPorPrecio() {
        try {
            System.out.print("Ingrese Precio Mínimo: ");
            double min = scanner.nextDouble();
            System.out.print("Ingrese Precio Máximo: ");
            double max = scanner.nextDouble();
            scanner.nextLine();

            // Demuestra método de filtrado (Ejercicio 3.1)
            List<Propiedad> resultado = gestor.filtrarPorRangoPrecioFinal(min, max);

            System.out.printf("\n--- RESULTADO DE FILTRO ($%.2f - $%.2f) (%d resultados) ---%n", min, max, resultado.size());
            if (resultado.isEmpty()) {
                System.out.println("No se encontraron propiedades en ese rango.");
            }
            for (Propiedad p : resultado) {
                System.out.printf("[%s] %s | Precio Final: $%.2f%n",
                        p.getCodigo(),
                        p.obtenerDescripcionDetallada(),
                        p.calcularPrecioVentaFinal());
            }
        } catch (InputMismatchException e) {
            System.err.println("❌ Entrada inválida. Asegúrese de ingresar números para los precios.");
            scanner.nextLine();
        }
    }

    private static void mostrarEstadisticas() {
        System.out.println("\n=== ESTADÍSTICAS DEL PORTAFOLIO ===");
        System.out.println("Total de propiedades: " + gestor.cantidad());

        // Demuestra estadísticas (Ejercicio 3.2)
        System.out.printf("Valor Total (Suma de precios finales): $%.2f%n", gestor.calcularTotalValorPropiedades());
        System.out.printf("Precio Final Promedio: $%.2f%n", gestor.calcularPromedioPrecioFinal());

        Propiedad masCara = gestor.obtenerPropiedadMasCara();
        if (masCara != null) {
            System.out.printf("Propiedad Más Cara: [%s] $%.2f%n", masCara.getCodigo(), masCara.calcularPrecioVentaFinal());
        }

        // Demuestra conteo por categoría (Ejercicio 3.3)
        System.out.println("\n--- Conteo por Tipo (HashMap) ---");
        Map<String, Integer> conteo = gestor.contarPorTipo();
        // Demuestra la iteración de Map.Entry<K, V>
        for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
            System.out.println("  - " + entry.getKey() + ": " + entry.getValue() + " unidades");
        }
    }
}