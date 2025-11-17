package EjercicioCuatro;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProcesadorPagos procesador1 = new ProcesadorPagos();
        System.out.print("Ingrese el valor del monto a pagar: ");
        String entrada = sc.nextLine();
        try {
            double monto = Double.parseDouble(entrada);  // podría fallar si ponen letras

            procesador1.procesarPago(monto);

        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un número válido.");

        } catch (PagoInvalidoException e) {
            System.out.println("Error en el pago: " + e.getMessage());
        }

    }
}
