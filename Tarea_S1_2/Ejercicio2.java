import java.util.Scanner;

//Ejercicio 2: Números pares
public class Ejercicio2 {
    public static void main(String[] args) {

        Scanner ingreso=new Scanner(System.in);

        //Contador para los numeros pares
        int contador_pares=0;

        //Pregunta cuántos números se van a ingresar.
        System.out.println("Cuantos numeros va a ingresar: ");
        int cantidad_numeros=ingreso.nextInt();

        //Usa un for para leer cada número.

        for(int i=1;i<cantidad_numeros+1;i++){

            System.out.println("Ingrese un numero: ");
            int numero=ingreso.nextInt();


            if(numero%2==0){
                contador_pares++; //Aumenta el contador si la condicion se cumple
            }
        }

        //Muestra cuántos números pares se ingresaron.

        System.out.println("La cantidad de pares es: "+contador_pares);
    }
}
