package EjercicioUno;

public class Main {
    public static void main(String[] args) {

        Persona persona1= new Persona("1750134510","Concepcion Arequipa",20); //Crear objeto para la clase padre

        Estudiante estudiante1= new Estudiante("1713458010","Jessica",18,"0088"); //Crear objeto para la clase hija Estudiante

        Docente docente1= new Docente("1711595775","Jiovanna Velez",30,"POO"); //Crear objeto para la clase hija Docente

        //Llamar metodo imprimir para cada clase

        persona1.imprimir();
        estudiante1.imprimirEstudiante();
        docente1.imprimirDocente();

    }

}
