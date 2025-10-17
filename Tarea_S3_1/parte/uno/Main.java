package parte.uno;

public class Main {
    public static void main(String[] args) {

        //Creacion del objeto
        Persona personaUno=new Persona();

        //Asignacion de valores correctos

        personaUno.setNombre("Concepcion");
        personaUno.setEdad(20);
        personaUno.setProfesion("Maestra de Ingles");

        //Muestra de los resultados

        System.out.println("-------------------------------------------------");
        System.out.println("Muestra de los resultados con valores correctos");
        System.out.println("Nombre: "+personaUno.getNombre());
        System.out.println("Edad: "+personaUno.getEdad());
        System.out.println("Profesion: "+personaUno.getProfesion());

        System.out.println("-----------------------------------------------");
        System.out.println("Asignacion de valores incorrectos");

        //Asignacion de valores incorrectos
        personaUno.setNombre("");
        personaUno.setEdad(-10);
        personaUno.setProfesion("");

        //Muestra de los resultados

        System.out.println("-------------------------------------------------");
        System.out.println("Muestra de los resultados con valores incorrectos");

        System.out.println("Nombre: "+personaUno.getNombre());
        System.out.println("Edad: "+personaUno.getEdad());
        System.out.println("Profesion: "+personaUno.getProfesion());


    }
}
