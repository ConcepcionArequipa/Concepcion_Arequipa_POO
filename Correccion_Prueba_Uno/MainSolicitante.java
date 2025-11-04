import java.util.Scanner;
import ec.gob.subsidio.modelo.SolicitanteSubsidio;
public class MainSolicitante {
    public static void main(String[] args) {

        //Llamar al metodo para mostrar las reglas del subsidio
        SolicitanteSubsidio.mostrarReglasSubsidio();
        System.out.println(); // Línea en blanco


        //Usar Scanner para pedir los datos: nombre, cédula, ingresos, vehículos, viveEnEcuador.
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su nombre completo: ");
        String nombreCompleto1= sc.nextLine();
        System.out.print("Ingrese su cedula: ");
        String cedula1= sc.nextLine();
        System.out.print("Ingrese sus ingresos mensuales: ");
        double ingresosMensuales1= sc.nextDouble();
        System.out.print("Ingrese la cantidad de vehiculos registrados: ");
        int cantidadVehiculos1= sc.nextInt();
        System.out.print("Vive en Ecuador? (True/False): ");
        boolean viveEcuador1= sc.nextBoolean();
        // Crear objeto usando constructor
        SolicitanteSubsidio solicitanteUno= new SolicitanteSubsidio(nombreCompleto1,cedula1,ingresosMensuales1,cantidadVehiculos1,viveEcuador1);
        //Mostrar los datos
        System.out.print( "\n" + solicitanteUno.toString() );


        //Mostrar el resultado
        System.out.print("\n====== RESULTADO DE LA EVALUACION =======");
        System.out.println(); // Línea en blanco
        solicitanteUno.generarResultado();
        //Llamar a los metodos sobrecargados
        System.out.print("\n====== CALCULO DE CONSUMO MENSUAL =======");
        System.out.println(); // Línea en blanco
        System.out.print("Consumo mensual estimado (sin km extra): "+ solicitanteUno.calcularConsumoMensual() );
        System.out.println(); // Línea en blanco
        System.out.print("Consumo con kilometros extra (80 km adicionales): "+ solicitanteUno.calcularConsumoMensual(80) );

        sc.close(); // Cerrar Scanner

    }
}
