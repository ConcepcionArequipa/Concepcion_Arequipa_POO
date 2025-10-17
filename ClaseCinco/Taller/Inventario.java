package Taller;

public class Inventario {
    String nombreProducto;
    private int cantidad;
    private double precioUnitario;
    String categoria;

//Metodo constructor sin parametros pero con valores fijos
    public Inventario() {
        nombreProducto = "Iphone X";
        cantidad = 100;
        precioUnitario = 600;
        categoria = "Dispositivo electronico";

    }

    //Metodo constructor con parametros

    public Inventario(String nombreProducto, int cantidad, double precioUnitario, String categoria) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.categoria = categoria;
    }

    void mostrarInformacion() {
        System.out.println("--------------------------------- ");
        System.out.println("Nombre: "+nombreProducto);
        System.out.println("Cantidad: "+cantidad);
        System.out.println("Precio: "+precioUnitario);
        System.out.println("El producto pertenece a la categoria: "+categoria);
    }

    void calcularStock(){
        System.out.println("Stock del producto");
        System.out.println("Stock: "+cantidad*precioUnitario);
        System.out.println("----------------------------------");
    }

}


