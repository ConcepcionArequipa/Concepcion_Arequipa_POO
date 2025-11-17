package EjercicioUno;

import java.util.Scanner;

public class EjercicioUno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el precio del producto: ");
        String entrada = sc.nextLine();   // se lee como texto para convertir

        //Usar try-catch
        try {
            double precio = Double.parseDouble(entrada);
            if (precio < 0) {
                System.out.println("El precio no puede ser negativo");
            }
            else {
                double precioIva= precio + (precio*0.15);
                System.out.println("El precio con IVA (15%) es: " + precioIva);
            }

        }
        catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un número válido (no letras)");
        }
    }
}
