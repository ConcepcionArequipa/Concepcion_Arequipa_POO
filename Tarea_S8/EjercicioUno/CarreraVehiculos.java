package EjercicioUno;

public class CarreraVehiculos extends Juego{
    private String tipoVehiculo;
    private String colorVehiculo;
    private int cantidadCircuitos;
    private int numeroVueltas;

    public CarreraVehiculos(String nombre, double precio, int anioLanzamiento, String tipoVehiculo,String colorVehiculo, int cantidadCircuitos, int numeroVueltas) throws DatoInvalidoException{
        super(nombre, precio, anioLanzamiento);

        this.tipoVehiculo = tipoVehiculo;
        this.colorVehiculo = colorVehiculo;
        this.cantidadCircuitos = cantidadCircuitos;
        this.numeroVueltas = numeroVueltas;
    }

    @Override
    public void mostrarDetallesJuego(){
        System.out.println("----- DETALLES SOBRE EL JUEGO -----");
        System.out.println(super.toString()); //Muestra los datos generales
        System.out.println("Tipo de vehiculo: " + tipoVehiculo);
        System.out.println("Color del vehiculo: " + colorVehiculo);
        System.out.println("Cantidad de circuitos en la carrera: " + cantidadCircuitos);
        System.out.println("Numero de vueltas en la carrera: " + numeroVueltas);

    }

    //Getters

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public String getColorVehiculo() {
        return colorVehiculo;
    }

    public int getCantidadCircuitos() {
        return cantidadCircuitos;
    }

    public int getNumeroVueltas() {
        return numeroVueltas;
    }
}
