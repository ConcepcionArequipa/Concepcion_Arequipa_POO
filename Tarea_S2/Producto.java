//Creacion de la clase Producto
public class Producto {
    //Atributos
    String nombre;
    double precio;
    int cantidad;

    // Implementacion de los tipos de constructor

    //Constructor con parametros
    public Producto (String nombre, double precio, int cantidad){
        //Inicializar los atributos
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    //Constructor sin parámetros con valores fijos)
    public Producto (){
        nombre = "Laptop";
        precio = 600.50;
        cantidad = 6;
    }
    //Constructor vacío
    // Se usa el parámetro boolean para diferenciarlo del constructor anterior
    // Razon: No se permite que los constructores tengan la misma lista de parametros
    public Producto(boolean vacio){

    }

    //Metodo para mostrar los datos de cada objeto
    void mostrarProducto(){
        System.out.println("Nombre del producto: "+nombre);
        System.out.println("Precio: "+precio);
        System.out.println("Cantidad del producto: "+cantidad);
        System.out.println("-------------------------------------");
    }

    //Creacion de los tres objetos usando cada tipo de constructor
    public static void main(String [] args){

        //Objeto creado con el constructor con parametros
        Producto productoUno=new Producto("Celular",500,2);

        //Objeto creado con el constructor sin parametros con valores fijos
        Producto productoDos=new Producto();

        //Objeto creado con el constructor sin parametros
        Producto productoTres=new Producto(true );

        productoUno.mostrarProducto();
        productoDos.mostrarProducto();
        productoTres.mostrarProducto();
    }

}

