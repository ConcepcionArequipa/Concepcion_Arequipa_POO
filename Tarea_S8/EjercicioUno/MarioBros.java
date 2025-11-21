package EjercicioUno;

public class MarioBros extends Juego{
    private String personajePrincipal;
    private int numeroMundos;
    private int numeroNiveles;

    public MarioBros(String nombre, double precio, int anioLanzamiento, String personajePrincipal,int numeroMundos, int numeroNiveles) throws DatoInvalidoException{
        super(nombre, precio, anioLanzamiento);
        this.personajePrincipal = personajePrincipal;
        this.numeroMundos = numeroMundos;
        this.numeroNiveles = numeroNiveles;
    }
    @Override

    public void mostrarDetallesJuego(){
        System.out.println("----- DETALLES SOBRE EL JUEGO -----");
        System.out.println(super.toString()); //Muestra los datos generales
        System.out.println("Personaje principal del juego: " + personajePrincipal);
        System.out.println("Numero de mundos del juego: " + numeroMundos);
        System.out.println("Numero de niveles del juego: " + numeroNiveles);

    }

    public String getPersonajePrincipal() {
        return personajePrincipal;
    }

    public int getNumeroMundos() {
        return numeroMundos;
    }

    public int getNumeroNiveles() {
        return numeroNiveles;
    }
}

