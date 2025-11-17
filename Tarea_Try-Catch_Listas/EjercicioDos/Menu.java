package EjercicioDos;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Menu
        System.out.print("------ MENU --------");
        System.out.print("\n1.Mostrar productos\n2.Mostrar el stock total\n3. Salir\n");
        System.out.print("Ingrese una opcion: ");
        String entrada = sc.nextLine();  // leer como texto

        try {
            int opcion = Integer.parseInt(entrada); // puede lanzar NumberFormatException
            switch (opcion) {
                case 1:
                    System.out.print("Papel Higienico\nDesinfectante para piso\nShampoo");
                    break;
                case 2:
                    System.out.print("El stock total: 189");
                    break;
                case 3:
                    System.out.println("Saliendo del programa....");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }

        catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un número válido.");

        }
    }
}
