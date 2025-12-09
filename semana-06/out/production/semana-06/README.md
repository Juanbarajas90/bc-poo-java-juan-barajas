# Semana 06: Abstracción e Interfaces- Juan Carlos Barajas

## Dominio
**Agencia de Bienes Raíces** 

## Descripción
Esta entrega refactoriza la jerarquía de `Propiedad` utilizando una **Clase Abstracta** y define **Interfaces** para establecer contratos de comportamiento (capacidades) en el sistema, aplicando principios de diseño como OCP y ISP.

## Clases Abstractas Implementadas

### Propiedad
- **Propósito:** Actuar como la raíz de la jerarquía de inmuebles, definiendo atributos comunes y la fórmula base para el precio final de venta.
- **Métodos abstractos:**
  - `calcularCostoAdicional()`: Calcula costos variables (por habitación, por piso, etc.).
  - `obtenerDescripcionDetallada()`: Proporciona la descripción específica de la subclase.
- **Métodos concretos:**
  - `calcularPrecioVentaFinal()`: Calcula el precio total de venta (PrecioBase + CostoAdicional + Comisión).
  - `mostrarInfoBase()`: Muestra la información genérica del inmueble.
- **Subclases:**
  - `Residencial`
  - `Comercial`

## Interfaces Implementadas

### Vendible
- **Capacidad:** Define el contrato para cualquier objeto que pueda ser sujeto a una transacción de venta.
- **Métodos:**
  - `verificarElegibilidadVenta()`: Chequea si cumple criterios de venta.
  - `generarReporteTransaccion()`: Crea el reporte de la venta.
  - `calcularComisionAsesor()`: Liquida la comisión basada en reglas específicas.
- **Implementada por:**
  - `Residencial`
  - `Comercial`

### Mantenible
- **Capacidad:** Define el contrato para cualquier objeto que requiera inspecciones y tareas de conservación.
- **Métodos:**
  - `obtenerFrecuenciaInspeccionDias()`: Devuelve el intervalo de mantenimiento.
  - `realizarMantenimiento()`: Ejecuta una acción de mantenimiento.
- **Implementada por:**
  - `Residencial` (Los inmuebles residenciales requieren inspecciones periódicas).

## Jerarquía de Clases