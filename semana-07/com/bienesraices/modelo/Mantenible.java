package com.bienesraices.modelo;

// Interface 2: Define la capacidad de ser inspeccionado o mantenido
public interface Mantenible {

    int obtenerFrecuenciaInspeccionDias();

    void realizarMantenimiento(String tarea);
}