
//Ejemplo sencillo de abstraccion
// Clase abstracta
abstract class Figura {
    // Metodo abstracto (sin implementación)
    abstract double calcularArea();

    // Metodo normal con implementación
    public void mostrarMensaje() {
        System.out.println("Esta es una figura geométrica.");
    }
}

// Subclase que extiende la clase abstracta
class Rectangulo extends Figura {
    double base;
    double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    // Implementación del metodo abstracto
    @Override
    double calcularArea() {
        return base * altura;
    }
}

// Clase principal
public class EjemploAbstraccion {
    public static void main(String[] args) {
        Rectangulo r = new Rectangulo(5, 3);
        r.mostrarMensaje();  // Metodo de la clase abstracta
        System.out.println("Área del rectángulo: " + r.calcularArea());
    }
}
