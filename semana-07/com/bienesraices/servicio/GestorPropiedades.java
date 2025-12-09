package com.bienesraices.servicio;

import com.bienesraices.modelo.Propiedad;
import com.bienesraices.modelo.Vendible;
import com.bienesraices.excepciones.PropiedadNoEncontradaException;
import com.bienesraices.excepciones.ValorInvalidoException;
import java.util.ArrayList;

// Clase gestora de la lógica de negocio
public class GestorPropiedades {
    private ArrayList<Propiedad> listaPropiedades = new ArrayList<>();

    public void agregarPropiedad(Propiedad p) {
        // Ejercicio 2: Validar que no se agregue una propiedad nula
        if (p == null) {
            throw new IllegalArgumentException("No se puede agregar una propiedad nula.");
        }
        listaPropiedades.add(p);
    }

    /**
     * Busca una propiedad por su código.
     * @param codigo El código de la propiedad a buscar.
     * @return La propiedad encontrada.
     * @throws PropiedadNoEncontradaException Si el código no existe en el portafolio.
     */
    public Propiedad buscarPorCodigo(String codigo) throws PropiedadNoEncontradaException {
        for (Propiedad p : listaPropiedades) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        // Ejercicio 3: Lanzar excepción personalizada
        throw new PropiedadNoEncontradaException("La propiedad con código " + codigo + " no fue encontrada.");
    }

    /**
     * Calcula la comisión de venta para una propiedad.
     * @param codigo El código de la propiedad.
     * @param porcentaje El porcentaje de comisión a aplicar (debe ser > 0 y <= 1).
     * @return La comisión calculada.
     * @throws PropiedadNoEncontradaException Si la propiedad no existe.
     * @throws ValorInvalidoException Si el porcentaje no es válido.
     */
    public double calcularComisionVenta(String codigo, double porcentaje)
            throws PropiedadNoEncontradaException, ValorInvalidoException {

        // Ejercicio 3: Validar el porcentaje con excepción personalizada
        if (porcentaje <= 0 || porcentaje > 1) {
            throw new ValorInvalidoException("El porcentaje de comisión debe estar entre 0.01 y 1.00.");
        }

        Propiedad propiedad = buscarPorCodigo(codigo);

        // Ejercicio 2: Lanzar error si la propiedad no es Vendible
        if (!(propiedad instanceof Vendible)) {
            throw new IllegalStateException("La propiedad con código " + codigo + " no es vendible.");
        }

        // Refactorizado de Semana 06: Usamos la interface Vendible
        Vendible vendible = (Vendible) propiedad;
        return vendible.calcularComisionAsesor(porcentaje);
    }

    public ArrayList<Propiedad> getListaPropiedades() {
        return listaPropiedades;
    }
}
