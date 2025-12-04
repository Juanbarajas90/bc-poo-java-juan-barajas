# Análisis Orientado a Objetos - Inmobiliaria "Bienes Raíces Plus"

## 1. Identificación del Dominio

**Nombre del negocio:** Bienes Raíces Plus
**Tipo:** Inmobiliaria
**Descripción:** El negocio se centra en la **gestión de inmuebles** para su venta o arriendo. El flujo principal es conseguir una propiedad, asignarla a un asesor y realizar una transacción exitosa.

---

## 2. Objetos Implementados

### Objeto Principal: Propiedad

**¿Qué es?:** Es el **producto** central del negocio, el activo inmobiliario (apartamento, casa, local) que se ofrece a los clientes. Es el objeto más importante porque representa lo que la inmobiliaria gestiona y vende.

**Atributos identificados:**
- **codigo:** String - Un identificador único, como si fuera la referencia de un producto en un inventario.
- **direccion:** String - La ubicación necesaria para que el asesor pueda mostrar el inmueble.
- **precioBase:** double - El precio que se usa como base para cualquier negociación o cálculo de comisión.
- **areaM2:** int - El tamaño físico del inmueble, importante para el valor y la descripción.
- **estaDisponible:** boolean - Indicador clave para saber si la propiedad sigue en el mercado o si ya fue negociada.

**Métodos identificados:**
- **mostrarInformacion():** Imprime todos los detalles de la propiedad en la pantalla para consultarlos rápidamente.
- **calcularPrecioFinal(incremento):** Permite calcular cuánto costará la propiedad al final, incluyendo gastos o un porcentaje extra de valorización.
- **getCodigo():** Nos permite obtener el código de la propiedad sin necesidad de acceder directamente al atributo, manteniendo la información segura.
- **setDisponible(estado):** Es la acción que se ejecuta cuando la propiedad pasa de estar 'DISPONIBLE' a 'NO DISPONIBLE' (vendida o arrendada).

### Objeto Secundario: AsesorComercial

**¿Qué es?:** Es el **empleado** que ejecuta las acciones de venta y arriendo, interactuando con las propiedades y los clientes. Su rendimiento afecta directamente los ingresos de la inmobiliaria.

**Atributos identificados:**
- **identificacion:** String - La cédula o número de identificación que lo diferencia de otros asesores.
- **nombre:** String - Su nombre completo.
- **contacto:** String - Su número o correo para contactar a los clientes.
- **propiedadesVendidas:** int - Un contador que registra cuántas transacciones ha cerrado.

**Métodos identificados:**
- **mostrarDatos():** Imprime la información personal del asesor y su historial de ventas.
- **registrarVentaExitosa():** Aumenta en uno el contador de `propiedadesVendidas` cada vez que cierra un negocio.
- **calcularBonoPorVenta(valor):** Utiliza el contador de ventas para calcular cuánto dinero extra debe recibir el asesor.
- **getPropiedadesVendidas():** Permite obtener el valor actual del contador de ventas.

## 3. Relación entre Objetos

**Tipo de relación:** Asociación (Gestión y Responsabilidad)

**Descripción:** El **Asesor Comercial** es responsable de la **Propiedad**. Un asesor trabaja para cambiar el estado de la propiedad (de `disponible` a `no disponible`) y registra este éxito en su propio historial (aumentando `propiedadesVendidas`). El sistema necesita que ambas clases se conozcan para modelar este flujo de trabajo.

---

## 4. Justificación del Diseño

**¿Por qué elegí estos objetos?**
Porque representan el flujo de negocio: la Inmobiliaria (`Dominio`) gestiona una **Propiedad** (Objeto Principal) a través de un **Asesor Comercial** (Objeto Secundario). Si faltara cualquiera de estos dos objetos, la simulación del negocio sería incompleta.

**¿Por qué estos atributos son importantes?**
Los atributos son la información mínima necesaria para que la inmobiliaria funcione:
* **`precioBase` y `areaM2`:** Determinan el valor comercial y el avalúo.
* **`estaDisponible`:** Evita errores de vender dos veces el mismo inmueble.
* **`propiedadesVendidas`:** Es la métrica clave para medir el rendimiento del empleado y calcular su pago.

**¿Por qué estos métodos son necesarios?**
Los métodos son las acciones de negocio:
* **`calcularPrecioFinal()`:** Es necesario para aplicar las reglas financieras de la empresa (ganancias, gastos).
* **`setDisponible()`:** Es la acción de **cierre** de negocio, el cambio de estado más crítico.
* **`registrarVentaExitosa()`:** Es la forma en que el sistema recompensa o mide el trabajo del asesor.

## 5. Comparación: POO vs Programación Estructurada

**Sin POO (Estructurado):**
Tendríamos variables separadas (ej: `codigo_p1`, `precio_p1`, `ventas_a1`) y un montón de funciones globales (ej: `cambiar_estado_propiedad(codigo, nuevo_estado)`). Si tuviéramos 300 propiedades, manejar 300 variables de código, precio, etc., sería imposible. Los datos y las funciones que los manipulan estarían en lugares diferentes.

**Con POO:**
Agrupamos la información y sus acciones dentro de unidades llamadas **Clases**.
* La **Clase `Propiedad`** junta el `precioBase`, la `direccion` y las acciones como `calcularPrecioFinal()` o `setDisponible()`. La propiedad sabe cómo gestionarse a sí misma.
* La **Clase `AsesorComercial`** junta su `nombre` con su `propiedadesVendidas` y la acción `calcularBonoPorVenta()`. El asesor es una entidad independiente.

**Ventajas específicas en mi dominio:**
1.  **Organización:** En lugar de tener una lista larga de variables, creamos **objetos** que son réplicas del mundo real. Si necesitamos una nueva propiedad, solo creamos un nuevo objeto `Propiedad`.
2.  **Seguridad (Encapsulamiento):** Usamos atributos `private` (privados) y obligamos a usar métodos `getter/setter` para cambiar los datos (como `setDisponible`). Esto evita que otra parte del código modifique el precio de la propiedad por error.
3.  **Flexibilidad:** Si la inmobiliaria decide agregar un nuevo atributo (como 'tipo_calefacción'), solo debemos cambiar la **Clase `Propiedad`**, sin modificar la **Clase `AsesorComercial`** o el `Main`, haciendo el sistema más fácil de actualizar.

---