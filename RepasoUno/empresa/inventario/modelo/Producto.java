package empresa.inventario.modelo;

public class Producto {
    // ===== Atributos =====
    private String nombre;
    private String codigo;
    private double precio;
    private int cantidadStock;
    private boolean esPerecible;

    // ===== Constructor =====
    public Producto(String nombre, String codigo, double precio, int cantidadStock, boolean esPerecible) {
        this.setNombre(nombre);
        this.setCodigo(codigo);
        this.setPrecio(precio);
        this.setCantidadStock(cantidadStock);
        this.setEsPerecible(esPerecible);
    }

    // ===== Getters y Setters =====
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo != null && codigo.length() >= 5) {
            this.codigo = codigo;
        } else {
            System.out.println("Error: El código debe tener al menos 5 caracteres.");
            this.codigo = "XXXXX";
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {
            System.out.println("Error: El precio no puede ser negativo.");
            this.precio = 0;
        }
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        if (cantidadStock >= 0) {
            this.cantidadStock = cantidadStock;
        } else {
            System.out.println("Error: La cantidad en stock no puede ser negativa.");
            this.cantidadStock = 0;
        }
    }

    public boolean isEsPerecible() {
        return esPerecible;
    }

    public void setEsPerecible(boolean esPerecible) {
        this.esPerecible = esPerecible;
    }

    // ===== Métodos funcionales =====

    // Retorna true si hay stock disponible
    public boolean stockDisponible() {
        return cantidadStock > 0;
    }

    // Muestra datos y estado del producto
    public void mostrarEstado() {
        System.out.println("=== Datos del Producto ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codigo);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad en stock: " + cantidadStock);
        System.out.println("Es perecible: " + esPerecible);
        System.out.println("Stock disponible: " + stockDisponible());
    }

    // Método estático para mostrar reglas
    public static void mostrarReglasProducto() {
        System.out.println("=== Reglas del Producto ===");
        System.out.println("- El código debe tener al menos 5 caracteres.");
        System.out.println("- El precio no puede ser negativo.");
        System.out.println("- La cantidad en stock debe ser mayor o igual a 0.");
    }

    // Calcula el valor total del stock
    public double calcularValorTotal() {
        return precio * cantidadStock;
    }

    // Sobrecarga: aplica descuento
    public double calcularValorTotal(double descuento) {
        double total = calcularValorTotal();
        return total - descuento;
    }

    // toString para mostrar todos los datos
    @Override
    public String toString() {
        return "=== Datos del Producto ===\n" +
                "Nombre: " + nombre + "\n" +
                "Código: " + codigo + "\n" +
                "Precio: " + precio + "\n" +
                "Cantidad en stock: " + cantidadStock + "\n" +
                "Es perecible: " + esPerecible + "\n" +
                "Stock disponible: " + stockDisponible();
    }
}
