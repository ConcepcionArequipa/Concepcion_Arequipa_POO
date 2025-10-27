package ejercicio.dos;

public class Main {
    public static void main(String[] args) {
        //Crear objeto
        Estudiante estudiante = new Estudiante();
        System.out.println(estudiante);
        //Invocar al metodo saludar
        estudiante.saludar();
        estudiante.modificar("Juan");
        System.out.println(estudiante);
        estudiante.saludar("Monica");
    }
}
