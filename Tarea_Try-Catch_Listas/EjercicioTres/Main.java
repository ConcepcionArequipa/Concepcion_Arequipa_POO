package EjercicioTres;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Ingrese el nombre del estudiante: ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese la edad del estudiante: ");
            String entradaEdad = sc.nextLine();

            int edad = Integer.parseInt(entradaEdad);  // podría lanzar NumberFormatException

            // Intentar crear el estudiante (aquí se validan el nombre y la edad)
            Estudiante estudiante = new Estudiante(nombre, edad);

            System.out.println("\nEstudiante creado con éxito:");
            System.out.println("Nombre: " + estudiante.getNombre());
            System.out.println("Edad: " + estudiante.getEdad());

        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un número válido para la edad.");

        } catch (IllegalArgumentException e) {
            // Errores de validación definidos en la clase Estudiante
            System.out.println("Error: " + e.getMessage());
        }
    }
}
