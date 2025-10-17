package parte.uno;

public class Persona {
    private String nombre;
    private int edad;
    private String profesion;

    public void setNombre(String nombre) {

        if (nombre.length()==0){
            System.out.println("Nombre invalido, esta vacio");
        }
        else{
            System.out.println("Nombre ingresado correctamente");
            this.nombre = nombre;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setEdad(int edad) {

        if (edad<=0){
            System.out.println("Edad invalida, debe ser mayor que 0");
        }
        else{
            System.out.println("Edad ingresada correctamente");
            this.edad = edad;
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setProfesion(String profesion) {

        if (profesion.length()==0){
            System.out.println("Profesion invalida, esta vacio");
        }
        else{
            System.out.println("Profesion ingresada correctamente");
            this.profesion = profesion;
        }
    }

    public String getProfesion() {
        return profesion;
    }
}



