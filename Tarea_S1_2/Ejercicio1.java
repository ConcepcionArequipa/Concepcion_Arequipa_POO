import java.util.Scanner;
// Ejercicio 1: Notas del estudiante

public class Ejercicio1 {
    public static void main(String[] args) {

        //Pedir nombre del estudiante
        Scanner ingreso=new Scanner(System.in);
        System.out.println("Ingrese el nombre del estudiante: ");
        String nombre=ingreso.nextLine();

        // Solicitar tres notas (double)
        System.out.println("Ingrese la primera nota: ");
        double nota_Uno=ingreso.nextDouble();

        System.out.println("Ingrese la segunda nota: ");
        double nota_Dos=ingreso.nextDouble();

        System.out.println("Ingrese la tercera nota: ");
        double nota_Tres=ingreso.nextDouble();

        //Calcula el promedio

        double promedio_sin_redondear=(nota_Uno+nota_Dos+nota_Tres)/3;

        // Nota: Redondear el promedio a 2 decimales

        double factor = 100.0; // Para 2 decimales

        double promedio = Math.round(promedio_sin_redondear * factor) / factor;

        System.out.println("Su promedio es de: "+promedio);

        //Muestra si aprueba (>=7) o reprueba.
        if(promedio>=7){
            System.out.println(nombre+" aprobastes");
        }
        else{
            System.out.println(nombre+" reprobastes");
        }

    }
}

