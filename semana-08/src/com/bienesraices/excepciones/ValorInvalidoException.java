package com.bienesraices.excepciones;

public class ValorInvalidoException extends Exception {

    public ValorInvalidoException(String mensaje) {
        super(mensaje);
    }

    public ValorInvalidoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}