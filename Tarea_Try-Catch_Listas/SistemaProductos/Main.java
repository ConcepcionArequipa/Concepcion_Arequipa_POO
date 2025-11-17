package SistemaProductos;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Producto> listaProductos = new ArrayList<>();
    public static void main(String[] args) {
        int opcion = 0;

        do {
            System.out.println("\n------- SISTEMA DE PRODUCTOS --------");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            String entrada = sc.nextLine();

            try {
                opcion = Integer.parseInt(entrada);

                switch (opcion) {
                    case 1:
                        registrarProducto();
                        break;

                    case 2:
                        mostrarProductos();
                        break;

                    case 3:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número entero válido.");
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }

        } while (opcion != 3);
    }

    // ------------------ MÉTODO PARA REGISTRAR ------------------
    public static void registrarProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        String precioTexto = sc.nextLine();

        try {
            double precio = Double.parseDouble(precioTexto);

            Producto p = new Producto(nombre, precio);
            listaProductos.add(p);

            System.out.println("Producto registrado exitosamente.");

        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un número válido para el precio.");
        } catch (IllegalArgumentException e) {
            System.out.println("Validación: " + e.getMessage());
        }
    }

    // ------------------ METODO PARA MOSTRAR ------------------
    public static void mostrarProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("No existen productos registrados.");
        } else {
            System.out.println("\n--- LISTA DE PRODUCTOS ---");
            for (Producto p : listaProductos) {
                System.out.println(p);
                System.out.println("-------------------");
            }
        }
    }
}
