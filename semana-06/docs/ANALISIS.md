# Análisis de Diseño - Semana 06: Agencia de Bienes Raíces

## 1. Identificación de Abstracciones

### Clase(s) Abstracta(s)
**Nombre:** `Propiedad` (en `abstractas/Propiedad.java`)

**¿Por qué es abstracta?**
Es un concepto general que establece el **"es-un"** común (toda `Residencial` *es una* `Propiedad`). Se hizo abstracta porque nunca se instancia directamente y necesita compartir estado (atributos `protected`) y comportamiento base (`calcularPrecioVentaFinal()`), mientras que fuerza a las subclases a implementar el comportamiento variable (`calcularCostoAdicional()`).

**Jerarquía:**
<<abstract>>
      Propiedad
          |
  +-------+-------+
  |               |
Residencial Comercial

## 2. Interfaces Implementadas

### Interface 1: `Vendible` (en `interfaces/Vendible.java`)
**Capacidad que define:** El contrato para la transacción. Incluye métodos para `verificarElegibilidadVenta()` y `calcularComisionAsesor()`.
**Clases que la implementan:** `Residencial` y `Comercial`. Permite que un futuro `GestorTransacciones` solo dependa de esta interfaz, no de las clases concretas.

### Interface 2: `Mantenible` (en `interfaces/Mantenible.java`)
**Capacidad que define:** El contrato para la conservación física. Incluye métodos para `obtenerFrecuenciaInspeccionDias()` y `realizarMantenimiento()`.
**Clases que la implementan:** Solo `Residencial`, ya que las propiedades residenciales son las únicas que requieren este tipo de gestión periódica en el dominio actual.

## 3. Decisiones de Diseño

### ¿Por qué Clase Abstracta vs Interface?

**Elegí clase abstracta para `Propiedad` porque:**
1. Hay una relación de **herencia estricta** ("es-un").
2. Necesidad de **compartir estado** (atributos `protected` como `precioBase`).
3. Necesidad de **comportamiento implementado** (el método `calcularPrecioVentaFinal()` es común).

**Elegí interface para `Vendible` y `Mantenible` porque:**
1. Define una **capacidad** (un "puede hacer") que es independiente de la jerarquía de herencia.
2. Permite la **múltiple implementación** (una `Residencial` puede ser `Vendible` y `Mantenible`).
3. Cumple con **ISP**, separando las responsabilidades de transacción y conservación.

## 4. Principios SOLID Aplicados

### Open/Closed Principle (OCP)
Se logra al definir `calcularCostoAdicional()` como abstracto. Para agregar una nueva propiedad (`Lote`), simplemente se crea la subclase, se implementa el nuevo costo adicional, y el método concreto `calcularPrecioVentaFinal()` de la clase padre sigue funcionando sin necesidad de modificarlo.

### Interface Segregation Principle (ISP)
Al separar las capacidades en `Vendible` y `Mantenible`, la clase `Comercial` no fue obligada a implementar la lógica de mantenimiento que no necesita, manteniendo sus responsabilidades puras y enfocadas.

### Liskov Substitution Principle (LSP)
El programa de demostración usa una lista de tipo `Propiedad` (la clase abstracta) y la itera. Las subclases (`Residencial` y `Comercial`) sustituyen perfectamente a la clase abstracta y, al llamar a los métodos polimórficos, ejecutan la lógica correcta de la subclase.

## 5. Mejoras Logradas

**Antes (Semana 05):** La diferenciación de propiedades se hacía solo por sobrescritura de clases concretas, limitando el diseño a una herencia simple.
**Después (Semana 06):**
- El diseño es más robusto y modular gracias a la separación de responsabilidades en interfaces.
- La **extensibilidad** es mayor (OCP).
- El sistema puede ahora interactuar con objetos por su capacidad (`Vendible`), en lugar de por su tipo concreto, facilitando el desarrollo de módulos de gestión financiera y de mantenimiento.

## 6. Diagrama de Clases



## 7. Desafíos y Soluciones

**Desafío 1:** ¿Cómo integrar `Mantenible` sin obligar a todas las propiedades a implementarlo?
**Solución:** Aplicar ISP, creando `Mantenible` como una interfaz separada y solo implementándola en `Residencial`.

**Desafío 2:** Asegurar que el método `calcularPrecioVentaFinal()` siga siendo común y no se sobrescriba accidentalmente.
**Solución:** Definir este método como **concreto** en la clase abstracta `Propiedad` y basarlo en la llamada al método abstracto `calcularCostoAdicional()`, protegiendo la lógica de negocio central.