package parte.dos;

public class Producto {
    private double precio;
    private String nombre;

    public void setPrecio(double precio) {

        if (precio <= 0 ) {
            System.out.println("Precio invalido ,debe ser mayor a 0");
        }
        else {
            this.precio = precio;
        }
    }

    public  double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        if (nombre.length()==0){
            System.out.println("Nombre invalido, esta vacio");
        }
        else{
            this.nombre = nombre;
        }
    }


    public String getNombre() {
        return nombre;
    }

    public void mostrarDatos() {
        System.out.println("Informacion del producto");
        System.out.println("Nombre: "+nombre);
        System.out.println("Precio: "+precio);
    }
}
