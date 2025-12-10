package com.bienesraices.excepciones;

public class PropiedadNoEncontradaException extends Exception {

    public PropiedadNoEncontradaException(String mensaje) {
        super(mensaje);
    }

    public PropiedadNoEncontradaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}