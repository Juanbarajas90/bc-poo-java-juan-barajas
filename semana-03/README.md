# Semana 03 - Encapsulación, Constructores y Validaciones

## 📝 Descripción

Esta entrega se enfoca en la **calidad y robustez** del código de la inmobiliaria mediante la aplicación rigurosa de principios de POO. Todas las clases han sido **refactorizadas** para garantizar la **integridad de los datos** y la **flexibilidad en la creación de objetos**.

## 🎯 Objetivos Cumplidos

- [x] **Encapsulación Completa:** Todos los atributos son `private` y solo se acceden mediante Getters y Setters.
- [x] **Sobrecarga de Constructores:** Cada clase de negocio (`Propiedad`, `AsesorComercial`, `Cliente`, `Contrato`, `Portafolio`) tiene un **mínimo de dos constructores** diferentes.
- [x] **Validaciones Implementadas:** Los Setters y Constructores verifican que los datos críticos (ej. precios, longitudes, tipos) sean válidos antes de ser almacenados, utilizando `throw new IllegalArgumentException` para manejar datos inválidos.
- [x] Documento `MEJORAS.md` completado.
- [x] Código fuente completo y funcional (`Main.java`).

## 📂 Archivos Entregados

* `src/Propiedad.java`
* `src/AsesorComercial.java`
* `src/Cliente.java`
* `src/Contrato.java`
* `src/Portafolio.java`
* `src/Main.java`
* `README.md`
* `MEJORAS.md`

## 🚀 Instrucciones de Ejecución

Para compilar y ejecutar el programa desde la terminal (asume que se está en la carpeta `semana-03/src/`):

```bash
javac *.java 
java Main