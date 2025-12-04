# Mejoras - Semana 03: Encapsulación y Constructores

## Encapsulación Aplicada

Se ha refactorizado la totalidad de las clases de negocio (`Propiedad`, `AsesorComercial`, `Cliente`, `Contrato`, `Portafolio`) para aplicar el principio de **Encapsulación**. Todos los atributos ahora son `private` y su modificación se realiza exclusivamente a través de **Setters con validaciones**.

### Clase: Propiedad
- **Atributos encapsulados:** `codigo`, `direccion`, `precioBase`, `areaM2`, `estaDisponible`.
- **Validaciones agregadas:** Se valida que el `precioBase` sea **positivo** y que el `areaM2` sea de **al menos 10** m².

### Clase: AsesorComercial
- **Atributos encapsulados:** `identificacion`, `nombre`, `contacto`, `propiedadesVendidas`.
- **Validaciones agregadas:** Se valida que la `identificacion` tenga un **mínimo de 5 caracteres** y que el contador de `propiedadesVendidas` **no pueda ser negativo**.

### Clase: Cliente
- **Atributos encapsulados:** `identificacion`, `nombre`, `telefono`, `tipoCliente`.
- **Validaciones agregadas:** Se valida que el `telefono` cumpla un rango de longitud (7-15) y que el `tipoCliente` sea un **valor válido predefinido** (Comprador, Arrendador, Propietario, Pendiente).

### Clase: Contrato
- **Atributos encapsulados:** `numeroContrato`, `tipoTransaccion`, `valorAcordado`, y las referencias de Agregación.
- **Validaciones agregadas:** Se valida que el `valorAcordado` sea superior a un monto mínimo y que el `tipoTransaccion` sea estrictamente **'Venta' o 'Arriendo'**.

## 🏗️ Constructores Sobrecargados

Todas las clases implementan ahora un **mínimo de dos constructores** (`this(...)`) para ofrecer mayor flexibilidad en la creación de objetos y asegurar valores por defecto cuando no se proporcionan todos los datos.

### Clase: Propiedad
- **Constructor 1:** **Completo**. Inicializa todos los atributos.
- **Constructor 2:** **Básico** (`codigo`, `direccion`, `precioBase`). Asume un valor por defecto para el `areaM2` (40 m²).

### Clase: AsesorComercial
- **Constructor 1:** **Completo**. Inicializa `identificacion`, `nombre`, y `contacto`.
- **Constructor 2:** **Básico** (`identificacion`, `nombre`). Asigna **"Contacto Pendiente"** por defecto.

### Clase: Contrato
- **Constructor 1:** **Completo**. Asigna todos los datos y las referencias de Agregación (`Propiedad`, `Cliente`, `AsesorComercial`).
- **Constructor 2:** **Básico** (`numeroContrato`, `tipoTransaccion`, `valorAcordado`, `Propiedad`). Inicializa el contrato sin referencias a `Cliente` o `Asesor`.

### Clase: Portafolio
- **Constructor 1:** **Completo**. Permite inicializar la agencia e inyectar listas de `Propiedad` y `AsesorComercial` ya existentes.
- **Constructor 2:** **Básico** (`nombreAgencia`). Inicializa las colecciones internas (`ArrayList`) como **listas vacías**.

## ✨ Beneficios Logrados

1.  **Integridad de Datos:** Es imposible crear o modificar un objeto con datos lógicamente incorrectos (ej. precio negativo, código corto).
2.  **Seguridad (Robustez):** El uso de `IllegalArgumentException` detiene el programa inmediatamente ante un error de datos, facilitando la depuración y evitando estados inválidos del objeto.
3.  **Flexibilidad:** La sobrecarga de constructores simplifica la inicialización de objetos, permitiendo crear instancias con solo la información crítica al inicio.