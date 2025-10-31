import ec.gob.beca.modelo.SolicitanteBeca;
import java.util.Scanner;
public class MainBeca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Solicitud de Beca Universitaria ===");
        System.out.print("Ingrese su nombre completo: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese su cédula: ");
        String cedula = sc.nextLine();

        System.out.print("Ingrese su promedio: ");
        double promedio = sc.nextDouble();

        System.out.print("Ingrese sus ingresos familiares: ");
        double ingresos = sc.nextDouble();

        System.out.print("¿Tiene recomendación? (true/false): ");
        boolean recomendacion = sc.nextBoolean();

        SolicitanteBeca solicitante = new SolicitanteBeca(nombre, cedula, promedio, ingresos, recomendacion);

        System.out.println("\n" + solicitante); // usa toString()
        solicitante.generarResultado();

        System.out.println("Horas de estudio recomendadas: " + solicitante.calcularHorasEstudio());
        System.out.println("Horas de estudio con extra 5: " + solicitante.calcularHorasEstudio(5));

        System.out.println("\n");
        SolicitanteBeca.mostrarReglasBeca();
    }
}
