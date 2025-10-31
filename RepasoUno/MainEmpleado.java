import java.util.Scanner;
import empresa.recursos.modelo.Empleado;
public class MainEmpleado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entrada de datos
        System.out.print("Ingrese nombre del empleado: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese cédula: ");
        String cedula = sc.nextLine();

        System.out.print("Ingrese salario mensual: ");
        double salario = sc.nextDouble();

        System.out.print("Ingrese años de antigüedad: ");
        int anios = sc.nextInt();

        System.out.print("¿Es gerente? (true/false): ");
        boolean gerente = sc.nextBoolean();

        // Crear objeto Empleado
        Empleado emp = new Empleado(nombre, cedula, salario, anios, gerente);

        // Mostrar datos
        System.out.println("\n" + emp.toString());

        // Generar resultado de bonificación
        emp.generarResultado();

        // Mostrar bonificación con extra
        double extra = 50;
        System.out.println("Bonificación con extra " + extra + ": " + emp.calcularBonificacion(extra));

        // Mostrar reglas de bonificación
        Empleado.mostrarReglasBonificacion();

        sc.close();
    }
}
