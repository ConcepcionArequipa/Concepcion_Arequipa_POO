package Taller;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Creacion de los objetos
        Inventario productosElectronicos=new Inventario();
        productosElectronicos.mostrarInformacion();
        productosElectronicos.calcularStock();

        //Creacion del segundo objeto con Scanner

        Scanner entrada=new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto: ");
        String productoDos=entrada.nextLine();
        System.out.println("Ingrese la cantidad de productos disponibles: ");
        int cantidadDos=entrada.nextInt();
        System.out.println("Ingrese el precio unitario del producto: ");
        double precioDos=entrada.nextDouble();

        //Limpieza del buffer
        entrada.nextLine();

        System.out.println("Ingrese la categoria del producto: ");
        String categoriaDos=entrada.nextLine();
        Inventario productosLimpieza=new Inventario(productoDos,cantidadDos,precioDos,categoriaDos);
        productosLimpieza.mostrarInformacion();
        productosLimpieza.calcularStock();

    }
}
