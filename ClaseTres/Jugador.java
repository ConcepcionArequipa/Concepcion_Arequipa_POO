import java.util.Scanner;

public class Jugador {
    //Atributos
    String nombre;
    String pocision;
    int edad;
    int numero_camiseta;

    //Metodo constructor
    public Jugador(String nombre,String pocision,int edad, int numero_camiseta){
        this.nombre=nombre;
        this.pocision=pocision;
        this.edad=edad;
        this.numero_camiseta=numero_camiseta;
    }

    //Metodo para mostrar la informacion

    void mostrar(){
        System.out.println("Nombre del jugador: "+nombre+", pocision: "+pocision+", edad: "+edad+" y numero camiseta: "+numero_camiseta);
    }


    //Creacion del objeto

    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Ingrese el nombre del jugador: ");
        String nombre=sc.nextLine();

        System.out.println("Ingrese el pocision del jugador: ");
        String pocision=sc.nextLine();

        System.out.println("Ingrese el edad del jugador: ");
        int edad=sc.nextInt();

        System.out.println("Ingrese el numero camiseta: ");
        int numero_camiseta=sc.nextInt();

        Jugador jugador1=new Jugador(nombre,pocision ,edad,numero_camiseta);

        Jugador jugador2=new Jugador("Carlos","Delantero" ,21,4);

        Jugador jugador3=new Jugador("Juan","Defensa Central",25,5);

        jugador1.mostrar();
        jugador2.mostrar();
        jugador3.mostrar();

    }

}



