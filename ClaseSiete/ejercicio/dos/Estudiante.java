package ejercicio.dos;

public class Estudiante {
    //Atributos privados
    private String codigo="0001";
    private String nombre="Concepcion Arequipa";
    private String carrera="Desarrollo de Software";
    private int semestre=3;

    @Override
    public String toString() {
        return "Estudiante{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", carrera='" + carrera + '\'' +
                ", semestre=" + semestre +
                '}';
    }

    // Aplicar sobre carga de metodos
    public void saludar(){
        System.out.println("Hola que tal");
    }

    public void saludar(String nombre){
        System.out.println("Hola que tal "+nombre);
    }


        //Getters y setters

    public void modificar(String nombre) {
        this.nombre = nombre;
    }
}










//Declaracion del objeto con constructor con parametro vacios

// nombreClase objeto1= new constructor()
//java.util.Scanner
//Scanner entrada= new Scanner(System.in)

//Los getters y setters se lo declaran en la misma clase que los atributos privados, para