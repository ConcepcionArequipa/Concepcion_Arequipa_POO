package EjercicioUno;

public class Docente extends Persona {
    String materia;
    //Metodo constructor de la clase hija

    public Docente(String cedula, String nombre, int edad, String materia) {
        // super(...) se utiliza para inicializar los atributos de la clase padre (superclase) llamando a uno de sus constructores.
        super(cedula, nombre, edad);
        this.materia = materia;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Materia del docente: " + materia);
    }

    public void imprimirDocente() {
        imprimir();
    }

}
