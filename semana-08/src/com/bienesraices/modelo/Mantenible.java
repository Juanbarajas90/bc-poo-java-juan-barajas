package com.bienesraices.modelo;

public interface Mantenible {

    int obtenerFrecuenciaInspeccionDias();

    void realizarMantenimiento(String tarea);
}