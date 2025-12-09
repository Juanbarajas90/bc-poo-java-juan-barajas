# Justificación de Diseño y Manejo de Excepciones - Semana 07

## 1. Justificación de la Estructura de Paquetes (Ejercicio 1)

El código de las semanas anteriores fue refactorizado a la estructura `com.bienesraices.*` para cumplir con los siguientes objetivos:

### Arquitectura de Capas
El sistema ahora sigue una arquitectura de tres capas lógicas:

1.  **Modelo (`com.bienesraices.modelo`):** Contiene la representación del dominio (entidades `Propiedad`, `Cliente`) y sus contratos (`Vendible`, `Mantenible`).
2.  **Servicio (`com.bienesraices.servicio`):** Contiene la lógica de negocio (`GestorPropiedades`). Esta capa es responsable de ejecutar las operaciones y **lanzar las excepciones** si las reglas de negocio fallan.
3.  **Excepciones (`com.bienesraices.excepciones`):** Separa las excepciones personalizadas del dominio, siguiendo el principio de **SRP (Single Responsibility Principle)**.

### Cumplimiento de Convenciones
Se utilizó la convención estándar de Java (`com.[dominio].[módulo]`) para asegurar la coherencia y facilitar la integración futura del código en sistemas más grandes.

## 2. Implementación de Validaciones y Excepciones (Ejercicio 2 y 3)

### Tipo de Excepciones

| Categoría | Clase de Ejemplo | Extensión | Uso en el Proyecto |
| :--- | :--- | :--- | :--- |
| **Unchecked (Runtime)** | `IllegalArgumentException` | `RuntimeException` | Se usa para errores del programador o datos inválidos (ej. precio base $\leq 0$). El programa no está obligado a manejarlo. |
| **Checked (Personalizadas)** | `PropiedadNoEncontradaException` | `Exception` | Se usa para errores de **negocio** (ej. buscar un código inexistente). Obliga al llamador (`Main`) a manejarlas, garantizando la robustez. |

### Excepciones Personalizadas Creadas

1.  **`PropiedadNoEncontradaException`**: Se lanza en la capa de servicio (`GestorPropiedades`) cuando un método de búsqueda falla. Es *checked* porque el cliente del servicio debe saber que la búsqueda puede fallar y manejar esa contingencia.
2.  **`ValorInvalidoException`**: Se lanza en métodos como `calcularComisionVenta()` si los parámetros de entrada (ej., el porcentaje de comisión) están fuera de los rangos permitidos por la regla de negocio. Es *checked* para forzar una entrada de datos correcta.

### Manejo de Excepciones

* **Clase de Modelo (`Propiedad`, `Cliente`):** Se utilizan excepciones **Unchecked** (`IllegalArgumentException`) en *setters* y constructores para fallas inmediatas y validaciones básicas de datos.
* **Clase de Servicio (`GestorPropiedades`):**
    * Declara las excepciones personalizadas con `throws` en la firma del método.
    * Usa `throw new ...` para indicar fallos de negocio.
* **Clase Principal (`Main`):** Se utiliza `try-catch` para manejar todos los tipos de excepciones lanzadas por el servicio, demostrando la capacidad del sistema de recuperarse de errores sin detenerse.

## 3. Demostración y Limpieza (Ejercicio 4)

El `Main.java` incluye 5 casos de prueba que cubren el ciclo completo de manejo de errores, desde la operación exitosa hasta el manejo de fallos Unchecked y Checked.

* **Uso de `finally`:** Se implementó un bloque `finally` para simular la liberación de recursos (cerrar un `BufferedReader`), demostrando que el código de limpieza se ejecuta independiblemente de si se lanza una excepción en el bloque `try` o no.

## 4. Conclusiones

La implementación de paquetes y excepciones en la Semana 07 ha resultado en un código más:
* **Organizado:** Separación de lógica, modelo y manejo de errores.
* **Robusto:** Validaciones previas que evitan estados inconsistentes.
* **Seguro:** Manejo explícito de errores de negocio mediante excepciones *checked*.