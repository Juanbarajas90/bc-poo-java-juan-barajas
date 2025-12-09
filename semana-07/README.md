# Semana 07: Paquetes y Excepciones - Agencia de Bienes Raíces

## 👤 Información del Estudiante
- **Nombre**: Juan Carlos Barajas
- **Ficha**: 3228970A
- **Dominio**: Agencia de Bienes Raíces
- **Fecha**: [29/11/2025
- ]

## 📝 Descripción del Proyecto

El proyecto ha sido refactorizado para implementar una arquitectura profesional basada en paquetes (`com.bienesraices`) y se ha fortalecido el código con validaciones robustas y manejo de excepciones, incluyendo dos excepciones personalizadas, para gestionar errores de negocio.

## 📦 Estructura de Paquetes

| Paquete | Descripción | Clases Principales |
| :--- | :--- | :--- |
| `com.bienesraices.modelo/` | Clases de entidades y contratos (abstracciones e interfaces). | `Propiedad`, `Residencial`, `Cliente`, `Vendible` |
| `com.bienesraices.servicio/` | Contiene la lógica de negocio y gestión del portafolio. | `GestorPropiedades` |
| `com.bienesraices.excepciones/` | Contiene las excepciones personalizadas del dominio. | `PropiedadNoEncontradaException`, `ValorInvalidoException` |
| `com.bienesraices/` | Contiene el punto de entrada de la aplicación. | `Main.java` |

## ⚠️ Excepciones Personalizadas

### 1. PropiedadNoEncontradaException
- **Tipo**: Checked (extends `Exception`)
- **Cuándo se lanza**: Cuando se intenta buscar o manipular una propiedad utilizando un código que no existe en el `GestorPropiedades`.
- **Ejemplo**: `gestor.buscarPorCodigo("P999")`

### 2. ValorInvalidoException
- **Tipo**: Checked (extends `Exception`)
- **Cuándo se lanza**: Cuando un parámetro de entrada no cumple con las reglas de negocio, como intentar calcular una comisión con un porcentaje fuera del rango [0.01, 1.00].
- **Ejemplo**: `gestor.calcularComisionVenta("R001", 1.5)`

## 🚀 Cómo Ejecutar

### Desde terminal (compilación y ejecución):
```bash
# Navegar a la carpeta src/
cd semana-07/src/

# Compilar todos los archivos (asegúrate de estar en la carpeta src/)
javac com/bienesraices/*/*.java com/bienesraices/*.java

# Ejecutar el programa (desde la carpeta src/)
java com.bienesraices.Main