
//Creacion de la clase Libro
public class Libro {
    //Atributos
    String titulo;
    String autor;
    int anioPublicacion;

    //Metodo constructor
    public Libro(String titulo, String autor, int anioPublicacion){
        this.titulo=titulo;
        this.autor=autor;
        this.anioPublicacion=anioPublicacion;

    }

    //Metodo mostrarInformacion()

    void mostrarInformacion(){
        System.out.println("Titulo: "+titulo);
        System.out.println("Autor: "+autor);
        System.out.println("Anio de publicacion: "+anioPublicacion);
        System.out.println("----------------------------------------");
    }

    //Crear 2 objetos de tipo Libro y mostrar su información

    public static void main(String[] args){
        Libro libroUno= new Libro("El resplandor","Stephen King",1977);
        Libro libroDos= new Libro("Las hijas de la criada","Sonsoles Ónega",2023);
        libroUno.mostrarInformacion();
        libroDos.mostrarInformacion();
    }

}
