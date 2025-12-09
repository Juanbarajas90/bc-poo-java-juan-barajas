package com.bienesraices.modelo;

public class Cliente {
    private String nombre;
    private String telefono;
    private String email;

    public Cliente(String nombre, String telefono, String email) {
        // Ejercicio 2: Validar nombre no nulo
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede ser nulo o vacío.");
        }
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString para fácil impresión
    @Override
    public String toString() {
        return "Cliente{" + "nombre='" + nombre + '\'' + ", email='" + email + '\'' + '}';
    }
}