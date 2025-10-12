//Ejemplo de la creacion de objetos
public class Coche {
    String marca;
    String color;

    public Coche(String marca, String color) {
        this.marca = marca;
        this.color = color;
    }

    public void mostrarDatos() {
        System.out.println("Marca: " + marca);
        System.out.println("Color: " + color);
        System.out.println("------------------");
    }

    public static void main(String[] args) {
        // Crear objetos
        Coche c1 = new Coche("Toyota", "Rojo");
        Coche c2 = new Coche("Honda", "Azul");

        // Mostrar información de cada coche
        c1.mostrarDatos();
        c2.mostrarDatos();
    }
}


