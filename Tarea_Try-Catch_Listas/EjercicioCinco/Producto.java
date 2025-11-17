package EjercicioCinco;

public abstract class Producto {
    protected String codigo;
    protected String nombre;
    protected double precioBase;

    public Producto(String codigo, String nombre, double precioBase) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede estar vacío");
        }

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }


        if (precioBase < 0) {
            throw new IllegalArgumentException("El precio base no puede ser negativo");
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    public abstract double calcularPrecioFinal();
    @Override
    public String toString() {
        return "Código: " + codigo +
                ", Nombre: " + nombre +
                ", Precio base: " + precioBase +
                ", Precio final: " + calcularPrecioFinal();
    }
}
