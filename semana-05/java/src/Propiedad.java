public class Propiedad {
    // Atributos protegidos (visibles para subclases)
    protected String codigo;
    protected String direccion;
    protected double precioBase;
    protected int areaM2;
    protected boolean estaDisponible;

    // --- CONSTRUCTOR PADRE ---
    public Propiedad(String codigo, String direccion, double precioBase, int areaM2) {
        setCodigo(codigo);
        setDireccion(direccion);
        setPrecioBase(precioBase);
        setAreaM2(areaM2);
        this.estaDisponible = true;
    }

    // --- MÉTODOS HEREDADOS Y SOBRESCRITOS (Base para Polimorfismo) ---

    // Método 1: Descripción para Sobrescribir (Semana 05)
    public String obtenerDescripcion() {
        return "Propiedad de tipo general: " + this.codigo + " en " + this.direccion;
    }

    // Método 2: Comisión para Sobrescribir (Semana 05)
    public double calcularComisionAgencia(double porcentajeBase) {
        // Comisión base para cualquier tipo de propiedad
        return this.precioBase * porcentajeBase;
    }

    // Método 3: Impuestos (Heredado de Semana 04)
    public double calcularImpuestos(double tasaBase) {
        return this.precioBase * tasaBase;
    }

    // Método 4: Mostrar Info (Heredado de Semana 04)
    public void mostrarInfo() {
        System.out.println("ID: " + this.codigo + " | Dirección: " + this.direccion);
        System.out.println("Precio Base: $" + this.precioBase + " | Área: " + this.areaM2 + " m²");
    }

    // --- GETTERS (Se mantienen para encapsulamiento) ---
    public String getCodigo() { return this.codigo; }
    public String getDireccion() { return this.direccion; }
    public double getPrecioBase() { return this.precioBase; }
    public int getAreaM2() { return this.areaM2; }
    public boolean isEstaDisponible() { return this.estaDisponible; }

    // --- SETTERS CON VALIDACIÓN (Se mantienen) ---
    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty() || codigo.length() < 3) {
            throw new IllegalArgumentException("El código de la propiedad es inválido (mínimo 3 caracteres).");
        }
        this.codigo = codigo;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }
        this.direccion = direccion;
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase <= 0) {
            throw new IllegalArgumentException("El precio base debe ser un valor positivo.");
        }
        this.precioBase = precioBase;
    }

    public void setAreaM2(int areaM2) {
        if (areaM2 < 10) {
            throw new IllegalArgumentException("El área en m² debe ser de al menos 10.");
        }
        this.areaM2 = areaM2;
    }

    public void setDisponible(boolean nuevoEstado) {
        this.estaDisponible = nuevoEstado;
    }
}