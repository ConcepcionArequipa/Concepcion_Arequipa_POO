package EjercicioCinco;
import java.util.ArrayList; //Para crear la lista
import java.util.Scanner;
public class AppProductos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Crear la lista
        ArrayList<Producto> lista = new ArrayList<>();
        int opcion = 0;
        while (opcion != 4) {

            System.out.println("\n===== MENÚ PRODUCTOS =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar lista de productos");
            System.out.println("3. Calcular promedio de precios finales");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {

                    case 1:
                        registrarProducto(sc, lista);
                        break;

                    case 2:
                        mostrarProductos(lista);
                        break;

                    case 3:
                        calcularPromedio(lista);
                        break;

                    case 4:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número válido.");

            } catch (Exception e) {
                System.out.println("Error general: " + e.getMessage());
            }

        }

    }
    // REGISTRAR PRODUCTO
    public static void registrarProducto(Scanner sc, ArrayList<Producto> lista) {

        try {
            System.out.print("Ingrese el código: ");
            String codigo = sc.nextLine();

            System.out.print("Ingrese el nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese el precio base: ");
            String textoPrecio = sc.nextLine();

            // Validar que el usuario no deje el precio vacío
            if (textoPrecio == null || textoPrecio.trim().isEmpty()) {
                throw new IllegalArgumentException("El precio base no puede estar vacío.");
            }

            double precio = Double.parseDouble(textoPrecio); // ahora sí convertir

            if (precio < 0) {
                throw new IllegalArgumentException("El precio base no puede ser negativo.");
            }

            System.out.println("Tipo de producto:");
            System.out.println("1. Nacional (IVA 12%)");
            System.out.println("2. Importado (Impuesto 5%)");
            System.out.print("Seleccione el tipo: ");
            int tipo = Integer.parseInt(sc.nextLine());

            Producto p;

            if (tipo == 1) {
                p = new ProductoNacional(codigo, nombre, precio);
            } else if (tipo == 2) {
                p = new ProductoImportado(codigo, nombre, precio);
            } else {
                throw new IllegalArgumentException("Tipo de producto inválido");
            }

            lista.add(p);
            System.out.println("Producto registrado correctamente.");

        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un número válido para el precio o el tipo.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    // MOSTRAR PRODUCTOS
    public static void mostrarProductos(ArrayList<Producto> lista) {
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }

        System.out.println("\n=== LISTA DE PRODUCTOS ===");
        for (Producto p : lista) {
            System.out.println(p);
        }
    }

    // CALCULAR PROMEDIO
    public static void calcularPromedio(ArrayList<Producto> lista)
            throws DatosInvalidosException {

        if (lista.isEmpty()) {
            throw new DatosInvalidosException("No se puede calcular promedio: la lista está vacía");
        }

        double suma = 0;
        for (Producto p : lista) {
            suma += p.calcularPrecioFinal();
        }

        double promedio = suma / lista.size();
        System.out.println("Promedio de precios finales: " + promedio);
    }
}


