package EjercicioUno;

public class Estudiante extends Persona {
    //Esta clase hereda los atributos de la clase padre Persona
    // Por lo tanto, no es necesario escribir los atributos de la clase padre

    String codigo; //Solo se escribe lo adicional para la clase hija

    //Es necesario que se tenga un metodo constructor para la clase hija

    public Estudiante(String cedula, String nombre, int edad, String codigo) {

        super(cedula, nombre, edad);  //Nota: No se puede inicializar como el metodo constructor de la clase padre, se debe inicializar mediante super para llamar a los atributos
        this.codigo = codigo;
    }

    //Invocar el metodo de la clase padre, se lo hace mediante super

    // Se usa override ya que vamos a sobreescribir el metodo, esto sucede si el metodo tiene la misma firma que el padre
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Codigo del estudiante: " + codigo);
    }

    public void imprimirEstudiante() {
        imprimir();
    }

}
