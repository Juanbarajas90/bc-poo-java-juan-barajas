package com.bienesraices.servicio;

import com.bienesraices.modelo.Propiedad;
import com.bienesraices.modelo.Vendible;
import com.bienesraices.excepciones.PropiedadNoEncontradaException;
import com.bienesraices.excepciones.ValorInvalidoException;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors; // Opcional: para filtrado moderno

/**
 * Clase gestora que administra el portafolio de propiedades.
 * Utiliza colecciones (HashMap y ArrayList) para optimizar la gestión.
 */
public class GestorPropiedades {
    // Ejercicio 1: Migrar a List (Historial de inserción)
    private List<Propiedad> historialPropiedades = new ArrayList<>();

    // Ejercicio 2: Implementar HashMap para búsqueda O(1) por código (clave única)
    private Map<String, Propiedad> propiedadesPorCodigo = new HashMap<>();

    /**
     * Agrega una propiedad al portafolio.
     * @param p La propiedad a agregar.
     */
    public void agregarPropiedad(Propiedad p) {
        if (p == null) {
            throw new IllegalArgumentException("No se puede agregar una propiedad nula.");
        }

        // Ejercicio 2: Validación de duplicados con HashMap
        if (propiedadesPorCodigo.containsKey(p.getCodigo())) {
            throw new IllegalArgumentException("Ya existe una propiedad con el código: " + p.getCodigo());
        }

        propiedadesPorCodigo.put(p.getCodigo(), p);
        historialPropiedades.add(p);
    }

    /**
     * Busca una propiedad por su código. O(1) gracias al HashMap.
     * @param codigo El código de la propiedad a buscar.
     * @return La propiedad encontrada.
     * @throws PropiedadNoEncontradaException Si el código no existe en el portafolio.
     */
    public Propiedad buscarPorCodigo(String codigo) throws PropiedadNoEncontradaException {
        // Usa el método get() de HashMap: Búsqueda O(1)
        Propiedad p = propiedadesPorCodigo.get(codigo);

        if (p == null) {
            throw new PropiedadNoEncontradaException("La propiedad con código " + codigo + " no fue encontrada.");
        }
        return p;
    }

    /**
     * Elimina una propiedad del portafolio.
     * @param codigo El código de la propiedad a eliminar.
     * @return La propiedad eliminada, o null si no existía.
     */
    public Propiedad eliminarPropiedad(String codigo) {
        Propiedad p = propiedadesPorCodigo.remove(codigo);
        if (p != null) {
            historialPropiedades.remove(p); // Mantener sincronizadas ambas colecciones
        }
        return p;
    }

    // --- Ejercicio 3: Filtrado y Estadísticas ---

    /**
     * Ejercicio 3.1: Filtra propiedades por rango de precio final.
     */
    public List<Propiedad> filtrarPorRangoPrecioFinal(double min, double max) {
        List<Propiedad> resultado = new ArrayList<>();
        for (Propiedad p : historialPropiedades) {
            if (p.calcularPrecioVentaFinal() >= min && p.calcularPrecioVentaFinal() <= max) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    /**
     * Ejercicio 3.1: Filtra propiedades disponibles o no disponibles.
     */
    public List<Propiedad> filtrarPorDisponibilidad(boolean disponible) {
        return historialPropiedades.stream()
                .filter(p -> p.estaDisponible == disponible)
                .collect(Collectors.toList());
    }

    /**
     * Ejercicio 3.2: Calcula el valor total de las propiedades.
     */
    public double calcularTotalValorPropiedades() {
        double total = 0;
        for (Propiedad p : historialPropiedades) {
            total += p.calcularPrecioVentaFinal();
        }
        return total;
    }

    /**
     * Ejercicio 3.2: Calcula el precio final promedio de las propiedades.
     */
    public double calcularPromedioPrecioFinal() {
        if (historialPropiedades.isEmpty()) return 0;
        return calcularTotalValorPropiedades() / historialPropiedades.size();
    }

    /**
     * Ejercicio 3.2: Obtiene la propiedad con el precio final más alto.
     */
    public Propiedad obtenerPropiedadMasCara() {
        if (historialPropiedades.isEmpty()) return null;
        Propiedad maxima = historialPropiedades.get(0);
        for (Propiedad p : historialPropiedades) {
            if (p.calcularPrecioVentaFinal() > maxima.calcularPrecioVentaFinal()) {
                maxima = p;
            }
        }
        return maxima;
    }

    /**
     * Ejercicio 3.3: Conteo por tipo de propiedad (Residencial, Comercial, etc.).
     */
    public Map<String, Integer> contarPorTipo() {
        Map<String, Integer> conteo = new HashMap<>();
        for (Propiedad p : historialPropiedades) {
            String tipo = p.getClass().getSimpleName();
            conteo.put(tipo, conteo.getOrDefault(tipo, 0) + 1);
        }
        return conteo;
    }

    // --- Otros métodos heredados de Semana 07 ---

    public double calcularComisionVenta(String codigo, double porcentaje)
            throws PropiedadNoEncontradaException, ValorInvalidoException {

        if (porcentaje <= 0 || porcentaje > 1) {
            throw new ValorInvalidoException("El porcentaje de comisión debe estar entre 0.01 y 1.00.");
        }

        Propiedad propiedad = buscarPorCodigo(codigo);

        if (!(propiedad instanceof Vendible)) {
            throw new IllegalStateException("La propiedad con código " + codigo + " no es vendible.");
        }

        Vendible vendible = (Vendible) propiedad;
        return vendible.calcularComisionAsesor(porcentaje);
    }

    public List<Propiedad> getHistorialPropiedades() {
        return historialPropiedades;
    }

    public int cantidad() {
        return historialPropiedades.size();
    }
}