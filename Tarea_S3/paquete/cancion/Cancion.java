package paquete.cancion;

public class Cancion {
    private String titulo;
    private double duracion;
    private int reproducciones;

    //Constructor vacio
    public Cancion(){}

    //Constructor con parametros
    public Cancion(String titulo, double duracion, int reproducciones){
        this.titulo=titulo;
        this.duracion=duracion;
        this.reproducciones=reproducciones;
    }


    //Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            System.out.println("Dato invalido, no puede estar vacio");}
        else {
            this.titulo=titulo;}
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        if (duracion<0) {
            System.out.println("Dato invalido, no puede ser negativo");}
        else {
            this.duracion=duracion;}
    }

    public int getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(int reproducciones) {
        if (reproducciones<0) {
            System.out.println("Dato invalido, no puede ser negativo");}
        else {
            this.reproducciones=reproducciones;}
    }

    public void reproducir(){
        this.reproducciones+=1;
    }

    public void mostrarCancion(){
        System.out.println("Informacion de la cancion ");
        System.out.println("Titulo: "+getTitulo());
        System.out.println("Duracion: "+getDuracion());
        System.out.println("Reproducciones: "+getReproducciones());
    }


}
