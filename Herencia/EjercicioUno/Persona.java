package EjercicioUno;

//TEMA:HERENCIA
//Clase Padre de Persona

//Probar cuando una Clase no puede heredarse:

// Se lo hace mediante la palabra clave final:
//public class final Persona{};

public class Persona {
    String cedula;
    String nombre;
    int edad;

    //Crear el metodo constructor
    public Persona(String cedula, String nombre, int edad) {
        //Inicializar los atributos con this porque tienen el mismo nombre
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
    }

    //Crear un metodo
    public void imprimir() {
        System.out.println(" --------- DATOS PERSONALES --------------");
        System.out.println("Nombre: " + nombre + "\nCedula: " + cedula + "\nEdad: " + edad);
    }

}
