# Bootcamp POO Java - Juan Carlos Barajas

## ℹ️ Información del Estudiante

* **Estudiante:** Juan Carlos Barajas
* **Ficha:** 3228970A
* **Dominio Principal:** Agencia de Bienes Raíces
* **Instructor:** Erick Granados Torres

---

## 🗺️ Estructura del Repositorio y Progreso Semanal

El repositorio está organizado por el progreso semanal del Bootcamp, reflejando el desarrollo incremental del sistema de **Gestión de Propiedades de Bienes Raíces**.

| Carpeta | Estado | Tema Central de POO | Clases y Conceptos Clave |
| :--- | :--- | :--- | :--- |
| `semana-01/` | ✅ Completo | Introducción a POO (Clases, Atributos) | Estructura base de `Propiedad`. |
| `semana-02/` | ✅ Completo | Clases y Objetos (Instanciación) | Clases `Cliente` y `AsesorComercial`. |
| `semana-03/` | ✅ Completo | Encapsulación y Constructores | Propiedades con atributos privados (`private`) y métodos `get/set`. |
| `semana-04/` | ✅ Completo | Herencia | Creación de la jerarquía: `Propiedad` > `Residencial`, `Comercial`. |
| `semana-05/` | ✅ Completo | Polimorfismo (Sobrecarga, Sobrescritura) | Clase gestora `Portafolio` (Sobrecarga de búsqueda); Sobrescritura de métodos de cálculo en subclases. |
| `semana-06/` | ✅ Completo | **Abstracción e Interfaces (SOLID)** | `Propiedad` (Clase Abstracta); Interfaces `Vendible` y `Mantenible`. |
| `semana-07/` | 🚧 En Curso | **Paquetes y Excepciones** | Refactorización a `com.bienesraices.*`; Excepciones personalizadas (`PropiedadNoEncontradaException`). |
| `semana-08/` | ➡️ Pendiente | Estructuras de Datos en Java | Implementación de `ArrayList` y `HashMap` en el Portafolio. |
| `semana-09/` | ➡️ Pendiente | Proyecto Final Aplicado | Integración total del sistema. |

---

## 🚀 Cómo Compilar y Ejecutar

Las instrucciones varían significativamente a partir de la Semana 07 debido a la introducción de la estructura de paquetes.

### 1. Semanas 01 a 06 (Estructura Simple)

Para compilar y ejecutar el código de cualquier semana entre la 01 y la 06:

```bash
# 1. Navegar a la carpeta de código fuente
cd semana-XX/src 

# 2. Compilar todos los archivos .java
javac *.java

# 3. Ejecutar la clase principal
java Main