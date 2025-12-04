# Análisis de Polimorfismo - Bienes Raíces Plus

## 1. Sobrecarga (Overloading)

### Métodos Sobrecargados
La sobrecarga se implementó en la clase gestora **`Portafolio.java`** en el método `buscarPropiedad`, demostrando la habilidad de buscar propiedades de tres maneras distintas utilizando un único nombre de método:

1.  `buscarPropiedad(String codigo)`: Búsqueda precisa.
2.  `buscarPropiedad(double precioMinimo, double precioMaximo)`: Búsqueda por rango económico.
3.  `buscarPropiedad(int areaMinima)`: Búsqueda por tamaño mínimo.

### Justificación
El uso de sobrecarga en la búsqueda mejora la **usabilidad y la intuitividad** de la API del `Portafolio`. Permite a los desarrolladores y asesores invocar la misma función con argumentos diferentes para lograr filtrados distintos.

---

## 2. Sobrescritura (Overriding)

La sobrescritura se aplica a la jerarquía de `Propiedad` para implementar reglas de negocio específicas y diferenciadas para los tipos de inmuebles.

### Métodos Sobrescritos

Se sobrescribieron dos métodos clave en las subclases **`Residencial.java`** y **`Comercial.java`** que heredan de **`Propiedad.java`**:

1.  **`obtenerDescripcion()`:** Extiende la descripción del padre para incluir detalles de la subclase (ej. número de habitaciones o uso principal).
2.  **`calcularComisionAgencia(double porcentajeBase)`:** Modifica la fórmula de comisión del padre para aplicar reglas fiscales específicas:
    * **En `Residencial`:** Se aplica un **descuento** del 1% sobre el precio base.
    * **En `Comercial`:** Se aplica un **recargo** del 2% sobre el precio base.

### Código Ejemplo
```java
// Fragmento de Comercial.java
@Override
public double calcularComisionAgencia(double porcentajeBase) {
    // Sobrescribe: aplica recargo del 2%
    double comisionBase = super.calcularComisionAgencia(porcentajeBase);
    double recargo = this.precioBase * 0.02;
    return comisionBase + recargo; 
}