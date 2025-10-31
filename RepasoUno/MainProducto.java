import empresa.inventario.modelo.Producto;
import java.util.Scanner;
public class MainProducto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Registro de Producto ===");
        System.out.print("Ingrese nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese código del producto: ");
        String codigo = sc.nextLine();

        System.out.print("Ingrese precio: ");
        double precio = sc.nextDouble();

        System.out.print("Ingrese cantidad en stock: ");
        int cantidad = sc.nextInt();

        System.out.print("¿Es perecible? (true/false): ");
        boolean perecible = sc.nextBoolean();

        // Crear objeto
        Producto producto = new Producto(nombre, codigo, precio, cantidad, perecible);

        // Mostrar datos y resultados
        System.out.println("\n" + producto);
        System.out.println("Valor total del stock: " + producto.calcularValorTotal());
        System.out.println("Valor total con descuento 10: " + producto.calcularValorTotal(10));

        System.out.println();
        producto.mostrarReglasProducto();
    }
}
