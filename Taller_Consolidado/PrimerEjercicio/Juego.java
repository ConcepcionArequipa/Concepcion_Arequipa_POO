package PrimerEjercicio;

public abstract class Juego {
    protected String nombre;
    protected double precio;
    protected int anioLanzamiento;

    //Metodo constructor

    public Juego(String nombre, double precio, int anioLanzamiento) throws DatoInvalidoException{

        this.nombre = nombre;
        this.precio = precio;
        this.anioLanzamiento = anioLanzamiento;
    }

    //Metodo abstracto

    public abstract void mostrarDetallesJuego();

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nPrecio: $" + precio +
                "\nAño de lanzamiento: " + anioLanzamiento;
    }


    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }
}
