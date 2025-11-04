package ec.gob.subsidio.modelo;

public class SolicitanteSubsidio {
    //Atributos privados
    private String nombreCompleto;
    private String cedula;
    private double ingresosMensuales;
    private int cantidadVehiculos;
    private boolean viveEnEcuador;

    //Constructor que recibe todos los parametros
    public SolicitanteSubsidio(String nombreCompleto,String cedula, double ingresosMensuales, int cantidadVehiculos, boolean viveEnEcuador) {
        setNombreCompleto(nombreCompleto);
        setCedula(cedula);
        setIngresosMensuales(ingresosMensuales);
        setCantidadVehiculos(cantidadVehiculos);
        setViveEnEcuador(viveEnEcuador);
    }

    // Implementacion de getters para todos los atributos

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public double getIngresosMensuales() {
        return ingresosMensuales;
    }

    public int getCantidadVehiculos() {
        return cantidadVehiculos;
    }

    public boolean isViveEnEcuador() {
        return viveEnEcuador;
    }

    //Implementar setters para todos los atributos

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setIngresosMensuales(double ingresosMensuales) {
        //validar que el ingreso sea mayor o igual a $470.
        if (ingresosMensuales >= 470) {
            this.ingresosMensuales = ingresosMensuales;
        }
        else {
            System.out.println("Los ingresos mensuales no pueden ser menores a 470$");
        }
    }

    public void setCantidadVehiculos(int cantidadVehiculos) {
        //validar que el número sea positivo.
        if (cantidadVehiculos >= 0) {
            this.cantidadVehiculos = cantidadVehiculos;
        }
        else {
            System.out.println("La cantidad de vehiculos no puede ser negativa");
        }
    }

    public void setViveEnEcuador(boolean viveEnEcuador) {
        this.viveEnEcuador = viveEnEcuador;
    }

    //Otros metodos
    //subsidioAprobado(): retorna true si cumple los 3 requisitos.
    public boolean subsidioAprobado(){
        return ingresosMensuales <= 1200 && cantidadVehiculos<=1 && viveEnEcuador;
    }

    //generarResultado(): imprime si fue aprobado o rechazado, con motivos

    public void generarResultado(){
        if(subsidioAprobado()){System.out.println("Subsidio Aprobado");}
        else{
            System.out.println("Subsidio Rechazado");
            System.out.println("------- MOTIVOS -------");
            if(ingresosMensuales>1200){System.out.println("Debe tener ingresos mensuales menores o iguales a $1,200");}
            if(cantidadVehiculos>1){System.out.println("No puede poseer más de un vehículo registrado");}
            if(!viveEnEcuador){System.out.println("Debe tener residencia en Ecuador (no aplica para residentes en el extranjero)");}
        }
    }
    //toString(): muestra todos los datos del solicitante.

    @Override
    public String toString(){
        return "========= DATOS DEL SOLICITANTE ======="
                +"\nNombre: "+getNombreCompleto()
                +"\nCedula: "+getCedula()
                +"\nIngresos mensuales: "+getIngresosMensuales()
                +"\nCantidad de vehiculos: "+getCantidadVehiculos()
                +"\nVive en Ecuador: "+isViveEnEcuador();
    }

    //metodo estatico llamado mostrarReglasSubsidio()

    public static void mostrarReglasSubsidio(){
        System.out.println("------- REGLAS PARA RECIBIR EL SUBSIDIO -------");
        System.out.println("1. Tener ingresos mensuales menores o iguales a $1,200");
        System.out.println("2. No poseer más de un vehículo registrado");
        System.out.println("3. Tener residencia en Ecuador (no aplica para residentes en el extranjero)");
        System.out.print("==============================================================================");
    }

    //Crear dos métodos llamados calcularConsumoMensual()

    public double calcularConsumoMensual(){
        double kmMensuales = 180;
        return kmMensuales / 40; // Devuelve galones consumidos
    }

    public double calcularConsumoMensual(double kmExtra){
        double kmTotales = 180 + kmExtra;
        return kmTotales / 40;
    }

}
