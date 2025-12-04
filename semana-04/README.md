# Semana 04 - Implementación de Herencia y Polimorfismo

## 📝 Descripción

Esta entrega migra el modelo de la inmobiliaria "Bienes Raíces Plus" para utilizar la **Herencia**. La clase base `Propiedad` se convierte en la clase padre de una jerarquía que distingue entre inmuebles **Residenciales** y **Comerciales**. Esto permite que cada tipo de propiedad tenga reglas de negocio específicas (ej. cálculo de impuestos) manteniendo una interfaz común.

## 🎯 Conceptos Clave Demostrados

1.  **Herencia (`extends`):** La clase `Propiedad` es la clase padre. `Residencial` y `Comercial` son las subclases.
2.  **Atributos `protected`:** Los atributos comunes de la clase padre (`codigo`, `direccion`, `precioBase`, etc.) son declarados `protected` para ser accesibles directamente por las subclases.
3.  **Sobrescritura (`@Override`):** Se sobrescribe el método `calcularImpuestos()` en cada subclase para aplicar reglas fiscales específicas (descuento residencial vs. recargo comercial).
4.  **Polimorfismo:** El `Main.java` utiliza un **array polimórfico** (`Propiedad[]`) para procesar indistintamente objetos `Residencial` y `Comercial`, invocando la lógica correcta de impuestos para cada uno en tiempo de ejecución.

## 📂 Archivos Entregados

* `src/Propiedad.java` (Clase Padre)
* `src/Residencial.java` (Subclase 1)
* `src/Comercial.java` (Subclase 2)
* `src/Main.java` (Demostración de Polimorfismo)
* `README.md` (Documentación)
* `JERARQUIA.md` (Justificación del diseño)

## 🚀 Instrucciones de Ejecución

Para compilar y ejecutar el programa desde la terminal (asume que se está en la carpeta `semana-04/src/`):

```bash
javac *.java 
java Main