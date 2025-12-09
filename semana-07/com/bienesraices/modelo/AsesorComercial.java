package com.bienesraices.modelo;

public class AsesorComercial {
    private String idAsesor;
    private String nombre;
    private String telefono;

    public AsesorComercial(String idAsesor, String nombre, String telefono) {
        // Ejercicio 2: Validar ID no nulo
        if (idAsesor == null || idAsesor.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del asesor no puede ser nulo o vacío.");
        }
        this.idAsesor = idAsesor;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getIdAsesor() { return idAsesor; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // toString para fácil impresión
    @Override
    public String toString() {
        return "AsesorComercial{" +
                "idAsesor='" + idAsesor + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}