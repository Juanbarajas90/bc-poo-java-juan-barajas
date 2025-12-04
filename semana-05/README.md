# Semana 05 - Profundización en Polimorfismo (Sobrecarga y Sobrescritura)

## 📝 Descripción

Esta entrega implementa completamente los dos tipos de polimorfismo en el sistema inmobiliario: **Polimorfismo en tiempo de compilación (Sobrecarga)** y **Polimorfismo en tiempo de ejecución (Sobrescritura)**. Se mejora la clase gestora, `Portafolio.java`, y se extienden las reglas de negocio en la jerarquía `Propiedad`.

## 🎯 Conceptos Clave Implementados

* **Sobrecarga de Métodos:** El método `buscarPropiedad` en `Portafolio.java` fue sobrecargado para filtrar inmuebles por **código**, **rango de precio**, y **área mínima**.
* **Sobrescritura de Métodos:** Se sobrescribieron `obtenerDescripcion()` y `calcularComisionAgencia()` en las subclases (`Residencial.java` y `Comercial.java`) para aplicar reglas de negocio y descripciones específicas.
* **Polimorfismo Dinámico:** `Portafolio.java` utiliza la clase padre (`Propiedad`) como parámetro en sus métodos de procesamiento, permitiendo un código genérico que maneja correctamente cualquier subclase.

## 📂 Archivos Entregados

* `src/Propiedad.java` (Clase Padre actualizada)
* `src/Residencial.java` (Subclase con `@Override`)
* `src/Comercial.java` (Subclase con `@Override`)
* `src/Portafolio.java` (Clase Gestora con Sobrecarga y Métodos Polimórficos)
* `src/AsesorComercial.java` (Clase de soporte)
* `src/Cliente.java` (Clase de soporte)
* `src/Main.java` (Programa de demostración)
* `README.md` (Documentación de la entrega)
* `POLIMORFISMO.md` (Análisis detallado de la implementación)

## 🚀 Instrucciones de Ejecución

Para compilar y ejecutar el programa, asegurando que todos los archivos Java están presentes en la carpeta `src/`:

```bash
javac *.java 
java Main