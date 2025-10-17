package parte.dos;

public class Main {
    public static void main(String[] args) {
        //Creacion del objeto
        Producto productoUno=new Producto();

        //Precio valido
        System.out.println("------------------------------");
        System.out.println("Prueba con precio valido");
        productoUno.setPrecio(700);
        productoUno.setNombre("Laptop Gamer");
        productoUno.mostrarDatos();

        System.out.println("------------------------------");
        System.out.println("Prueba con precio invalido");
        //Precios invalidos
        productoUno.setPrecio(-80);
        productoUno.mostrarDatos();
    }
}
