package EjercicioUno;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionPrecios {

    public static void main(String[] args) {
        //Declarar un array list
        ArrayList<Double> precios = new ArrayList<Double>();
        //Usar un solo Scanner para todos los metodos
        Scanner sc = new Scanner(System.in);
        int opcion;
        //Menu repetitivo
        do{
            System.out.println("========== MENU DE PRECIOS INMOBILIARIOS ==========");
            System.out.println("1.Ingresar precio");
            System.out.println("2.Mostrar todos los precios");
            System.out.println("3.Mostrar precio más alto");
            System.out.println("4.Mostrar precio más bajo ");
            System.out.println("5.Mostrar precio iguales ");
            System.out.println("6.Buscar un precio específico ");
            System.out.println("7.Salir ");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    //Llamamos al metodo, aqui reutilizamos el objeto Scanner
                    ingresarPrecio(precios, sc);
                    break;
                case 2:
                    mostrarPrecios(precios);
                    break;
                case 3:
                    precioMasAlto(precios);
                    break;
                case 4:
                    precioMasBajo(precios);
                    break;
                case 5:
                    precioIguales(precios);
                    break;
                case 6:
                    buscarPrecio(precios,sc);
                    break;
                case 7:
                    System.out.println("Saliendo del programa .....");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        }
        while (opcion != 7);
    }

    public static void ingresarPrecio(ArrayList<Double> precios, Scanner sc) {

        System.out.print("Ingrese un precio: ");
        double precio = sc.nextDouble();
        if (precio <= 0) {
            System.out.println("El precio debe ser mayor que cero.");
        }
        else {
            precios.add(precio);
        }
    }

    public static void mostrarPrecios(ArrayList<Double> precios) {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados");
        }
        else {
            for (Double precio : precios) {
                System.out.println(precio);
            }
        }

    }

    public static void precioMasAlto(ArrayList<Double> precios) {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados");
        }
        else {
            double precioMasAlto = precios.get(0);
            for (int i = 1; i < precios.size(); i++) {
                if (precioMasAlto < precios.get(i)) {
                    precioMasAlto = precios.get(i);
                }
            }
            System.out.println("El precio mas alto es: "+precioMasAlto);
        }

    }

    public static void precioMasBajo(ArrayList<Double> precios) {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados");
        }
        else {
            double precioMasBajo = precios.get(0);
            for (int i = 1; i < precios.size(); i++) {
                if (precioMasBajo > precios.get(i)) {
                    precioMasBajo = precios.get(i);
                }
            }
            System.out.println("El precio mas bajo es: "+precioMasBajo);
        }

    }

    public static void precioIguales(ArrayList<Double> precios) {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados");
            return;
        }

        boolean hayRepetidos = false;
        ArrayList<Double> repetidosMostrados = new ArrayList<>();

        System.out.println("Buscando precios repetidos...");

        for (int i = 0; i < precios.size(); i++) {
            for (int j = i + 1; j < precios.size(); j++) {
                if (precios.get(i).equals(precios.get(j)) && !repetidosMostrados.contains(precios.get(i))) {
                    System.out.println("→ " + precios.get(i));
                    repetidosMostrados.add(precios.get(i));
                    hayRepetidos = true;
                }
            }
        }

        if (!hayRepetidos) {
            System.out.println("No existen precios repetidos.");
        }
    }

    public static void buscarPrecio(ArrayList<Double> precios, Scanner sc) {
        System.out.print("Ingrese el precio a buscar: ");
        double precioBuscado = sc.nextDouble();

        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados");
        }
        else {
            if (precios.contains(precioBuscado)) {
                System.out.println("Si se encontro el precio: "+precioBuscado);
            }
            else {
                System.out.println("No se encontro el precio");
            }
        }
    }


}
