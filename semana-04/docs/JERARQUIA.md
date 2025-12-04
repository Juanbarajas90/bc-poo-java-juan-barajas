# Jerarquía de Clases - Semana 04

## 📐 Diagrama

  Propiedad (Clase Padre)
     |
+---------------+---------------+
|               |               |
Residencial   Comercial
(Subclase 1)    (Subclase 2)



## 📝 Justificación

La jerarquía se diseñó identificando que los inmuebles dentro del dominio inmobiliario tienen un **comportamiento fiscal y funcional distinto** según su uso principal. Por lo tanto, la base común de todas las propiedades se maneja en la clase padre, y las diferencias se gestionan en las subclases a través de la herencia y el polimorfismo.

* **Clase Padre (`Propiedad`):** Agrupa los atributos esenciales y métodos comunes a cualquier inmueble, como la dirección o el precio base.
* **Subclase `Residencial`:** Se enfoca en inmuebles de vivienda (casas, apartamentos). Sobrescribe la lógica de impuestos para aplicar un **descuento fiscal** del 10%.
* **Subclase `Comercial`:** Se enfoca en inmuebles para negocio (locales, oficinas). Sobrescribe la lógica de impuestos para aplicar un **recargo fiscal** del 50%.

Este diseño asegura que una lista de propiedades pueda ser procesada de forma uniforme (Polimorfismo), mientras que la regla de negocio específica de impuestos se aplica correctamente en tiempo de ejecución.

## 🔑 Atributos Heredados (Protected)

Los siguientes atributos de la clase `Propiedad.java` se declararon como **`protected`** para que las clases hijas (`Residencial` y `Comercial`) puedan acceder a ellos directamente, respetando el principio de encapsulación frente al resto del código.

* `codigo` (String)
* `direccion` (String)
* `precioBase` (double)
* `areaM2` (int)
* `estaDisponible` (boolean)

## 🔄 Métodos Sobrescritos (`@Override`)

Se implementó la sobrescritura en los siguientes métodos para adaptar la funcionalidad del padre a las reglas de negocio específicas de cada subclase.

### **1. `calcularImpuestos(double tasaBase)`**

Este método es el núcleo del polimorfismo en esta jerarquía.

* **En `Residencial.java`:** El método es sobrescrito para aplicar una reducción o **descuento** del 10% sobre el valor del impuesto base calculado por el padre.
* **En `Comercial.java`:** El método es sobrescrito para aplicar un **recargo** del 50% sobre el valor del impuesto base.

### **2. `mostrarInfo()`**

Este método se sobrescribe en ambas subclases para añadir los detalles únicos a la información que ya presenta el método del padre:

* **En `Residencial.java`:** Se incluye la información del número de habitaciones y si tiene parqueadero.
* **En `Comercial.java`:** Se incluye el uso principal del inmueble y si es apto para alimentos.