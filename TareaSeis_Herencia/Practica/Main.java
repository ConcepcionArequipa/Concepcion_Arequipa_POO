package Practica;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- SISTEMA DE MATRICULACION VEHICULAR ");
        System.out.print("\nIngrese la placa del auto: ");
        String placaAuto = sc.nextLine();
        System.out.print("Ingrese la marca del auto: ");
        String marcaAuto = sc.nextLine();
        System.out.print("Ingrese el año del auto: ");
        int anioAuto = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el propietario del auto: ");
        String propietarioAuto = sc.nextLine();
        System.out.print("Ingrese el valor de auto: ");
        double valorAuto = sc.nextDouble();
        System.out.print("Ingrese el cilindraje del auto: ");
        double cilindrajeAuto = sc.nextDouble();

        //Crear 1 objeto por clase

        Auto auto1= new Auto(placaAuto,marcaAuto,anioAuto,propietarioAuto,valorAuto,cilindrajeAuto);

        System.out.print("EL valor de la matricula es: " + auto1.calcularValorMatricula());
        System.out.println("\n---------------------------------------------");

        sc.nextLine();

        System.out.print("Ingrese la placa del camion : ");
        String placaCamion = sc.nextLine();
        System.out.print("Ingrese la marca del camion: ");
        String marcaCamion = sc.nextLine();
        System.out.print("Ingrese el año del camion: ");
        int anioCamion = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el propietario del camion: ");
        String propietarioCamion = sc.nextLine();
        System.out.print("Ingrese el valor del camion : ");
        double valorCamion = sc.nextDouble();
        System.out.print("Ingrese la capacidad de toneladas del camion: ");
        double capacidadToneladas = sc.nextDouble();

        Camion camion1= new Camion(placaCamion,marcaCamion,anioCamion,propietarioCamion,valorCamion,capacidadToneladas);

        System.out.println("EL valor de la matricula del camion es: " + camion1.calcularValorMatricula());

        System.out.println("\n----------------------------------------------");
        sc.nextLine();

        System.out.print("\nIngrese la placa de la moto: ");
        String placaMoto = sc.nextLine();
        System.out.print("Ingrese la marca de la moto: ");
        String marcaMoto = sc.nextLine();
        System.out.print("Ingrese el año de la moto: ");
        int anioMoto = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el propietario: ");
        String propietarioMoto = sc.nextLine();
        System.out.print("Ingrese el valor de la moto: ");
        double valorMoto = sc.nextDouble();

        Moto moto1= new Moto(placaMoto,marcaMoto,anioMoto,propietarioMoto,valorMoto);

        System.out.println("EL valor de la matricula de la moto es: " + moto1.calcularValorMatricula());

        System.out.println("\n----------------------------------------------");


    }
}
