# 1. 📄 README.md (Semana 06: Abstracción e Interfaces)

## 🎯 Objetivo General
Refactorizar la jerarquía del sistema de la Agencia de Bienes Raíces aplicando **abstracción** mediante clases abstractas e interfaces, y aplicando principios SOLID para mejorar el diseño.

---

## 📝 Conceptos Clave Implementados

1.  **Clase Abstracta (`Propiedad`):** Se definió el tronco común de la jerarquía (`Propiedad`) como abstracto para compartir atributos (`protected`) y comportamiento común, forzando a las subclases a implementar métodos esenciales (`calcularCostoAdicional`).
2.  **Interfaces (`Vendible`, `Mantenible`):** Se definieron capacidades independientes de la herencia que pueden ser implementadas por diversas clases.
3.  **Múltiple Implementación:** La clase `Residencial` implementa tanto `Vendible` como `Mantenible`.
4.  **Principios SOLID Aplicados:** Se garantiza **OCP** (extensión sin modificación) e **ISP** (interfaces específicas).

---
## 📦 Estructura de Archivos y Carpetas

La siguiente estructura organiza las clases según su rol (abstracción, interfaz o implementación):

| Ubicación | Archivo | Descripción |
| :--- | :--- | :--- |
| `semana-06/` | `Main.java` | Programa principal de demostración. |
| `semana-06/` | `README.md` | Documentación de la entrega. |
| `semana-06/` | `ANALISIS.md` | Justificación del diseño. |
| `abstractas/` | `Propiedad.java` | **Clase Abstracta** (tronco de herencia). |
| `interfaces/` | `Vendible.java` | **Interface** para transacciones y ventas. |
| `interfaces/` | `Mantenible.java` | **Interface** para conservación y mantenimiento. |
| `implementaciones/`| `Residencial.java` | Subclase concreta, implementa `Vendible` y `Mantenible`. |
| `implementaciones/`| `Comercial.java` | Subclase concreta, implementa solo `Vendible`. |

---

## 🚀 Instrucciones de Ejecución

Para compilar y ejecutar el programa desde la raíz de la carpeta `semana-06/`:

```bash
# Compilar todos los archivos con sus paquetes
javac abstractas/*.java interfaces/*.java implementaciones/*.java Main.java 

# Ejecutar el programa
java Main