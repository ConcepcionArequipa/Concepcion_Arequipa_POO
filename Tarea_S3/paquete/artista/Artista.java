package paquete.artista;

public class Artista {
    private String nombre;
    private String genero;
    private int seguidores;



    //Constructor con parametros
    public Artista(String nombre, String genero, int seguidores){
        this.nombre=nombre;
        this.genero=genero;
        this.seguidores=seguidores;
    }

    //Constructor vacio
    public Artista() {}


    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Dato invalido, no puede estar vacio");}
        else {
            this.nombre=nombre;}
    }

    public int getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(int seguidores) {
        if (seguidores<0) {
            System.out.println("Dato invalido, no puede ser negativo");}
        else {
            this.seguidores=seguidores;}
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (genero == null || genero.trim().isEmpty()) {
            System.out.println("Dato invalido, no puede estar vacio");}
        else {
            this.genero=genero;}
    }

    public void ganarSeguidores(int cantidad) {
        if (cantidad>0) {
            this.seguidores+=cantidad;
            System.out.println("El artista ha ganado " + cantidad + " nuevos seguidores.");
        }
        else {
            System.out.println("Dato invalido, deben ser mayor que 0");
        }
    }

    public void mostrarPerfil(){
        System.out.println("Informacion del artista");
        System.out.println("Nombre: "+getNombre());
        System.out.println("Genero: "+getGenero());
        System.out.println("Seguidores: "+getSeguidores());
    }
}
