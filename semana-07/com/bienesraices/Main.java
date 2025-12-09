package com.bienesraices;

import com.bienesraices.modelo.*;
import com.bienesraices.servicio.GestorPropiedades;
import com.bienesraices.excepciones.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE BIENES RAÍCES - SEMANA 07 (EXCEPCIONES) ===\n");

        GestorPropiedades gestor = new GestorPropiedades();

        // Inicialización de datos
        try {
            gestor.agregarPropiedad(new Residencial("R001", "Calle Falsa 123", 400000000.0, 100, 3, true));
            gestor.agregarPropiedad(new Comercial("C005", "Av. Principal 456", 800000000.0, 300, "Oficinas", 5));
        } catch (Exception e) {
            System.err.println("Error de inicialización: " + e.getMessage());
        }

        System.out.println("--- Caso 1: Operación exitosa (Comisión Válida) ✅ ---");
        try {
            double comision = gestor.calcularComisionVenta("R001", 0.03);
            System.out.printf("Comisión para R001 (3%%): $%.2f%n", comision);
        } catch (PropiedadNoEncontradaException | ValorInvalidoException | IllegalStateException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }

        System.out.println("\n--- Caso 2: Excepción por validación (IllegalArgumentException) ❌ ---");
        try {
            // Se intenta setear un precio inválido en una propiedad existente
            Propiedad p = gestor.buscarPorCodigo("C005");
            p.setPrecioBase(-100.0); // Lanza IllegalArgumentException
        } catch (PropiedadNoEncontradaException e) {
            System.err.println("❌ Error (Busqueda): " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Error (Validación): " + e.getMessage());
        }

        System.out.println("\n--- Caso 3: Excepción personalizada 1 (PropiedadNoEncontradaException) ❌ ---");
        try {
            gestor.buscarPorCodigo("P999"); // Lanza PropiedadNoEncontradaException
        } catch (PropiedadNoEncontradaException e) {
            System.err.println("❌ Error Personalizado 1: " + e.getMessage());
        }

        System.out.println("\n--- Caso 4: Excepción personalizada 2 (ValorInvalidoException) ❌ ---");
        try {
            // Se intenta calcular la comisión con un porcentaje demasiado alto
            gestor.calcularComisionVenta("C005", 1.50); // Lanza ValorInvalidoException
        } catch (PropiedadNoEncontradaException e) {
            System.err.println("❌ Error (Busqueda): " + e.getMessage());
        } catch (ValorInvalidoException e) {
            System.err.println("❌ Error Personalizado 2: " + e.getMessage());
        }

        System.out.println("\n--- Caso 5: Recuperación después de error y uso de finally ✅ ---");
        BufferedReader reader = null;
        try {
            // Ejemplo de operación con recursos que requieren limpieza
            System.out.println("Intentando acceder a recurso externo...");
            reader = new BufferedReader(new FileReader("archivo_inexistente.txt"));
            String linea = reader.readLine();
            System.out.println("Línea leída: " + linea);
        } catch (IOException e) {
            System.err.println("❌ Error de I/O (Esperado): " + e.getMessage());
            System.out.println("✅ Recuperación: El programa continúa con normalidad.");
        } finally {
            // Ejercicio 4: Uso de finally para limpieza
            System.out.println("-> Ejecutando FINALLY: Cerrando recursos (BufferedReader).");
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error cerrando recurso en finally: " + e.getMessage());
                }
            }
        }

        System.out.println("\n=== FIN DE DEMOSTRACIÓN - SEMANA 07 ===\n");
    }
}