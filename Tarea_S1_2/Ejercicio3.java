
import java.util.Scanner;

//Ejercicio 3: Tabla de multiplicar
public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner ingreso=new Scanner(System.in);
        System.out.println("Ingrese un numero del 1 al 10: ");

        int numero=ingreso.nextInt();

        //Lee un número del 1 al 10.
        if(numero>=1 && numero<=10){

            //Imprime su tabla de multiplicar usando for.
            System.out.println("La tabla de multiplicar de "+numero);
            for(int i=1;i<=10;i++){
                System.out.println(numero+" x "+i+" = "+numero*i);
            }
        }
        else{
            System.out.println("El numero esta fuera del rango");
        }

    }
}
