# Semana 08: Colecciones y Generics - Agencia de Bienes Raíces

## 👤 Información del Estudiante
- **Nombre**: Yilmer Hernandez Camargo
- **Ficha**: 3228970A
- **Dominio**: Agencia de Bienes Raíces
- **Fecha**: [DD/MM/YYYY]

## 📝 Descripción del Proyecto

El objetivo de la Semana 08 fue migrar el módulo de gestión de propiedades de arrays estáticos a Colecciones de Java, implementando `ArrayList` y `HashMap` con Generics para mejorar la escalabilidad y el rendimiento del sistema.

**Esta semana**: Refactoricé el sistema `GestorPropiedades` para usar colecciones profesionales. Se logró una búsqueda de propiedades eficiente O(1), se habilitaron operaciones avanzadas de filtrado y se integraron cálculos de estadísticas detalladas del portafolio.

## 📦 Colecciones Utilizadas

### HashMap
- `Map<String, Propiedad>`: Se utiliza en `GestorPropiedades` para almacenar las propiedades, usando el **código** de la propiedad como clave. Esto permite una **búsqueda instantánea O(1)** (constante) por código.
- `Map<String, Integer>`: Se utiliza de forma auxiliar en la función `contarPorTipo()` para agrupar y contar las propiedades por tipo (`Residencial`, `Comercial`).

### ArrayList
- `List<Propiedad>`: Se usa como `historialPropiedades` en `GestorPropiedades`. Su propósito es mantener un listado ordenado por inserción y facilitar la **iteración** para operaciones de filtrado y listados completos.

## 🔍 Operaciones Implementadas

### CRUD con Colecciones
- ✅ **Agregar** con validación de duplicados: El `HashMap` previene la inserción de códigos repetidos.
- ✅ **Buscar** por clave O(1) con HashMap: Implementado en `buscarPorCodigo()`.
- ✅ **Eliminar** por código: Se elimina tanto del `HashMap` como del `ArrayList` para mantener la sincronización.

### Filtrado
- ✅ **Filtrar** por rango de precio final: Permite acotar la búsqueda por valores mínimos y máximos de venta.
- ✅ **Filtrar** por disponibilidad: Permite listar propiedades disponibles o no disponibles.
- ✅ **Filtrar** por [otro criterio]: Los métodos de listado actúan como un filtro general.

### Estadísticas
- ✅ **Valor Total** de ventas: Suma de `calcularPrecioVentaFinal` de todas las propiedades.
- ✅ **Promedio** de precios: Valor total / cantidad de propiedades.
- ✅ **Elemento más caro/barato**: Identifica la propiedad con el precio final más alto (`obtenerPropiedadMasCara`).
- ✅ **Conteo por categoría**: Agrupa y cuenta por tipo de propiedad (`contarPorTipo`).

## 🚀 Cómo Ejecutar

### Desde terminal:
```bash
# 1. Navegar a la carpeta de la semana
cd semana-08

# 2. Compilar (asegura la creación de paquetes en la carpeta bin)
javac -d bin src/com/bienesraices/*/*.java src/com/bienesraices/*.java

# 3. Ejecutar la clase principal
java -cp bin com.bienesraices.Main